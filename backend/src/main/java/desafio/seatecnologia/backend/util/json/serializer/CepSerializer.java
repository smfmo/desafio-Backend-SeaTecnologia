package desafio.seatecnologia.backend.util.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class CepSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String valor,
                          JsonGenerator gerador,
                          SerializerProvider provedor) throws IOException {
        if (valor != null) {
            String cepFormatado = valor.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
            gerador.writeString(cepFormatado);
        }else {
            gerador.writeNull();
        }
    }
}
