package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Ejercicio 4: Serialización y deserialización de números personalizados Personalizar la serialización y deserialización de números.
 *
 * Crea una clase Producto con atributos nombre y precio.
 * Implementa un JsonSerializer y un JsonDeserializer que formateen el precio como una cadena con dos decimales en el JSON.
 */
public class Ex4SerializeNumbers {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Producto.class, (JsonSerializer<Producto>) (producto, type, jsonSerializationContext) -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("name",producto.getNombre());
                    jsonObject.addProperty("price",String.format(Locale.US,"%.2f", producto.getPrecio()));
                    return jsonObject;
                })
                .registerTypeAdapter(Producto.class, (JsonDeserializer<Object>) (jsonElement, type, jsonDeserializationContext) -> {
                    Producto producto = new Producto();
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    producto.setNombre(jsonObject.get("name").getAsString());
                    producto.setPrecio(Double.parseDouble(jsonObject.get("price").getAsString()));
                    return producto;
                })
                .setPrettyPrinting().create();

        Producto producto = new Producto("Laptop", 899.999);
        System.out.println(producto);

        String json = gson.toJson(producto);
        System.out.println(json);
        System.out.println(gson.fromJson(json,Producto.class));

    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto() {
    }

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString para imprimir la información del producto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto: \n");
        sb.append(" - Nombre: ").append(nombre).append("\n");
        sb.append(" - Precio: $").append(precio).append("\n");
        return sb.toString();
    }
}