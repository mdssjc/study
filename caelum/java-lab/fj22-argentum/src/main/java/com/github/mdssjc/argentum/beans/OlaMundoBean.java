package com.github.mdssjc.argentum.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

    private String nome;
    private String mensagem = "Quem é você?";

    public OlaMundoBean() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void nomeFoiDigitado() {
        System.out.println("\nChamou o botão");
    }
}
