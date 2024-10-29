package meteogaliza;

import com.google.gson.*;
import meteogaliza.enums.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Prediccion.class, (JsonDeserializer<Prediccion>) (jsonElement, type, jsonDeserializationContext) -> {
                    Prediccion prediccion = new Prediccion();
                    JsonObject jsonObject = jsonElement.getAsJsonObject().get("predConcello").getAsJsonObject();

                    prediccion.setConcello(jsonObject.get("idConcello").getAsInt());

                    JsonArray jsonArray = jsonObject.get("listaPredDiaConcello").getAsJsonArray();
                    for (JsonElement element : jsonArray) {
                        prediccion.addListaVariableFranxa(jsonDeserializationContext.deserialize(element, PrediccionDia.class));
                    }

                    return prediccion;
                })
                .registerTypeAdapter(PrediccionDia.class, (JsonDeserializer<PrediccionDia>) (jsonElement, type, jsonDeserializationContext) -> {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();

                    PrediccionDia prediccionDia = new PrediccionDia()
                            .setNivelAviso(jsonObject.get("nivelAviso").getAsInt())
                            .settMax(jsonObject.get("tMax").getAsInt())
                            .settMin(jsonObject.get("tMin").getAsInt())
                            .setUvMaz(jsonObject.get("uvMax").getAsInt());

                    LocalDateTime fechaDesdeCadena = LocalDateTime.parse(jsonObject.get("dataPredicion").getAsString());
                    prediccionDia.setDataPredicion(fechaDesdeCadena);



                    return prediccionDia;
                })
                .registerTypeAdapter(VariableFranxa.class, (JsonDeserializer<VariableFranxa>) (jsonElement, type, jsonDeserializationContext) -> {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();

                    VariableFranxa variableFranxa = new VariableFranxa()
                            .setValorManha(EstadoUtils.getEstadoPorCodigo(EstadoCeo.values(), jsonObject.get("manha").getAsInt()))
                            .setValorTarde(EstadoUtils.getEstadoPorCodigo(EstadoCeo.values(), jsonObject.get("noite").getAsInt()))
                            .setValorNoche(EstadoUtils.getEstadoPorCodigo(EstadoCeo.values(), jsonObject.get("tarde").getAsInt()));

                    return variableFranxa;
                })
                .setPrettyPrinting().create();

        Prediccion prediccion = new Prediccion();
        prediccion.setConcello(15071);
        PrediccionDia prediccionDia = new PrediccionDia()
                .setNivelAviso(0)
                .settMax(10)
                .settMin(1)
                .setUvMaz(12)
                .setDataPredicion(LocalDateTime.of(2024, 10, 29, 9, 46, 50))
                .addListaVariableFranxa(new VariableFranxa()
                        .setVariableMeteoroloxica(VariableMeteoroloxica.TEMPERATURA_MAXIMA)
                        .setValorManha(EstadoCeo.ANUBRADO_75)
                        .setValorTarde(EstadoCeo.BRE_TEMA)
                        .setValorNoche(EstadoCeo.NOITE_ANUBRADO_75))
                .addListaVariableFranxa(new VariableFranxa()
                        .setVariableMeteoroloxica(VariableMeteoroloxica.VIENTO)
                        .setValorManha(EstadoCeo.CUBERTO)
                        .setValorTarde(EstadoCeo.AUGA_NEVE)
                        .setValorNoche(EstadoCeo.NOITE_CHUVASCO))
                .addListaVariableFranxa(new VariableFranxa()
                        .setVariableMeteoroloxica(VariableMeteoroloxica.VIENTO)
                        .setValorManha(EstadoVento.VENTO_FORTE_LESTE)
                        .setValorTarde(EstadoVento.VENTO_FORTE_NOROESTE)
                        .setValorNoche(EstadoVento.VENTO_FROUXO_NOROESTE));

        prediccion.addListaVariableFranxa(prediccionDia);

        System.out.println(prediccion);

        Path path = Paths.get("src\\main\\resources\\meteogaliza.json");
        Prediccion prediccion1;
        try(var br = Files.newBufferedReader(path)){
            prediccion1 = gson.fromJson(br, Prediccion.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(prediccion1);

        System.out.println(EstadoUtils.getEstadoPorCodigo(EstadoCeo.values(), 101));
        String nome = EstadoUtils.getNomePorCodigo(EstadoCeo.values(), 101);
        System.out.println("Nome: " + nome);
    }
}
