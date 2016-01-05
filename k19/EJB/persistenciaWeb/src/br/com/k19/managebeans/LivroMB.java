package br.com.k19.managebeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.entidades.Livro;
import br.com.k19.sessionbeans.LivroRepositorio;

@ManagedBean
public class LivroMB {

    @EJB
    private LivroRepositorio repositorio;

    private Livro            livro = new Livro();

    private List<Livro>      livrosCache;

    public void adiciona() {
        repositorio.adiciona(getLivro());
        setLivro(new Livro());
        livrosCache = null;
    }

    public List<Livro> getLivros() {
        if (livrosCache == null) {
            livrosCache = repositorio.getLivros();
        }

        return livrosCache;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
