package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * It's the class EncounterPanel, represents an encounter panel on the board.
 */
public class EncounterPanel extends Panel {
  /** The players on this panel. */
  private final List<Player> listOfPlayers = new ArrayList<>();

  /**
   * Creates a new encounter panel.
   */
  public EncounterPanel() {
    super();
  }

  /**
   * Creates a new encounter panel.
   *
   * @param id The identification of the panel
   */
  public EncounterPanel(final int id) {
    super(id);
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
    if (!(o instanceof final EncounterPanel panel)) {
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
