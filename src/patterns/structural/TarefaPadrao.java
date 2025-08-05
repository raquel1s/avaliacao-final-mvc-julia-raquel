package patterns.structural;

import model.Tarefa;

public class TarefaPadrao implements TarefaInterface{

    private TarefaInterface tarefa;

    public TarefaPadrao(TarefaInterface tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public String exibir() {
        return tarefa.toString();
    }
}
