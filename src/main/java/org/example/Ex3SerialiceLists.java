package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 3: Serialización y deserialización de listas Manejar una clase que contiene una lista de objetos.
 *
 * Añade a la clase Persona una lista de objetos Persona llamado amigos.
 * Implementa los serializadores y deserializadores para manejar la lista de amigos en el JSON.
 * Haz que la lista de amigos la represente como un array de objetos JSON.
 */
public class Ex3SerialiceLists {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PersonaAmigos.class, (JsonSerializer<PersonaAmigos>) (personaAmigos, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("name", personaAmigos.getNombre());
                    jsonObject.addProperty("age", personaAmigos.getEdad());
                    JsonArray jsonArray = new JsonArray();
                    personaAmigos.getAmigos().forEach(amigo -> {
                        JsonObject amigoJson = jsonSerializationContext.serialize(amigo, PersonaAmigos.class).getAsJsonObject();
                        jsonArray.add(amigoJson);
                    });
                    jsonObject.add("friends",jsonArray);
                    return jsonObject;
                })
                .registerTypeAdapter(PersonaAmigos.class, (JsonDeserializer<PersonaAmigos>) (jsonElement, type, jsonDeserializationContext) -> {
                    PersonaAmigos personaAmigos = new PersonaAmigos();
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    personaAmigos.setNombre(jsonObject.get("name").getAsString());
                    personaAmigos.setEdad(jsonObject.get("age").getAsInt());
                    jsonObject.get("friends").getAsJsonArray().forEach(amigo -> personaAmigos.addAmigo(jsonDeserializationContext.deserialize(amigo, PersonaAmigos.class)));
                    return personaAmigos;
                })
                .setPrettyPrinting().create();

        PersonaAmigos lua = new PersonaAmigos("Lua", 21);
        lua.addAmigo(new PersonaAmigos("Xian",21));
        lua.addAmigo(new PersonaAmigos("Lorena",22));
        String json = gson.toJson(lua);

        System.out.println(json);
        System.out.println(gson.fromJson(json,PersonaAmigos.class));

    }

}

class PersonaAmigos{
    private String nombre;
    private int edad;
    private List<PersonaAmigos> amigos;

    public PersonaAmigos() {
        amigos = new ArrayList<>();
    }

    public PersonaAmigos(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        amigos = new ArrayList<>();
    }

    public PersonaAmigos(String nombre, int edad, List<PersonaAmigos> amigos) {
        this.nombre = nombre;
        this.edad = edad;
        this.amigos = amigos;
    }

    public String getNombre() {
        return nombre;
    }

    public PersonaAmigos setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public PersonaAmigos setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public List<PersonaAmigos> getAmigos() {
        return amigos;
    }

    public PersonaAmigos addAmigo(PersonaAmigos personaAmigos){
        amigos.add(personaAmigos);
        return this;
    }

    public PersonaAmigos setAmigos(List<PersonaAmigos> amigos) {
        this.amigos = amigos;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(", ").append(edad).append("\n");
        amigos.forEach(sb::append);
        return sb.toString();
    }
}