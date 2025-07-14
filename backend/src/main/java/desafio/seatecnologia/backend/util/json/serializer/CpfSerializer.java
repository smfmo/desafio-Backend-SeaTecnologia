package desafio.seatecnologia.backend.util.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class CpfSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String valor,
                          JsonGenerator gerador,
                          SerializerProvider provedor) throws IOException {
        if (valor != null && !valor.isEmpty()) {
            String cpfFormatado = valor.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                    "$1.$2.$3-$4");
            gerador.writeString(cpfFormatado);
        } else {
            gerador.writeNull();
        }
    }
}
