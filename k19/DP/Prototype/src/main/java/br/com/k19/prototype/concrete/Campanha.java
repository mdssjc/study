package br.com.k19.prototype.concrete;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.com.k19.prototype.Prototype;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Concrete Prototype Class
 *
 * @author mdssjc
 *
 */
@AllArgsConstructor
public class Campanha implements Prototype<Campanha> {

  @Getter
  private final String      nome;
  @Getter
  private final Calendar    vencimento;
  @Getter
  private final Set<String> palavrasChave;

  @Override
  public Campanha getClone() {
    final String nome = "Cópia da Campanha: " + this.nome;
    final Calendar vencimento = (Calendar) this.vencimento.clone();
    final Set<String> palavrasChave = new HashSet<String>(this.palavrasChave);
    final Campanha campanha = new Campanha(nome, vencimento, palavrasChave);

    return campanha;
  }

  @Override
  public String toString() {
    final StringBuffer buffer = new StringBuffer();
    buffer.append("---------------");
    buffer.append("\n");
    buffer.append("Nome da Campanha: ");
    buffer.append(this.nome);
    buffer.append("\n");

    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
        "dd/MM/yyyy");
    final String format = simpleDateFormat.format(this.vencimento.getTime());
    buffer.append("Vencimento: " + format);
    buffer.append("\n");

    buffer.append("Palavras -chave: \n");
    for (final String palavraChave : this.palavrasChave) {
      buffer.append(" - " + palavraChave);
      buffer.append("\n");
    }
    buffer.append("---------------");
    buffer.append("\n");

    return buffer.toString();
  }
}
