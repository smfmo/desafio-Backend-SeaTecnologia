package desafio.seatecnologia.backend.service;

import desafio.seatecnologia.backend.model.Cliente;
import desafio.seatecnologia.backend.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado com o id:" + id));
    }

    public Cliente atualizar(Long id,Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("cliente não encontrado"));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setEmails(clienteAtualizado.getEmails());
        clienteExistente.setTelefones(clienteAtualizado.getTelefones());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());

        return clienteRepository.save(clienteExistente);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
