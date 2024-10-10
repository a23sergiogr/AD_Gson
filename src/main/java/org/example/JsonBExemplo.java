package org.example;

import jakarta.json.JsonConfig;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.Serializable;

public class JsonBExemplo {

    public static void main(String[] args) {
        // Crear un objeto Java
        Persona persona = new Persona("Otto", 4, "Santiago de Compostela");

        // Crear un objeto Jsonb
        //Jsonb jsonb = JsonbBuilder.create();
        JsonbConfig config = new JsonbConfig();
        config.withFormatting(true);

        var jsonb = JsonbBuilder.newBuilder().withConfig(config).build();

        // Convertir el objeto Java a JSON
        String strJson = jsonb.toJson(persona);

        // Imprimir la cadena JSON
        System.out.println("JSON Resultante (JSON-B):");
        System.out.println(strJson);
    }

    // Clase de ejemplo
    public static class Persona implements Serializable {
        String nome;
        int idade;
        String cidade;

        public Persona() {
        }

        public Persona(String nome, int idade, String cidade) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

    }
}