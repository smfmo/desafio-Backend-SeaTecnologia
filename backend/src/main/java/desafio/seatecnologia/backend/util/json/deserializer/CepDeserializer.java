package desafio.seatecnologia.backend.util.json.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CepDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser analisador,
                              DeserializationContext contexto) throws IOException, JacksonException {
        String cep = analisador.getValueAsString();
        if (cep != null) {
            return cep.replaceAll("[^0-9]", "");
        }
        return null;
    }
}