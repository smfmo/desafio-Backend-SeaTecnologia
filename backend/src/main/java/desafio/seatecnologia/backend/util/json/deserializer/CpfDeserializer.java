package desafio.seatecnologia.backend.util.json.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CpfDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser analisador,
                              DeserializationContext contexto) throws IOException, JacksonException {
        String cpf = analisador.getValueAsString();
        if (cpf != null) {
            String cpfLimpo = cpf.replaceAll("[^0-9]", "");
            if (cpfLimpo.length() != 11) {
                throw new IllegalArgumentException("CPF dev conter 11 dígitos");
            }
            return cpfLimpo;
        }

        return null;
    }
}
