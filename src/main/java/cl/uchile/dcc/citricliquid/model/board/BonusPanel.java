package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import org.jetbrains.annotations.NotNull;

/**
 * Creates the class BonusPanel, represents a bonus panel on the board.
 */
public class BonusPanel extends Panel {
  /** The maximum number of addable stars. */
  private static final int MAX_NUMBER_OF_STARS = 3;

  /**
   * Creates a new bonus panel.
   */
  public BonusPanel() {
    super();
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel
   */
  @Override
  public String getType() {
    return "Bonus";
  }

  /**
   * Reduces the player's star count by the D6 roll
   * multiplied by the maximum between the player's
   * norma level and three.
   *
   * @param player The main character of the game
   */
  private static void applyBonusTo(final @NotNull Player player) {
    player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(),
        MAX_NUMBER_OF_STARS));
  }

  /**
   * Executes the appropriate action to the player
   * according to this panel's type.
   *
   * @param player The main character of the game
   */
  @Override
  public void activatedBy(final Player player) {
    applyBonusTo(player);
  }
}
