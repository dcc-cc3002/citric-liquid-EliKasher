package cl.uchile.dcc.citricliquid.model.board.abstracts;

import cl.uchile.dcc.citricliquid.model.Player;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a panel in the board of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio
 *     Slater Muñoz</a>.
 * @version 1.1.222804
 * @since 1.0
 */
public abstract class Panel {
  /** The following panels. */
  private final Set<Panel> nextPanels = new HashSet<>();

  /** Creates a new panel. */
  public Panel() {
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel.
   */
  public abstract String getType();


  /**
   * Executes the appropriate action to the player
   * according to this panel's type.
   *
   * @param player The main character of the game.
   */
  public abstract void activatedBy(Player player);

  /**
   * Gets a copy of the next panels.
   *
   * @return a copy of this panel's next ones.
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

}
