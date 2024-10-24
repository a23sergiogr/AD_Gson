package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5: Serialización y deserialización de arrays Manejar una clase que contiene un array de objetos.
 *
 * Añade a la clase persona un atributo hobbies.
 * Implementa los serializadores y deserializadores para manejar el array de hobbies en el JSON para que aparezca como una lista de cadenas de texto.
 */
public class Ex5SerializeArray {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Direccion.class, (JsonSerializer<Direccion>) (direccion, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("street", direccion.getCalle());
                    jsonObject.addProperty("city", direccion.getCiudad());
                    return jsonObject;
                })
                .registerTypeAdapter(Persona.class, (JsonSerializer<Persona>) (persona, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("nombre", persona.getNombre());
                    jsonObject.addProperty("edad", persona.getEdad());

                    jsonObject.add("direction", jsonSerializationContext.serialize(persona.getDireccion()));

                    JsonArray amigosArray = new JsonArray();
                    persona.getAmigos().forEach(amigo -> amigosArray.add(jsonSerializationContext.serialize(amigo)));
                    jsonObject.add("amigos", amigosArray);

                    JsonArray hobbiesArray = new JsonArray();
                    persona.getHobbies().forEach(hobby -> hobbiesArray.add(hobby.getNombre()));
                    jsonObject.add("hobbies", hobbiesArray);

                    return jsonObject;
                })
                .registerTypeAdapter(Direccion.class, (JsonDeserializer<Direccion>) (jsonElement, type, jsonDeserializationContext) -> {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    String calle = jsonObject.get("street").getAsString();
                    String ciudad = jsonObject.get("city").getAsString();
                    return new Direccion(calle, ciudad);
                })
                .registerTypeAdapter(Persona.class, (JsonDeserializer<Persona>) (jsonElement, type, jsonDeserializationContext) -> {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    String nombre = jsonObject.get("nombre").getAsString();
                    int edad = jsonObject.get("edad").getAsInt();

                    // Deserializar la dirección
                    Direccion direccion = jsonDeserializationContext.deserialize(jsonObject.get("direction"), Direccion.class);

                    // Deserializar amigos
                    List<Persona> amigos = new ArrayList<>();
                    if (jsonObject.has("amigos")) {
                        JsonArray amigosArray = jsonObject.get("amigos").getAsJsonArray();
                        for (JsonElement amigoElement : amigosArray) {
                            amigos.add(jsonDeserializationContext.deserialize(amigoElement, Persona.class));
                        }
                    }

                    // Deserializar hobbies
                    List<Hobby> hobbies = new ArrayList<>();
                    if (jsonObject.has("hobbies")) {
                        JsonArray hobbiesArray = jsonObject.get("hobbies").getAsJsonArray();
                        for (JsonElement hobbyElement : hobbiesArray) {
                            hobbies.add(new Hobby(hobbyElement.getAsString()));
                        }
                    }

                    return new Persona(nombre, edad, direccion, amigos, hobbies);
                })
                .setPrettyPrinting().create();

        // Crear la dirección de Lua
        Direccion direccionLua = new Direccion("Avenida Libertad", "Buenos Aires");

        // Crear hobbies de Lua
        List<Hobby> hobbiesLua = new ArrayList<>();
        hobbiesLua.add(new Hobby("Pintura"));
        hobbiesLua.add(new Hobby("Natación"));

        // Crear la persona Lua
        Persona lua = new Persona("Lua", 21, direccionLua, new ArrayList<>(), hobbiesLua);

        // Crear amigos de Lua
        Persona amigo1 = new Persona("Carlos", 22);
        amigo1.setDireccion(new Direccion("Calle 10", "Córdoba"));
        amigo1.addHobby(new Hobby("Correr"));
        amigo1.addHobby(new Hobby("Videojuegos"));

        Persona amigo2 = new Persona("Ana", 20);
        amigo2.setDireccion(new Direccion("Calle 20", "Rosario"));
        amigo2.addHobby(new Hobby("Danza"));
        amigo2.addHobby(new Hobby("Cocina"));

        // Añadir amigos a Lua
        lua.addAmigo(amigo1);
        lua.addAmigo(amigo2);

        // Crear amigos de Carlos
        Persona amigo1_1 = new Persona("Luis", 23);
        amigo1_1.setDireccion(new Direccion("Calle 30", "Mendoza"));
        amigo1_1.addHobby(new Hobby("Fútbol"));
        amigo1_1.addHobby(new Hobby("Fotografía"));

        Persona amigo1_2 = new Persona("Sofia", 21);
        amigo1_2.setDireccion(new Direccion("Calle 40", "La Plata"));
        amigo1_2.addHobby(new Hobby("Ciclismo"));
        amigo1_2.addHobby(new Hobby("Viajar"));

        // Añadir amigos a Carlos
        amigo1.addAmigo(amigo1_1);
        amigo1.addAmigo(amigo1_2);

        // Crear amigos de Ana
        Persona amigo2_1 = new Persona("Miguel", 19);
        amigo2_1.setDireccion(new Direccion("Calle 50", "San Juan"));
        amigo2_1.addHobby(new Hobby("Jardinería"));
        amigo2_1.addHobby(new Hobby("Música"));

        // Añadir amigos a Ana
        amigo2.addAmigo(amigo2_1);
        String json  = gson.toJson(lua);
        System.out.println(json);
        System.out.println(gson.fromJson(json, Persona.class));
    }
}

class Persona{
    private String nombre;
    private int edad;
    private Direccion direccion;
    private List<Persona> amigos;
    private List<Hobby> hobbies;

    public Persona() {
        amigos = new ArrayList<>();
        hobbies = new ArrayList<>();
    }

    public Persona(String nombre, int edad) {
        this();
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, Direccion direccion, List<Persona> amigos, List<Hobby> hobbies) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.amigos = amigos;
        this.hobbies = hobbies;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Persona setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Persona setDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public List<Persona> getAmigos() {
        return amigos;
    }

    public Persona addAmigo(Persona personaAmigos){
        amigos.add(personaAmigos);
        return this;
    }

    public Persona setAmigos(List<Persona> amigos) {
        this.amigos = amigos;
        return this;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public Persona addHobby(Hobby hobby) {
        hobbies.add(hobby);
        return this;
    }

    public Persona setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" ").append(edad).append("\n");    // Etiqueta para la edad
        sb.append("Dirección: ").append(direccion).append("\n"); // Etiqueta para la dirección

        // Lista de amigos
        sb.append("Amigos: ");
        if (amigos.isEmpty()) {
            sb.append("Ninguno\n"); // Mensaje si no hay amigos
        } else {
            amigos.forEach(amigo -> sb.append(amigo).append(", "));
            sb.setLength(sb.length() - 2); // Eliminar la última coma
            sb.append("\n");
        }

        // Lista de hobbies
        sb.append("Hobbies: ");
        if (hobbies.isEmpty()) {
            sb.append("Ninguno\n"); // Mensaje si no hay hobbies
        } else {
            hobbies.forEach(hobby -> sb.append(hobby.getNombre()).append(", "));
            sb.setLength(sb.length() - 2); // Eliminar la última coma
            sb.append("\n");
        }

        return sb.toString();
    }
}

class Hobby {
    private String nombre;

    public Hobby(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}