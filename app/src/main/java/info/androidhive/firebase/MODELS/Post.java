package info.androidhive.firebase.MODELS;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties
public class Post {

    public String uid;
    public String author;
    public String marca;
    public String modelo;
    public String color;
    public String placas;
    public String servicio;
    public String ubicacion;
    public String fecha;
    public String hora;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String marca,
                String modelo, String color, String placas, String servicio, String ubicacion,
                String fecha, String hora) {
        this.uid = uid;
        this.author = author;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placas = placas;
        this.servicio = servicio;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.hora = hora;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("marca", marca);
        result.put("modelo", modelo);
        result.put("color", color);
        result.put("placas", placas);
        result.put("servicio", servicio);
        result.put("ubicacion", ubicacion);
        result.put("fecha", fecha);
        result.put("hora", hora);
        result.put("stars", stars);

        return result;
    }
    // [END post_to_map]

}
// [END post_class]
