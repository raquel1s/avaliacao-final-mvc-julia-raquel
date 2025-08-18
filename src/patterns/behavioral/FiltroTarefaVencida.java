package patterns.behavioral;

import model.Tarefa;

import java.time.LocalDate;

public class FiltroTarefaVencida implements FiltroTarefaStrategy{
    @Override
    public boolean filtrar(Tarefa tarefa) {
        return tarefa.getPrazoConclusao().isBefore(LocalDate.now());
    }
}
