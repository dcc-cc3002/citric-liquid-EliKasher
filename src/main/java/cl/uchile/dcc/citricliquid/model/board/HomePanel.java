package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.controller.handler.HomePanelHandler;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import org.jetbrains.annotations.NotNull;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** It's the class HomePanel, represents a home panel on the board. */
public class HomePanel extends Panel {
  /** The owner of the panel. */
  private final Player owner;
  /** The norma object that has the star objective.*/
  private final StarsNorma sn = new StarsNorma();
  /** The norma object that has the win objective. */
  private final WinsNorma wn = new WinsNorma();
  /** The players on this panel. */
  private final List<Player> listOfPlayers = new ArrayList<>();
  /** The notification that indicates if the player is on their home panel. */
  private PropertyChangeSupport homePanelNotification =
      new PropertyChangeSupport(this);

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
   * Creates a new home panel with an owner.
   *
   * @param player The main character of the game
   * @param id The identification of the panel
   */
  public HomePanel(final Player player, final int id) {
    super(id);
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
   * Listens for the player arriving at
   * their correspondent home panel.
   *
   * @param homePanelHandler The handler for a
   *                        player arriving to their home panel
   */
  public void homeListener(final HomePanelHandler homePanelHandler) {
    homePanelNotification.addPropertyChangeListener(homePanelHandler);
  }

  /**
   * Gets the owner of the panel.
   *
   * @return the owner of the home panel
   */
  public Player getOwner() {
    return owner;
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
    if (!(o instanceof final HomePanel panel)) {
      return false;
    }
    return getId() == panel.getId()
        && getOwner().equals(panel.getOwner());
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
