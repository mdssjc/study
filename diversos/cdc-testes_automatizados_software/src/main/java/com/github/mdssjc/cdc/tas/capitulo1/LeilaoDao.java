package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.List;

public class LeilaoDao {

  // private static List<Leilao> db = new ArrayList<>();

  public void salva(final Leilao leilao) {
    // LeilaoDao.db.add(leilao);
  }

  public List<Leilao> encerrados() {
    return null;
    // return LeilaoDao.db.stream()
    // .filter(l -> l.isEncerrado())
    // .collect(Collectors.toList());
  }

  public List<Leilao> correntes() {
    return null;
    // return LeilaoDao.db.stream()
    // .filter(l -> !l.isEncerrado())
    // .collect(Collectors.toList());
  }

  public void atualiza(final Leilao leilao) {
    // if (LeilaoDao.db.contains(leilao)) {
    // LeilaoDao.db.set(LeilaoDao.db.indexOf(leilao), leilao);
    // } else {
    // salva(leilao);
    // }
  }
}
