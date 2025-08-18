package view;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public void menuPrincipal(){
        int opcao = 0;
        do{
            System.out.println("1. Criar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Listar tarefas vencidas");
            System.out.println("5. Listar tarefa por prioridade");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
        }
        while(opcao !=0);
    }

}
