package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Ejercicio 2: Serialización y deserialización de objetos anidados Manejar una clase que contiene otro objeto como atributo.
 *
 * Crea una clase Direccion con atributos calle y ciudad. Añade un atributo de tipo Direccion.
 * Implementa los serializadores y deserializadores necesarios para manejar esta estructura de modo que la dirección tenga el nombre address y los atributos street y city.
 * Además, la dirección debe aparecer como una cadena de texto con el formato calle, ciudad.
 */
public class Ex2SerialiceObjects {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PersonaDireccion.class, (JsonSerializer<PersonaDireccion>) (persona, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("name", persona.getNombre());
                    jsonObject.addProperty("age", persona.getEdad());
                    jsonObject.addProperty("city", persona.getDireccion().getCiudad());
                    jsonObject.addProperty("street", persona.getDireccion().getCalle());
                    return jsonObject;
                })
                .registerTypeAdapter(PersonaDireccion.class, (JsonDeserializer<PersonaDireccion>) (jsonElement, type, jsonDeserializationContext) -> {
                    PersonaDireccion persona = new PersonaDireccion();
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    persona.setNombre(jsonObject.get("name").getAsString());
                    persona.setEdad(jsonObject.get("age").getAsInt());
                    persona.setDireccion(new Direccion(jsonObject.get("street").getAsString(),jsonObject.get("city").getAsString()));
                    return persona;
                })
                .setPrettyPrinting().create();


        String json = gson.toJson(new PersonaDireccion("Lua", 21, new Direccion("asados", "rianxo")));
        System.out.println(json);
        System.out.println(gson.fromJson(json, PersonaDireccion.class));
    }
}

class PersonaDireccion {
    private String nombre;
    private int edad;
    private Direccion direccion;

    public PersonaDireccion() {
    }

    public PersonaDireccion(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public PersonaDireccion setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public PersonaDireccion setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public PersonaDireccion setDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(", ").append(edad).append("\n");
        sb.append(direccion).append("\n");
        return sb.toString();
    }
}

class Direccion {
    private String calle;
    private String ciudad;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return  calle + ", " + ciudad;
    }
}