package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    private final List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> buscarTodos() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public void atualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    public boolean remover(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }

    public boolean existePorId(int id) {
        return clientes.stream().anyMatch(c -> c.getId() == id);
    }
}
