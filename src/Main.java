import repository.ClienteRepository;
import service.ClienteService;
import ui.ClienteUI;

public class Main {
    public static void main(String[] args) {
        // inicialização das camadas
        ClienteRepository repository = new ClienteRepository();
        ClienteService service = new ClienteService(repository);
        ClienteUI ui = new ClienteUI(service);

        // inicia a aplicação
        ui.iniciar();
    }
}