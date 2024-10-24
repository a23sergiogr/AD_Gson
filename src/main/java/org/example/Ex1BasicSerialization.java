package org.example;

import com.google.gson.*;

/**
 * Ejercicio 1: Serialización y deserialización básica Serializar y deserializar una clase sencilla con atributos básicos.
 * <p>
 * Crea una clase Persona con atributos nombre y edad.
 * Implementa un JsonSerializer y un JsonDeserializer para esta clase,
 * personalizando los nombres de los atributos en el JSON resultante,
 * de modo que aparezcan como name y age en formato JSON.
 */
public class Ex1BasicSerialization {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PersonaDireccion.class, (JsonSerializer<PersonaDireccion>) (persona, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("name", persona.getNombre());
                    jsonObject.addProperty("age", persona.getEdad());
                    return jsonObject;
                })
                .registerTypeAdapter(PersonaDireccion.class, (JsonDeserializer<PersonaDireccion>) (jsonElement, type, jsonDeserializationContext) -> {
                    PersonaDireccion persona = new PersonaDireccion();
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    persona.setNombre(jsonObject.get("name").getAsString());
                    persona.setEdad(jsonObject.get("age").getAsInt());
                    return persona;
                })
                .setPrettyPrinting().create();

        String json = gson.toJson(new PersonaBase("Lua", 21));
        System.out.println(json);
        System.out.println(gson.fromJson(json, PersonaBase.class));
    }
}

class PersonaBase{
    private String nombre;
    private int edad;

    public PersonaBase() {
    }

    public PersonaBase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public PersonaBase setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public PersonaBase setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(", ").append(edad);
        return sb.toString();
    }
}