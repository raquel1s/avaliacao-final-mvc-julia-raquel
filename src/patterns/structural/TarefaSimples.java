package patterns.structural;

import model.Tarefa;

public class TarefaSimples implements TarefaInterface{

    private Tarefa tarefa;

    public TarefaSimples(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public String exibir() {
        return tarefa.toString();
    }
}
