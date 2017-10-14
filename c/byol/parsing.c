#include <stdio.h>
#include <stdlib.h>
#include "mpc.h"

#ifdef _WIN32
#include <string.h>

static char buffer[2048];

char* readline(char* prompt) {
  fputs(prompt, stdout);
  fgets(buffer, 2048, stdin);
  char* cpy = malloc(strlen(buffer)+1);
  strcpy(cpy, buffer);
  cpy[strlen(cpy)-1 = '\0'];
  return cpy;
}

void add_history(char* unused) {}

#else
#include <editline/readline.h>
#endif

/* Usa string operador para ver qual operacao executar */
long eval_op(long x, char* op, long y) {
  if (strcmp(op, "+") == 0) { return x + y; }
  if (strcmp(op, "-") == 0) { return x - y; }
  if (strcmp(op, "*") == 0) { return x * y; }
  if (strcmp(op, "/") == 0) { return x / y; }
  return 0;
}

long eval(mpc_ast_t* t) {

  /* Caso etiquetado como numero, retorna diretamente. */
  if (strstr(t->tag, "number")) {
    return atoi(t->contents);
  }

  /* O operador eh sempre o segundo filho. */
  char* op = t->children[1]->contents;

  /* Armazenamos o terceiro filho em `x` */
  long x = eval(t->children[2]);

  /* Itera sobre os filhos restantes, e combina resultado. */
  int i = 3;
  while (strstr(t->children[i]->tag, "expr")) {
    x = eval_op(x, op, eval(t->children[i]));
    i++;
  }

  return x;
}

int main(int argc, char *argv[argc]) {

  /* Cria Alguns Parsers */
  mpc_parser_t* Number   = mpc_new("number");
  mpc_parser_t* Operator = mpc_new("operator");
  mpc_parser_t* Expr     = mpc_new("expr");
  mpc_parser_t* Lispy    = mpc_new("lispy");

  /* Define eles com a seguinte linguagem */
  mpca_lang(MPCA_LANG_DEFAULT,
  "                                                      \
     number   : /-?[0-9]+/ ;                             \
     operator : '+' | '-' | '*' | '/' ;                  \
     expr     : <number> | '(' <operator> <expr>+ ')' ;  \
     lispy    : /^/ <operator> <expr>+ /$/ ;             \
  ", Number, Operator, Expr, Lispy);

  puts("Lispy Version 0.0.0.0.1");
  puts("Press Ctrl+c to Exit\n");

  while (1) {
    char* input = readline("lispy> ");
    add_history(input);

    /* Tenta Parsear/Analisar a Entrada */
    mpc_result_t r;
    if (mpc_parse("<stdin>", input, Lispy, &r)) {
      /* Caso Successo, Imprime a AST */
      long result = eval(r.output);
      printf("%li\n", result);
      mpc_ast_delete(r.output);
    } else {
      /* Senao, Imprime o Erro */
      mpc_err_print(r.error);
      mpc_err_delete(r.error);
    }

    free(input);
  }

  /* Desfaz as definições e deleta nossos Parsers */
  mpc_cleanup(4, Number, Operator, Expr, Lispy);

  return 0;
}
