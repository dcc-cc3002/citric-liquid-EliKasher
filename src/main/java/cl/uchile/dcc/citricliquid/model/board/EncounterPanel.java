package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;

/**
 * It's the class EncounterPanel, represents an encounter panel on the board.
 */
public class EncounterPanel extends Panel {
  /**
   * Creates a new encounter panel.
   */
  public EncounterPanel() {
    super();
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel
   */
  @Override
  public String getType() {
    return "Encounter";
  }

  /**
   * Executes the appropriate action to the player
   * according to this panel's type.
   *
   * @param player The main character of the game
   */
  @Override
  public void activatedBy(final Player player) {

  }
}
