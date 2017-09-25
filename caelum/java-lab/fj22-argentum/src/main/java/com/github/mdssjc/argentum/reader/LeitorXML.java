package com.github.mdssjc.argentum.reader;

import com.github.mdssjc.argentum.modelo.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;
import java.util.List;

public class LeitorXML {

  @SuppressWarnings("unchecked")
  public List<Negociacao> carrega(final InputStream inputStream) {
    final XStream stream = new XStream(new DomDriver());
    stream.alias("negociacao", Negociacao.class);
    return (List<Negociacao>) stream.fromXML(inputStream);
  }
}
