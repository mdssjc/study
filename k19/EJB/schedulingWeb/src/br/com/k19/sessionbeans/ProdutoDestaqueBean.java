package br.com.k19.sessionbeans;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import br.com.k19.entidades.Produto;

@Singleton
public class ProdutoDestaqueBean {

    @EJB
    private ProdutoRepositorio repositorio;

    private Produto            produtoDestaque;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void trocarProdutoDestaque() {
        Random gerador = new Random();
        List<Produto> produtos = repositorio.getProdutos();
        int i = gerador.nextInt(produtos.size());
        produtoDestaque = produtos.get(i);
    }

    public Produto getProdutoDestaque() {
        return produtoDestaque;
    }

    public void setProdutoDestaque(Produto produtoDestaque) {
        this.produtoDestaque = produtoDestaque;
    }
}
