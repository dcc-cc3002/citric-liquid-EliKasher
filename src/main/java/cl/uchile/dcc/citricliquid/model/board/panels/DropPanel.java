package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.board.panels.abstracts.Panel;
import cl.uchile.dcc.citricliquid.model.board.players.Player;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * It's the class DropPanel, represents a drop panel on the board.
 */
public class DropPanel extends Panel {
  /**
   * The players on this panel.
   */
  private final List<Player> listOfPlayers = new ArrayList<>();

  /**
   * Creates a new drop panel.
   */
  public DropPanel() {
    super();
  }

  /**
   * Creates a new drop panel.
   *
   * @param id The identification of the panel
   */
  public DropPanel(final int id) {
    super(id);
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
