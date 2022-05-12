package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;

/**
 * It's the class NeutralPanel, represents a neutral panel on the board.
 */
public class NeutralPanel extends Panel {
  /**
   * Creates a new drop panel.
   */
  public NeutralPanel() {
    super();
  }

  /**
   * Gets the type og the panel.
   *
   * @return the type of this panel
   */
  @Override
  public String getType() {
    return "Neutral";
  }

  /**
   * This method is for a neutral panel, it doesn't do anything to the player.
   *
   * @param player The main character of the game
   */
  @Override
  public void activatedBy(final Player player) {
  }
}
