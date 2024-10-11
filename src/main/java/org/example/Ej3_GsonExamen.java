package org.example;



import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ej3_GsonExamen {
    public static void main(String[] args) throws IOException {
        ArrayList<String> est = new ArrayList<>();
        est.add("Margaret Sackville");
        est.add("Muriel Stuart");
        est.add("Elizabeth Daryush");
        est.add("Nancy Cunard");
        est.add("Mina Loy");

        Examen examen = new Examen("Materia", LocalDateTime.now(), est);

        JsonbConfig config = new JsonbConfig().withFormatting(true);

        var builder = JsonbBuilder.newBuilder().withConfig(config).build();

        builder.toJson(examen, Files.newBufferedWriter(Paths.get("Examen.js")));

//        try (var writer = new FileWriter("Examen.js")) {
//            String str = builder.toJson(examen);
//            System.out.println(str);
//            writer.write(str);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Examen ex2 = builder.fromJson(new FileReader("Examen.js"),Examen.class);
        System.out.println(ex2);
    }

    public static class Examen implements Serializable {
        private  String materia;
        private LocalDateTime fecha;
        private ArrayList<String> participantes;

        public Examen() {
        }

        public Examen(String materia, LocalDateTime fecha, ArrayList<String> participantes) {
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

        public LocalDateTime getFecha() {
            return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

        public ArrayList<String> getParticipantes() {
            return participantes;
        }

        public void setParticipantes(ArrayList<String> participantes) {
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
}

