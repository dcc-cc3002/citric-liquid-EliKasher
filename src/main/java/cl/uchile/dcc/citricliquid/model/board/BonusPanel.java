package cl.uchile.dcc.citricliquid.model.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import org.jetbrains.annotations.NotNull;


/**
 * Creates the class BonusPanel, represents a bonus panel on the board.
 */
public class BonusPanel extends Panel {
  /**
   * The maximum number of addable stars.
   */
  private static final int MAX_NUMBER_OF_STARS = 3;
  /**
   * The players on this panel.
   */
  private final List<Player> listOfPlayers = new ArrayList<>();

  /**
   * Creates a new bonus panel.
   *
   * @param id The identification of the panel
   */
  public BonusPanel(final int id) {
    super(id);
  }

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
    if (!(o instanceof final BonusPanel panel)) {
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
