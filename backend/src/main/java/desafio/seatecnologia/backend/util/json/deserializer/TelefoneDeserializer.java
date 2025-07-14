package desafio.seatecnologia.backend.util.json.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class TelefoneDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser analisador,
                              DeserializationContext contexto) throws IOException, JacksonException {
        String telefone = analisador.getValueAsString();
        if (telefone != null) {
            return telefone.replaceAll("[^0-9]", "");
        }
        return null;
    }
}
