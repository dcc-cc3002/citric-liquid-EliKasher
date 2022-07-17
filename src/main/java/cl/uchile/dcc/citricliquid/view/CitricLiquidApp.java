package cl.uchile.dcc.citricliquid.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Example JavaFX application.
 */
public class CitricLiquidApp extends Application {
  /** The width of the window. */
  private final int width = 320;
  /** The height of the window. */
  private final int height = 240;

  /**
   * Starts the game.
   *
   * @param args arguments
   */
  public static void main(final String[] args) {
    launch();
  }

  /**
   * The method to make run the application.
   *
   * @param stage the primary stage for this application, onto which
   *              the application scene can be set.
   *              Applications may create other stages, if needed, but they will not be
   *              primary stages.
   * @throws IOException An exception
   */
  @Override
  public void start(final @NotNull Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
        CitricLiquidApp.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), width, height);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }
}
