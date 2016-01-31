package br.com.k19.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.element.concrete.Departamento;
import br.com.k19.element.concrete.Funcionario;
import br.com.k19.element.concrete.Gerente;
import br.com.k19.element.concrete.Telefonista;
import br.com.k19.visitor.AtualizadorDeFuncionario;
import br.com.k19.visitor.concrete.AtualizadorSalarial;

/**
 * Design Pattern
 * Behavioral - Visitor
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final List<Departamento> lista = new ArrayList<Departamento>();
    final Departamento departamento = new Departamento("Departamento 1");
    final Gerente gerente = new Gerente("Gerente 1", 1500, "1234");
    final Telefonista telefonista = new Telefonista("Telefonista", 1000, 2);
    departamento.getFuncionarios().add(gerente);
    departamento.getFuncionarios().add(telefonista);

    lista.add(departamento);

    final Departamento departamento2 = new Departamento("Departamento 2");
    final Gerente gerente2 = new Gerente("Gerente 2", 1800, "1234");
    final Gerente gerente3 = new Gerente("Gerente 3", 1800, "1234");
    final Telefonista telefonista2 = new Telefonista("Telefonista2", 1200, 1);
    departamento2.getFuncionarios().add(gerente2);
    departamento2.getFuncionarios().add(gerente3);
    departamento2.getFuncionarios().add(telefonista2);

    lista.add(departamento2);

    final AtualizadorDeFuncionario atualizador = new AtualizadorSalarial();

    for (final Departamento d : lista) {
      d.aceita(atualizador);
    }

    for (final Departamento d : lista) {
      for (final Funcionario f : d.getFuncionarios()) {
        System.out.println("Nome: " + f.getNome() + " - Salário: " + f.getSalario());
      }
    }
  }
}
