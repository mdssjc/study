package com.mysql.mdssjc.cdc_testes_automatizados_software.capitulo1;

public class TesteDoAvaliador {

  public static void main(final String[] args) {
    // cenário: 3 lances em ordem crescente
    final Usuario joao = new Usuario("Joao");
    final Usuario jose = new Usuario("José");
    final Usuario maria = new Usuario("Maria");

    final Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(maria, 250.0));
    leilao.propoe(new Lance(joao, 300.0));
    leilao.propoe(new Lance(jose, 400.0));

    // executando a ação
    final Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);

    // comparando a saída com o esperado
    final double maiorEsperado = 400;
    final double menorEsperado = 250;

    System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
    System.out.println(menorEsperado == leiloeiro.getMenorDeTodos());
  }
}
