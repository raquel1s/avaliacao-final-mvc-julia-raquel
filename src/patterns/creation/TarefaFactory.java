package patterns.creation;

import model.Prioridade;
import model.Tarefa;

import java.time.LocalDate;

public abstract class TarefaFactory {

    public abstract Tarefa criarTarefa(String titulo, String descricao, Prioridade dificuldade, LocalDate prazoConclusao);
}
