// Pacotes são agrupamentos lógico para classes.
// java e javax são internos da JDK, enquanto a URL reversão são de terceiros.
// wildcards (*) para importar todas as classes do pacote, implicitamente.
// o pacote java.lang é importado por padrão pela JVM.
/*
  A instrução de importar explicita possui precedência sobre a implícita.
  import java.util.Date;
  import java.sql.*;
*/
import java.util.*; // Importa a classe Random

public class Test {
  /*
    A função main é um 'hook' para o processo de inicialização da JVM.
    O tipo de retorno 'void' representa a função na qual altera o estado de execução do programa.
    Os argumentos (args) são inseridos após o nome do programa.
   */
  public static void main(String[] args) {
    // System.out.println(args[0]);
    // System.out.println(args[1]);

    Random r = new Random();
    System.out.println(r.nextInt(10));
  }
}
