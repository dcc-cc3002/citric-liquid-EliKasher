package cl.uchile.dcc.citricliquid.model.board.panels.interfaces;

import cl.uchile.dcc.citricliquid.model.board.panels.abstracts.Panel;
import cl.uchile.dcc.citricliquid.model.board.players.Player;
import java.util.List;

/**
 * The interface for the panels of the game.
 */
public interface IPanel {
  /**
   * Gets the id of the panel.
   *
   * @return the id of this panel
   */
  int getId();

  /**
   * Gets the type of the panel.
   *
   * @return the type of this panel.
   */
  String getType();

  /**
   * Executes the appropriate action to the player
   * according to this panel's type.
   *
   * @param player The main character of the game.
   */
  void activatedBy(Player player);

  /**
   * Gets a copy of the next panels.
   *
   * @return a copy of this panel's next ones.
   */
  List<Panel> getNextPanels();

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  void addNextPanel(Panel panel);

  /**
   * Gets the players on this panel.
   *
   * @return the list of players on this panel
   */
  List<Player> getListOfPlayers();

  /**
   * Gets the copy of the players on this panel.
   *
   * @return The copy of the list of players on this panel
   */
  List<Player> getPlayers();

  /**
   * Removes the said player from the panel.
   *
   * @param player It's the main character of the game
   */
  void removePlayer(Player player);

  /**
   * Adds the said player to the panel.
   *
   * @param player The main character of the game
   */
  void addPlayer(Player player);

  /**
   * Gets the coordinates of the panel.
   *
   * @return An array of coordinates
   */
  int[] getCoordinates();

  /**
   * Sets the coordinates of the panel.
   *
   * @param x The x coordinate
   * @param y The y coordinate
   */
  void setCoordinates(int x, int y);

}
