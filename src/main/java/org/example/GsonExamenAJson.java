package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class GsonExamenAJson {
    private static final String ruta = "src/main/resources/accesoADatos.json";
    public static void main(String[] args) throws IOException {
        Examen examen = new Examen("AD",
                Date.from(
                        LocalDateTime.of(2023, 11, 12, 9, 45)
                        .atZone(ZoneId.systemDefault()).toInstant()),
                List.of("Estudiante1", "Estudiante2", "Estudiante3", "Estudiante4", "Estudiante5"));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        //gson.toJson(examen, new FileWriter(new File("accesoADatos.json")));
        try(var fw = new FileWriter(ruta)){
            gson.toJson(examen,fw);
        }

        try(var fr = new FileReader(ruta)){
            Examen ex = gson.fromJson(fr,Examen.class);
            System.out.println(ex);
        }
    }
}

class Examen{
    private String materia;
    private Date fecha;
    private List<String> participantes;

    public Examen(String materia, Date fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "materia='" + materia + '\'' +
                ", fecha=" + fecha +
                ", participantes=" + participantes +
                '}';
    }
}
