package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Objective;
import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import org.jetbrains.annotations.NotNull;

/**
 * It's the class HomePanel, represents a home panel on the board.
 */
public class HomePanel extends Panel {
  /**
   * The owner of the panel.
   */
  private final Player owner;
  /**
   * The norma object that has the star objective.
   */
  private final StarsNorma sn = new StarsNorma();
  /**
   * The norma object that has the win objective.
   */
  private final WinsNorma wn = new WinsNorma();

  /**
   * Creates a new home panel with an owner.
   *
   * @param player The main character of the game
   */
  public HomePanel(final Player player) {
    super();
    owner = player;
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel
   */
  @Override
  public String getType() {
    return "Home";
  }

  /**
   * Restores a player's HP in 1.
   *
   * @param player The main character of the game.
   */
  private static void applyHealTo(final @NotNull Player player) {
    player.setCurrentHp(player.getCurrentHp() + 1);
  }

  /**
   * Executes the appropriate action to
   * the player according to this panel's type.
   *
   * @param player The main character of the game
   */
  @Override
  public void activatedBy(final Player player) {
    applyHealTo(player);
    Objective obj = player.getObj();
    if (obj.getObjective() == 0) {
      if (sn.normaCheck(player)) {
        player.normaClear();
        // Ver lo del cambio de obj
      }
    }
    if (obj.getObjective() == 1) {
      if (wn.normaCheck(player)) {
        player.normaClear();
        // Ver lo del cambio de obj
      }
    }
  }

  /**
   * Gets the owner of the panel.
   *
   * @return the owner of the home panel
   */
  public Player getOwner() {
    return owner;
  }
}
