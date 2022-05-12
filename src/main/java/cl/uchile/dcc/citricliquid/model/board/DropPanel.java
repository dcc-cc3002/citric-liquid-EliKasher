package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import org.jetbrains.annotations.NotNull;

/**
 * It's the class DropPanel, represents a drop panel on the board.
 */
public class DropPanel extends Panel {
  /**
   * Creates a new drop panel.
   */
  public DropPanel() {
    super();
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel
   */
  @Override
  public String getType() {
    return "Drop";
  }

  /**
   * Reduces the player's star count by the D6
   * roll multiplied by the player's norma level.
   *
   * @param player The main character of the game.
   */
  private static void applyDropTo(final @NotNull Player player) {
    player.reduceStarsBy(player.roll() * player.getNormaLevel());
  }

  /**
   * Executes the appropriate action to the
   * player according to this panel's type.
   *
   * @param player The main character of the game.
   */
  @Override
  public void activatedBy(final Player player) {
    applyDropTo(player);
  }
}
