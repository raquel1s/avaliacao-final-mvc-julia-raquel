package patterns.behavioral;

import model.Prioridade;
import model.Tarefa;

public class FiltroPrioridadeBaixa implements FiltroTarefaStrategy{
    @Override
    public boolean filtrar(Tarefa tarefa) {
        return tarefa.getPrioridade() == Prioridade.BAIXA;
    }
}
