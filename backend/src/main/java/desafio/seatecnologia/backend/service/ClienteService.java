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

    private final ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente nao encontrado com o id:" + id));
    }

    @Transactional
    public Cliente atualizar(Long id,Cliente clienteAtualizado) {
        Cliente clienteExistente =repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("cliente não encontrado"));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setEmails(clienteAtualizado.getEmails());
        clienteExistente.setTelefones(clienteAtualizado.getTelefones());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());

        return repository.save(clienteExistente);
    }

    public void excluir(Long id) {
       repository.deleteById(id);
    }
}
