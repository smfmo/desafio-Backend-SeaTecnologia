package desafio.seatecnologia.backend.controller.mappers;

import desafio.seatecnologia.backend.controller.dto.ClienteDto;
import desafio.seatecnologia.backend.controller.dto.EnderecoDto;
import desafio.seatecnologia.backend.controller.dto.TelefoneDto;
import desafio.seatecnologia.backend.model.Cliente;
import desafio.seatecnologia.backend.model.Endereco;
import desafio.seatecnologia.backend.model.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDto dto);
    ClienteDto toDto(Cliente cliente);

    Endereco toEntity(EnderecoDto enderecoDto);
    Telefone toEntity(TelefoneDto telefoneDto);
}
