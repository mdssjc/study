package mds.java.entity;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Task {
    private Long id;

    @NotNull
    @Size(min = 5)
    private String descricao;
    private boolean finalizado;
    private Calendar dataFinalizacao;

    public Task() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDescricao() {
	return this.descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public boolean getFinalizado() {
	return this.finalizado;
    }

    public void setFinalizado(boolean finalizado) {
	this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
	return this.dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
	this.dataFinalizacao = dataFinalizacao;
    }
}
