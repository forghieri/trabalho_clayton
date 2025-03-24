import aplication.dto.CompromissoDTO;
import aplication.service.AgendaService;
import domain.model.Agenda;
import infrastructure.console.ConsoleInput;
import infrastructure.console.ConsoleOutput;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        AgendaService service = new AgendaService(agenda);
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();

        while (true) {
            output.displayMenu();
            int option = input.getMenuOption();

            switch (option) {
                case 1:
                    CompromissoDTO dto = input.getCompromissoInput();
                    service.adicionarCompromisso(dto);
                    output.displaySuccess();
                    break;
                case 2:
                    Integer dias = input.getNumeroDias();
                    output.displayCompromissos(service.verificarCompromissos(dias), dias);
                    break;
                case 3:
                    output.displayExit();
                    input.close();
                    return;
                default:
                    output.displayError("Opção inválida!");
            }
        }
    }
}