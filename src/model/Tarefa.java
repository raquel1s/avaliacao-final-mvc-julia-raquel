package model;

import java.time.LocalDate;

public class Tarefa {

    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private LocalDate prazoConclusao;

    public Tarefa(String titulo, String descricao, Prioridade prioridade, LocalDate prazoConclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.prazoConclusao = prazoConclusao;
    }

    public String getTitulo() {
        return titulo;
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
        return "--Tarefa-- " +
                "\ntitulo: " + titulo +
                "\ndescricao: " + descricao +
                "\nprioridade: " + prioridade +
                "\nprazoConclusao: " + prazoConclusao;
    }
}
