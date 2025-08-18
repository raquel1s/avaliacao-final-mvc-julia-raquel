import controller.TarefaController;
import model.Prioridade;
import model.Tarefa;
import patterns.creation.TarefaFactory;
import patterns.creation.TarefaPadrao;
import view.Menu;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                case 1 -> {
                    criarTarefa();
                }
                case 2 -> {
                    listarTarefas();
                }
                case 3 -> {
//                    marcarTarefaConcluida();
                }
                case 4 -> {
//                    listarVencidas();
                }
                case 5 -> {
//                    filtrarPorPrioridade();
                }
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
            }
        }
        while (opcao != 0);

    }

    private static void listarTarefas() {

        for(Tarefa tarefa : controller.listarTodasTarefas()){
            System.out.println(tarefa);
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

        controller.criarTarefa(titulo, descricao,prioridade,prazo);

    }
}