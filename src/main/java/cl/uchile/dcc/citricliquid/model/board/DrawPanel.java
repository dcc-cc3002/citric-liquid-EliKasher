package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;

/**
 * Class for the draw panel of the game.
 */
public class DrawPanel extends Panel {
  /**
   * Creates a new draw panel.
   */
  public DrawPanel() {
    super();
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel
   */
  @Override
  public String getType() {
    return "Draw";
  }

  /**
   * Executes the appropriate action to
   * the player according to this panel's type.
   *
   * @param player The main character of the game
   */
  @Override
  public void activatedBy(final Player player) {

  }

}
