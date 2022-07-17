package cl.uchile.dcc.citricliquid.model.board.abstracts;

import cl.uchile.dcc.citricliquid.model.board.Player;
import java.util.*;

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
  private final List<Panel> nextPanels = new ArrayList<>();
  /** The players on this panel. */
  private final List<Player> listOfPlayers = new ArrayList<>();
  /** The identification of the panel. */
  private final int id;
  /** The coordinates of the panel. */
  private final int[] coordinates;

  /** Creates a new panel.
   *
   * @param i The identification of the panel
   */
  public Panel(final int i) {
    this.id = i;
    coordinates = new int[2];
  }

  /**
   * New default panel.
   */
  public Panel() {
    this(0);
  }

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel.
   */
  public abstract String getType();

  /**
   * Gets the id of the panel.
   *
   * @return the id of this panel
   */
  public int getId() {
    return id;
  }

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
  public List<Panel> getNextPanels() {
    return List.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  public void addNextPanel(final Panel panel) {
    if (!panel.equals(this)) {
      nextPanels.add(panel);
    }
  }

  /**
   * Gets the players on this panel.
   *
   * @return the list of players on this panel
   */
  public List<Player> getListOfPlayers() {
    return listOfPlayers;
  }

  /**
   * Gets the copy of the players on this panel.
   *
   * @return The copy of the list of players on this panel
   */
  public Set<Player> getPlayers() {
    return Set.copyOf(listOfPlayers);
  }

  /**
   * Removes the said player from the panel.
   *
   * @param player It's the main character of the game
   */
  public void removePlayer(final Player player) {
    listOfPlayers.remove(player);
  }

  /**
   * Adds the said player to the panel.
   *
   * @param player The main character of the game
   */
  public void addPlayer(final Player player) {
    listOfPlayers.add(player);
  }

  /**
   * Gets the coordinates of the panel.
   *
   * @return An array of coordinates
   */
  public int[] getCoordinates() {
    return this.coordinates;
  }

  /**
   * Sets the coordinates of the panel.
   *
   * @param x The x coordinate
   * @param y The y coordinate
   */
  public void setCoordinates(final int x, final int y) {
    coordinates[0] = x;
    coordinates[1] = y;
  }

  /**
   * Generates a hashcode for the id of the panel.
   *
   * @return a number with the code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getClass());
  }

  /**
   * Gets if an object it's the same as this one.
   *
   * @param o An object
   * @return true if the objects are the same
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Panel panel)) {
      return false;
    }
    return getId() == panel.getId();
  }
}
