package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stub de DAO.
 *
 */
public class LeilaoDao {

  private static List<Leilao> db = new ArrayList<>();

  public List<Leilao> correntes() {
    return LeilaoDao.db.stream()
                       .filter(l -> !l.isEncerrado())
                       .collect(Collectors.toList());
  }

  public void salva(final Leilao leilao1) {
    LeilaoDao.db.add(leilao1);
  }

  public void atualiza(final Leilao leilao) {
    if (LeilaoDao.db.contains(leilao)) {
      LeilaoDao.db.set(LeilaoDao.db.indexOf(leilao), leilao);
    } else {
      salva(leilao);
    }
  }

  public List<Leilao> encerrados() {
    return LeilaoDao.db.stream()
                       .filter(l -> l.isEncerrado())
                       .collect(Collectors.toList());
  }
}
