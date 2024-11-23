package ui;

import model.Cliente;
import service.ClienteService;

import java.util.Scanner;

public class ClienteUI {
    private final ClienteService service;
    private final Scanner scanner;

    public ClienteUI(ClienteService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                processarOpcao(opcao);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 6);
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarCliente();
            case 2 -> listarClientes();
            case 3 -> atualizarCliente();
            case 4 -> removerCliente();
            case 5 -> buscarClientePorId();
            case 6 -> System.out.println("Saindo do sistema...");
            default -> System.out.println("Opção inválida!");
        }
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Remover Cliente");
        System.out.println("5. Buscar Cliente por ID");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

//    cadastrar cliente
    private void cadastrarCliente() {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(id, nome, email, telefone);
        service.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

//    listar cliente
    private void listarClientes() {
        System.out.println("\n=== Lista de Clientes ===");
        var clientes = service.listarTodos();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        clientes.forEach(System.out::println);
    }

//    atualizar cliente
    private void atualizarCliente() {
        System.out.println("\n=== Atualização de Cliente ===");
        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        var clienteOpt = service.buscarPorId(id);
        if (clienteOpt.isEmpty()) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        Cliente cliente = clienteOpt.get();
        System.out.print("Novo nome (" + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) cliente.setNome(nome);

        System.out.print("Novo email (" + cliente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) cliente.setEmail(email);

        System.out.print("Novo telefone (" + cliente.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) cliente.setTelefone(telefone);

        service.atualizarCliente(cliente);
        System.out.println("Cliente atualizado com sucesso!");
    }

    // deletar cliente
    private void removerCliente() {
        System.out.println("\n=== Remoção de Cliente ===");
        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();

        if (service.removerCliente(id)) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }


    // buscar cliente por ID
    private void buscarClientePorId() {
        System.out.println("\n=== Buscar Cliente por ID ===");
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        var clienteOpt = service.buscarPorId(id);

        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            System.out.println("\nCliente encontrado:");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
