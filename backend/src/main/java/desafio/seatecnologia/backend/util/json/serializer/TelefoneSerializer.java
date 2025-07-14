package desafio.seatecnologia.backend.util.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class TelefoneSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String valor,
                          JsonGenerator gerador,
                          SerializerProvider provedor) throws IOException {
        if (valor != null) {
            String telefoneFormatado;
            if (valor.length() == 11) {
                telefoneFormatado = valor.replaceAll("(\\d{2})(\\d{5})(\\d{4})",
                        "($1) $2-$3");
            } else {
                telefoneFormatado = valor.replaceAll("(\\d{2})(\\d{4})(\\d{4})",
                        "($1) $2-$3");
            }
            gerador.writeString(telefoneFormatado);
        } else {
            gerador.writeNull();
        }
    }
}
