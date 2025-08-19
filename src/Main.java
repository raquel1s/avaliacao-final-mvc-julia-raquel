import controller.TarefaController;
import model.Prioridade;
import model.Tarefa;
import patterns.creation.TarefaFactory;
import patterns.creation.TarefaPadrao;
import view.Menu;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final  TarefaFactory factory = new TarefaPadrao();
    private static final TarefaController controller = new TarefaController(factory);


    public static void main(String[] args) {
        int opcao = 0;

        do {
            Menu.menuPrincipal();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> criarTarefa();
                case 2 -> listarTarefas();
                case 3 -> marcarTarefaConcluida();
                case 4 -> listarVencidas();
                case 5 -> filtrarPorPrioridade();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
            }
        } while (opcao != 0);

    }

    private static void filtrarPorPrioridade() {
        System.out.println("---Filtrar tarefa por Prioridade---");
        System.out.println("1. BAIXA");
        System.out.println("2. MÉDIA");
        System.out.println("3. ALTA");
        System.out.println("Informe a prioridade que deseja listar: ");
        int prioridade = sc.nextInt();
        sc.nextLine();

        switch (prioridade) {
            case 1 -> {
                for(Tarefa tarefa : controller.tarefasPrioridadeBaixa()){
                    if(!tarefa.isConcluida()){
                        System.out.println(tarefa);
                    }
                }
            }
            case 2 -> {
                for(Tarefa tarefa : controller.tarefasPrioridadeMedia()){
                    if(!tarefa.isConcluida()){
                        System.out.println(tarefa);
                    }
                }
            }
            case 3 -> {
                for(Tarefa tarefa : controller.tarefasPrioridadeAlta()){
                    if(!tarefa.isConcluida()){
                        System.out.println(tarefa);
                    }
                }
            }
            default -> {
                System.out.println("Valor inválido!");
            }
        }
    }

    private static void listarVencidas() {
        System.out.println("---Tarefas Vencidas---");

        for(Tarefa tarefa : controller.tarefasVencidas()){
            System.out.println(tarefa);
        }
    }

    private static void marcarTarefaConcluida() {
        System.out.println("---Marcar tarefa como Concluída---");

        for(Tarefa tarefa : controller.listarTodasTarefas()){
            if(!tarefa.isConcluida()){
                System.out.println(tarefa);
            }
        }

        System.out.println("Informe o Titulo da tarefa que deseja concluir: ");
        String titulo = sc.nextLine();

        for(Tarefa tarefa: controller.listarTodasTarefas()){
            if(tarefa.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println(controller.concluirTarefa(tarefa));
            }
        }
    }

    private static void listarTarefas() {
        for(Tarefa tarefa : controller.listarTodasTarefas()){
            if(tarefa.isConcluida()){
                System.out.println(controller.concluirTarefa(tarefa));
            }else{
                System.out.println(tarefa);
            }
        }
    }

    private static void criarTarefa() {
        System.out.println("---Criar Tarefa---");
        System.out.println("Informe o Título da tarefa: ");
        String titulo = sc.nextLine();

        System.out.println("Informe a Descrição da tarefa: ");
        String descricao = sc.nextLine();

        System.out.println("Informe o nível de Prioridade: ");
        System.out.println("1. BAIXA");
        System.out.println("2. MÉDIA");
        System.out.println("3. ALTA");
        int prioridadeNUM = sc.nextInt();
        sc.nextLine();

        Prioridade prioridade = Prioridade.BAIXA;

        switch (prioridadeNUM){
            case 1 -> prioridade = Prioridade.BAIXA;
            case 2 -> prioridade = Prioridade.MEDIA;
            case 3 -> prioridade = Prioridade.ALTA;
        }

        System.out.println("Informe o dia para o Prazo da tarefa: ");
        int dia = sc.nextInt();
        sc.nextLine();

        System.out.println("Informe o mês para o Prazo da tarefa: ");
        int mes = sc.nextInt();
        sc.nextLine();

        int ano = LocalDate.now().getYear();
        LocalDate prazo = LocalDate.of(ano, mes, dia);

        controller.criarTarefa(titulo, descricao, prioridade, prazo);

    }
}