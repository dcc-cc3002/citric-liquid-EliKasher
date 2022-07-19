package cl.uchile.dcc.citricliquid.model.board.players.interfaces;

import cl.uchile.dcc.citricliquid.controller.handler.interfaces.IHandler;
import cl.uchile.dcc.citricliquid.model.board.objective.Objective;
import cl.uchile.dcc.citricliquid.model.board.panels.abstracts.Panel;
import cl.uchile.dcc.citricliquid.model.board.players.Player;

/**
 * The interface for the players actions and properties in the game.
 */
public interface IPlayer {
  /**
   * Gets the aleatory number on the dice.
   *
   * @return a uniformly distributed random value in [1, 6]
   */
  int roll();

  /**
   * Increases this player's star count by an amount.
   *
   * @param amount It's the number of stars to add
   */
  void increaseStarsBy(int amount);

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  void normaClear();

  /**
   * Set's the seed for this player's random number generator.
   *
   * <p>The random number generator is used for taking
   * non-deterministic decisions, this method is
   * declared to avoid non-deterministic behaviour while testing the code.
   *
   * @param seed A number that makes the random object constant
   */
  void setSeed(long seed);

  /**
   * Reduces this player's star count by a given amount.
   *
   * <p>The star count will must always be greater or equal to 0
   *
   * @param amount It's the number of stars to reduce
   */
  void reduceStarsBy(int amount);

  /**
   * Sets the current character's hit points.
   *
   * <p>The character's hit points have a constraint
   * to always be between 0 and maxHP, both
   * inclusive.
   *
   * @param newHp It's the new HP of the player
   */
  void setCurrentHp(int newHp);

  /**
   * Gets the number of starts of the player.
   *
   * @return this player's star count
   */
  int getStars();

  /**
   * Gets the character's name.
   *
   * @return the character's name
   */
  String getName();

  /**
   * Gets the character's max hit points.
   *
   * @return the current character's max hit points
   */
  int getMaxHp();

  /**
   * Gets the character's attack points.
   *
   * @return the current character's attack points
   */
  int getAtk();

  /**
   * Gets the character's defense points.
   *
   * @return the current character's defense points
   */
  int getDef();

  /**
   * Gets the character's evasion points.
   *
   * @return the current character's evasion points
   */
  int getEvd();

  /**
   * Gets the norma level.
   *
   * @return the current norma level
   */
  int getNormaLevel();

  /**
   * Gets the hit points of the character.
   *
   * @return the current hit points of the character
   */
  int getCurrentHp();

  /**
   * Checks if the objects are the same.
   *
   * @param o An object
   * @return true if both objects are the same
   */
  boolean equals(Object o);

  /**
   * Generates a hashcode for the id of the player.
   *
   * @return a number with the code
   */
  int hashCode();

  /**
   * Gets a copy of the character.
   *
   * @return a copy of this character
   */
  Player copy();

  /**
   * Gets the number of wins.
   *
   * @return the number of wins of the player
   */
  int getWins();

  /**
   * Changes the number of wins of the player.
   *
   * @param win the number that indicates a defeat of an enemy
   */
  void setWins(int win);

  /**
   * Gets the objective of the player.
   *
   * @return the actual objective of the player
   */
  Objective getObj();

  /**
   * Changes the objective of the players game.
   *
   * @param objective A new objective
   */
  void setObj(Objective objective);

  /**
   * Gets if this player is dead or alive.
   *
   * @return true if the player is dead
   */
  boolean isKo();

  /**
   * Gets the number on the dice of the actual throw.
   *
   * @return the number on the dice
   */
  int getDiceThrown();

  /**
   * Changes the number of the actual throw of the dice.
   *
   * @param dice dice just thrown on the board
   */
  void setDiceThrown(int dice);

  /**
   * Changes the panel where it is the player.
   *
   * @param newPanel The new location of the player
   */
  void setPanel(Panel newPanel);

  /**
   * Gets the location of the player.
   *
   * @return the panel where is located the player
   */
  Panel getPanel();

  /**
   * Adds a handler to notify when the player wins.
   *
   * @param winHandler A handler of the Win of a player
   */
  void addListener(IHandler winHandler);
}
