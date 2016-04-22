package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.List;

public interface RepositorioDeLeiloes {

  void salva(Leilao leilao);

  List<Leilao> encerrados();

  List<Leilao> correntes();

  void atualiza(Leilao leilao);

}
