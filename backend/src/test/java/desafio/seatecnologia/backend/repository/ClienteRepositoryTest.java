package desafio.seatecnologia.backend.repository;

import desafio.seatecnologia.backend.model.Cliente;
import desafio.seatecnologia.backend.model.Endereco;
import desafio.seatecnologia.backend.model.Telefone;
import desafio.seatecnologia.backend.model.enums.TipoTelefone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    @Transactional
    public void deveSalvarClienteComSucesso(){

        Cliente cliente = criarClienteTest();
        Cliente clienteSalvo = clienteRepository.save(cliente);

        assertNotNull(clienteSalvo.getId());
        assertEquals(cliente.getNome(), clienteSalvo.getNome());
        assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
        assertEquals(cliente.getEndereco(), clienteSalvo.getEndereco());
        assertEquals(cliente.getTelefones().get(0), clienteSalvo.getTelefones().get(0));
        assertEquals(cliente.getTelefones().get(1), clienteSalvo.getTelefones().get(1));
        assertEquals(cliente.getEmails().get(0), clienteSalvo.getEmails().get(0));
        assertEquals(cliente.getEmails().get(1), clienteSalvo.getEmails().get(1));

    }

    @Test
    @Transactional
    public void deveBuscarClientePorId(){

        Cliente clienteSalvo = clienteRepository.save(criarClienteTest());
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(clienteSalvo.getId());
        System.out.println("cliente encontrado: \n" + clienteEncontrado);

        assertTrue(clienteEncontrado.isPresent());
        assertEquals(clienteSalvo.getNome(), clienteEncontrado.get().getNome());
        assertEquals(clienteSalvo.getCpf(), clienteEncontrado.get().getCpf());
    }

    @Test
    @Transactional
    public void deveAtualizarCliente(){

        Cliente clienteSalvo = clienteRepository.save(criarClienteTest());
        clienteSalvo.setNome("novo nome");
        Cliente clienteAtualizado = clienteRepository.save(clienteSalvo);

        assertEquals("novo nome", clienteAtualizado.getNome());
        System.out.println("cliente atualizado: \n" + clienteAtualizado);
    }

    @Test
    @Transactional
    public void deveExcluirCliente(){

        Cliente clienteSalvo = clienteRepository.save(criarClienteTest());
        clienteRepository.deleteById(clienteSalvo.getId());

        Optional<Cliente> clienteExcluido = clienteRepository.findById(clienteSalvo.getId());
        assertFalse(clienteExcluido.isPresent());

    }

    private Cliente criarClienteTest(){// metodo utilitário
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Logradouro-Test");
        endereco.setBairro("Bairro-Test");
        endereco.setCep("CEP-Test");
        endereco.setLocalidade("Localidade-Test");
        endereco.setUf("UF");
        endereco.setComplemento("Complemento-Test");

        Telefone telefone1 = new Telefone();
        telefone1.setNumero("61 91234-5678");
        telefone1.setTipo(TipoTelefone.COMERCIAL);

        Telefone telefone2 = new Telefone();
        telefone2.setNumero("61 91234-5678");
        telefone2.setTipo(TipoTelefone.CELULAR);

        Cliente cliente = new Cliente();
        cliente.setNome("Samuel Monteiro");
        cliente.setCpf("12345678901");
        cliente.setEndereco(endereco);
        cliente.setTelefones(new ArrayList<>(Arrays.asList(telefone1, telefone2)));
        cliente.setEmails(new ArrayList<>(Arrays.asList("smf.ferreira1901@gmail.com", "smf.monteiro1701@gmail.com")));

        return cliente;
    }

}