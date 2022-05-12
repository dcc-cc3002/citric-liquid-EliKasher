package cl.uchile.dcc.citricliquid.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Example GUI controller.
 */
public class UiController {
  /** Welcoming text. */
  @FXML
  private Label welcomeText;

  /**
   * Welcomes the players to the application on click.
   */
  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}
