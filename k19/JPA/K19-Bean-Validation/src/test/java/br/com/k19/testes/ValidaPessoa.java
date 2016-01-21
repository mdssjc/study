package br.com.k19.testes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.k19.modelo.Pessoa;

public class ValidaPessoa {

  public static void main(final String[] args) {
    final Pessoa p = new Pessoa();
    p.setNome(null);

    final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    final Validator validator = validatorFactory.getValidator();

    final Set<ConstraintViolation<Pessoa>> errors = validator.validate(p);

    for (final ConstraintViolation<Pessoa> error : errors) {
      System.out.println(error);
    }
  }
}
