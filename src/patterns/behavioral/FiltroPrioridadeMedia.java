package patterns.behavioral;

import model.Prioridade;
import model.Tarefa;

public class FiltroPrioridadeMedia implements FiltroTarefaStrategy{
    @Override
    public boolean filtrar(Tarefa tarefa) {
        return tarefa.getPrioridade() == Prioridade.MEDIA;
    }
}
