package application;

import br.com.casadocodigo.livraria.produtos.Produto;
import dao.ProdutoDAO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @SuppressWarnings("unchecked")
  @Override
  public void start(final Stage primaryStage) {
    final Group group = new Group();
    final Scene scene = new Scene(group, 690, 510);
    scene.getStylesheets()
         .add(getClass().getResource("application.css")
                        .toExternalForm());

    final ObservableList<Produto> produtos = new ProdutoDAO().lista();
    final TableView<Produto> tableView = new TableView<>(produtos);

    final TableColumn<Produto, String> nomeColumn = criaColuna("Nome", 180,
        "nome");
    final TableColumn<Produto, String> descColumn = criaColuna("Descrição", 230,
        "descricao");
    final TableColumn<Produto, String> valorColumn = criaColuna("Valor", 60,
        "valor");
    final TableColumn<Produto, String> isbnColumn = criaColuna("ISBN", 180,
        "isbn");

    tableView.getColumns()
             .addAll(nomeColumn, descColumn, valorColumn, isbnColumn);

    final VBox vbox = new VBox(tableView);
    vbox.setId("vbox");

    final Label label = new Label("Listagem de Livros");
    label.setId("label-listagem");

    final Label progresso = new Label();
    progresso.setId("label-progresso");

    final Button button = new Button("Exportar CSV");
    button.setOnAction(
        event -> {
          final Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
              Thread.sleep(5000);
              exportaEmCSV(produtos);
              return null;
            }
          };

          task.setOnRunning(e -> progresso.setText("Exportando..."));
          task.setOnSucceeded(e -> progresso.setText("Concluído!"));

          new Thread(task).start();
        });

    double valorTotal = produtos.stream()
                                .mapToDouble(Produto::getValor)
                                .sum();
    Label labelFooter = new Label(
        String.format("Você tem R$%.2f em estoque, " +
            "com um total de %d produtos.", valorTotal, produtos.size()));
    labelFooter.setId("label-footer");

    group.getChildren()
         .addAll(label, vbox, button, progresso, labelFooter);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Sistema de livraria com Java FX");
    primaryStage.show();
  }

  private TableColumn<Produto, String> criaColuna(String titulo, int largura,
      String atributo) {
    final TableColumn<Produto, String> column = new TableColumn<>(titulo);
    column.setMinWidth(largura);
    column.setCellValueFactory(
        new PropertyValueFactory<Produto, String>(atributo));
    return column;
  }

  private void exportaEmCSV(final ObservableList<Produto> produtos) {
    try {
      new Exportador().paraCSV(produtos);
    } catch (final Exception e) {
      System.err.println("Erro ao exportar: " + e);
    }
  }

  public static void main(final String[] args) {
    launch(args);
  }
}
