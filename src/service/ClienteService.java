package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void cadastrarCliente(Cliente cliente) throws IllegalArgumentException {
        if (repository.existePorId(cliente.getId())) {
            throw new IllegalArgumentException("Cliente com ID " + cliente.getId() + " já existe");
        }

        validarDadosCliente(cliente);
        repository.salvar(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.buscarTodos();
    }

    public Optional<Cliente> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void atualizarCliente(Cliente cliente) throws IllegalArgumentException {
        validarDadosCliente(cliente);

        if (!repository.existePorId(cliente.getId())) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        repository.atualizar(cliente);
    }

    public boolean removerCliente(int id) {
        return repository.remover(id);
    }

    private void validarDadosCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        if (cliente.getEmail() == null || !cliente.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }
    }
}