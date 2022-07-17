package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * It's the class NeutralPanel, represents a neutral panel on the board.
 */
public class NeutralPanel extends Panel {
  /** The players on this panel. */
  private final List<Player> listOfPlayers = new ArrayList<>();

  /**
   * Creates a new drop panel.
   */
  public NeutralPanel() {
    super();
  }

  /**
   * Creates a new drop panel.
   *
   * @param id The identification of the panel
   */
  public NeutralPanel(final int id) {
    super(id);
  }

  /**
   * Gets the type of the panel.
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

  /**
   * Gets the players on this panel.
   *
   * @return the list of players on this panel
   */
  @Override
  public List<Player> getListOfPlayers() {
    return listOfPlayers;
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
    if (!(o instanceof final NeutralPanel panel)) {
      return false;
    }
    return getId() == panel.getId();
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
}
