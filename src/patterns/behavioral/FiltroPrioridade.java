package patterns.behavioral;

import model.Tarefa;

public class FiltroPrioridade implements  FiltroTarefaStrategy{

     @Override
    public boolean filtrar(Tarefa tarefa) {
        return false;
    }
}
