package patterns.behavioral;

import model.Prioridade;
import model.Tarefa;

public class FiltroPrioridadeAlta implements  FiltroTarefaStrategy{

     @Override
    public boolean filtrar(Tarefa tarefa) {
        return tarefa.getPrioridade() == Prioridade.ALTA;
    }
}
