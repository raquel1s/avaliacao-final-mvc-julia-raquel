package patterns.behavioral;

import model.Tarefa;

public interface FiltroTarefaStrategy {
    boolean filtrar(Tarefa tarefa);
}
