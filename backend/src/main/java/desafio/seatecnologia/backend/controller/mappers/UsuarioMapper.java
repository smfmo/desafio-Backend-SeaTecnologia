package desafio.seatecnologia.backend.controller.mappers;

import desafio.seatecnologia.backend.controller.dto.UsuarioDto;
import desafio.seatecnologia.backend.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDto dto);
}
