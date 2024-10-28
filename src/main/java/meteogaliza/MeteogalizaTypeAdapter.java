package meteogaliza;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class MeteogalizaTypeAdapter extends TypeAdapter<Prediccion> {
    @Override
    public void write(JsonWriter jsonWriter, Prediccion prediccion) throws IOException {

    }

    @Override
    public Prediccion read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
