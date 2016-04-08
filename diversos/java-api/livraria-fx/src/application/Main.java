package application;

import br.com.casadocodigo.livraria.produtos.Produto;
import dao.ProdutoDAO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class Main extends Application {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void start(final Stage primaryStage) {
    final Group group = new Group();
    final Scene scene = new Scene(group, 690, 510);

    final ObservableList<Produto> produtos = new ProdutoDAO().lista();
    final TableView<Produto> tableView = new TableView<>(produtos);

    final TableColumn nomeColumn = new TableColumn("Nome");
    nomeColumn.setMinWidth(180);
    nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));

    final TableColumn descColumn = new TableColumn("Descrição");
    descColumn.setMinWidth(230);
    descColumn.setCellValueFactory(new PropertyValueFactory("descricao"));

    final TableColumn valorColumn = new TableColumn("Valor");
    valorColumn.setMinWidth(60);
    valorColumn.setCellValueFactory(new PropertyValueFactory("valor"));

    final TableColumn isbnColumn = new TableColumn("ISBN");
    isbnColumn.setMinWidth(180);
    isbnColumn.setCellValueFactory(new PropertyValueFactory("isbn"));

    tableView.getColumns()
             .addAll(nomeColumn, descColumn, valorColumn, isbnColumn);

    final VBox vbox = new VBox(tableView);
    vbox.setPadding(new Insets(70, 0, 0, 10));

    final Label label = new Label("Listagem de Livros");
    label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 30));
    label.setPadding(new Insets(20, 0, 10, 10));

    final Label progresso = new Label();
    progresso.setLayoutX(485);
    progresso.setLayoutY(30);

    final Button button = new Button("Exportar CSV");
    button.setLayoutX(575);
    button.setLayoutY(25);
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

    group.getChildren()
         .addAll(label, vbox, button, progresso);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Sistema de livraria com Java FX");
    primaryStage.show();
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
