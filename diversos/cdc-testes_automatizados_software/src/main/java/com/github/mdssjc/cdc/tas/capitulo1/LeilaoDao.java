package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.List;

public class LeilaoDao implements RepositorioDeLeiloes {

  // private static List<Leilao> db = new ArrayList<>();

  /*
   * (non-Javadoc)
   *
   * @see
   * com.github.mdssjc.cdc.tas.capitulo1.RepositorioDeLeiloes#salva(com.github.
   * mdssjc.cdc.tas.capitulo1.Leilao)
   */
  @Override
  public void salva(final Leilao leilao) {
    // LeilaoDao.db.add(leilao);
  }

  /*
   * (non-Javadoc)
   *
   * @see com.github.mdssjc.cdc.tas.capitulo1.RepositorioDeLeiloes#encerrados()
   */
  @Override
  public List<Leilao> encerrados() {
    return null;
    // return LeilaoDao.db.stream()
    // .filter(l -> l.isEncerrado())
    // .collect(Collectors.toList());
  }

  /*
   * (non-Javadoc)
   *
   * @see com.github.mdssjc.cdc.tas.capitulo1.RepositorioDeLeiloes#correntes()
   */
  @Override
  public List<Leilao> correntes() {
    return null;
    // return LeilaoDao.db.stream()
    // .filter(l -> !l.isEncerrado())
    // .collect(Collectors.toList());
  }

  /*
   * (non-Javadoc)
   *
   * @see com.github.mdssjc.cdc.tas.capitulo1.RepositorioDeLeiloes#atualiza(com.
   * github.mdssjc.cdc.tas.capitulo1.Leilao)
   */
  @Override
  public void atualiza(final Leilao leilao) {
    // if (LeilaoDao.db.contains(leilao)) {
    // LeilaoDao.db.set(LeilaoDao.db.indexOf(leilao), leilao);
    // } else {
    // salva(leilao);
    // }
  }
}
