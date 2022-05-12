package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a panel in the board of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>.
 * @version 1.1.222804
 * @since 1.0
 */
public class Panel {
  private final PanelType type;
  private final Set<Panel> nextPanels = new HashSet<>();

  /**
   * Creates a new panel.
   *
   * @param type the type of the panel.
   */
  public Panel(final PanelType type) {
    this.type = type;
  }

  /**
   * Restores a player's HP in 1.
   */
  private static void applyHealTo(final @NotNull Player player) {
    player.setCurrentHp(player.getCurrentHp() + 1);
  }

  /**
   * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
   */
  private static void applyDropTo(final @NotNull Player player) {
    player.reduceStarsBy(player.roll() * player.getNormaLevel());
  }

  /**
   * Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
   * norma level and three.
   */
  private static void applyBonusTo(final @NotNull Player player) {
    player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
  }

  /**
   * Returns the type of this panel.
   */
  public PanelType getType() {
    return type;
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  public Set<Panel> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  public void addNextPanel(final Panel panel) {
    nextPanels.add(panel);
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  public void activatedBy(final Player player) {
    switch (type) {
      case BONUS -> applyBonusTo(player);
      case DROP -> applyDropTo(player);
      case HOME -> applyHealTo(player);
      default -> {
      }
    }
  }
}
