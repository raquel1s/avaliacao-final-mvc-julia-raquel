package controller;

import model.Prioridade;
import model.Tarefa;
import patterns.behavioral.FiltroPrioridadeAlta;
import patterns.behavioral.FiltroPrioridadeBaixa;
import patterns.behavioral.FiltroPrioridadeMedia;
import patterns.behavioral.FiltroTarefaVencida;
import patterns.creation.TarefaFactory;
import patterns.structural.DecoratorTarefaConcluida;
import patterns.structural.TarefaSimples;

import java.time.LocalDate;
import java.util.ArrayList;

public class TarefaController {

    private TarefaFactory tarefafactory;
    private ArrayList<Tarefa> tarefas;

    public TarefaController(TarefaFactory tarefafactory) {
        this.tarefafactory = tarefafactory;
        this.tarefas = new ArrayList<>();
    }

    public Tarefa criarTarefa(String titulo, String descricao, Prioridade prioridade, LocalDate prazoConclusao){
        if(titulo == null){
            System.err.println("\nO título é obrigatório!");
            return null;
        }

        if(prazoConclusao == null || prazoConclusao.isBefore(LocalDate.now())){
            System.err.println("\nA data inserida não é válida!");
            return null;
        }

        if(descricao == null){
            System.err.println("\nA descrição inserida não é válida!");
            return null;
        }

        if(prioridade == null){
            System.err.println("\nA prioridade inserida não é válida!");
            return null;
        }

        Tarefa tarefa = tarefafactory.criarTarefa(titulo, descricao, prioridade, prazoConclusao);
        tarefas.add(tarefa);
        System.out.println("\nTarefa criada com sucesso!");

        return tarefa;
    }

    public ArrayList<Tarefa> listarTodasTarefas(){
        return tarefas;
    }

    public String concluirTarefa(Tarefa tarefa){
        tarefa.setConcluida(true);
        TarefaSimples tarefaSimples = new TarefaSimples(tarefa);
        DecoratorTarefaConcluida tarefaConcluida = new DecoratorTarefaConcluida(tarefaSimples);

       return tarefaConcluida.exibir();
    }

    public ArrayList<Tarefa> tarefasVencidas(){
        ArrayList<Tarefa> tarefasVencidas = new ArrayList<>();
        FiltroTarefaVencida vencido = new FiltroTarefaVencida();

        for(Tarefa t : tarefas){
            if(vencido.filtrar(t) && !(t.isConcluida())){
                tarefasVencidas.add(t);
            }
        }

        return tarefasVencidas;
    }

    public ArrayList<Tarefa> tarefasPrioridadeAlta(){
        ArrayList<Tarefa> tarefasPrioridadeAlta = new ArrayList<>();
        FiltroPrioridadeAlta alta = new FiltroPrioridadeAlta();

        for(Tarefa t : tarefas){
            if(alta.filtrar(t)){
                tarefasPrioridadeAlta.add(t);
            }
        }

        return tarefasPrioridadeAlta;
    }

    public ArrayList<Tarefa> tarefasPrioridadeMedia(){
        ArrayList<Tarefa> tarefasPrioridadeMedia = new ArrayList<>();
        FiltroPrioridadeMedia media = new FiltroPrioridadeMedia();

        for(Tarefa t : tarefas){
            if(media.filtrar(t)){
                tarefasPrioridadeMedia.add(t);
            }
        }

        return tarefasPrioridadeMedia;
    }

    public ArrayList<Tarefa> tarefasPrioridadeBaixa(){
        ArrayList<Tarefa> tarefasPrioridadeBaixa = new ArrayList<>();
        FiltroPrioridadeBaixa baixa = new FiltroPrioridadeBaixa();

        for(Tarefa t : tarefas){
            if(baixa.filtrar(t)){
                tarefasPrioridadeBaixa.add(t);
            }
        }

        return tarefasPrioridadeBaixa;
    }
}
