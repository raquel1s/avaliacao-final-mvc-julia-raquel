package patterns.structural;

import model.Tarefa;

public class DecoratorTarefaConcluida implements TarefaInterface{

    private TarefaInterface tarefa;

    public DecoratorTarefaConcluida(TarefaInterface tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public String exibir() {
        return tarefa.exibir() + "\n[CONCLUÍDA]";
    }
}
