package desafio.seatecnologia.backend.model;

import lombok.Data;

import javax.persistence.Embeddable;
@Data
@Embeddable
public class Endereco {

    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String uf;

    private String complemento;

}
