package meteogaliza;

import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Prediccion prediccion = new Prediccion();
        PrediccionDia prediccionDia = new PrediccionDia()
                .setNivelAviso(0)
                .settMax(10)
                .settMin(1)
                .setUvMaz(12)
                .setDataPredicion(new Date("12/12/12"))
                .addListaVariableFranxa(new VariableFranxa()
                        .setVariableMeteoroloxica(VariableMeteoroloxica.TEMPERATURA_MAXIMA)
                        .setValorManha(EstadoMeteoroloxico.ANUBRADO_75)
                        .setValorTarde(EstadoMeteoroloxico.BRE_TEMA)
                        .setValorNoche(EstadoMeteoroloxico.CHUVASCO_NEVE));

        prediccion.addListaVariableFranxa(prediccionDia);

        System.out.println(prediccion);

    }
}
