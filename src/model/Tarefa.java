package model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Tarefa {

    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private LocalDate prazoConclusao;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, Prioridade prioridade, LocalDate prazoConclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.prazoConclusao = prazoConclusao;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade dificuldade) {
        this.prioridade = dificuldade;
    }

    public LocalDate getPrazoConclusao() {
        return prazoConclusao;
    }

    public void setPrazoConclusao(LocalDate prazoConclusao) {
        this.prazoConclusao = prazoConclusao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "--Tarefa-- " +
                "\nTítulo: " + titulo +
                "\nDescricao: " + descricao +
                "\nPrioridade: " + prioridade +
                "\nPrazo de Conclusao: " + prazoConclusao.format(formatoBrasil) + "\n";
    }
}
