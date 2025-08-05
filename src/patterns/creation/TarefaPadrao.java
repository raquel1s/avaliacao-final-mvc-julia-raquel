package patterns.creation;

import model.Prioridade;
import model.Tarefa;

import java.time.LocalDate;

public class TarefaPadrao extends TarefaFactory{

    @Override
    public Tarefa criarTarefa(String titulo, String descricao, Prioridade dificuldade, LocalDate prazoConclusao) {
        return new Tarefa(titulo, descricao, dificuldade, prazoConclusao);
    }
}
