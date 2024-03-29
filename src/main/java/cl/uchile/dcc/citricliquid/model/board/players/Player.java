package cl.uchile.dcc.citricliquid.model.board.players;

import cl.uchile.dcc.citricliquid.controller.handler.interfaces.IHandler;
import cl.uchile.dcc.citricliquid.model.board.objective.Objective;
import cl.uchile.dcc.citricliquid.model.board.panels.abstracts.Panel;
import cl.uchile.dcc.citricliquid.model.board.players.interfaces.IPlayer;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *        Muñoz</a>.
 * @version 1.1.222804
 * @since 1.0
 */
public class Player implements IPlayer {
  /**
   * A random object.
   */
  private final Random random;
  /**
   * The name of the character.
   */
  private final String nm;
  /**
   * The max hit points of the character.
   */
  private final int mxHp;
  /**
   * The attack points of the character.
   */
  private final int attack;
  /**
   * The defense points of the character.
   */
  private final int defense;
  /**
   * The evasion points of the character.
   */
  private final int evade;
  /**
   * The norma level of the character.
   */
  private int normaLevel;
  /**
   * The stars of the character.
   */
  private int stars;
  /**
   * The wins of the character.
   */
  private int wins;
  /**
   * The current hit points of the character.
   */
  private int currentHp;
  /**
   * The initial objective of the game.
   */
  private Objective obj;
  /**
   * Saves the number of the dice on a throw.
   */
  private int diceThrown;
  /**
   * The panel that corresponds to the actual position of the player.
   */
  private Panel panel;
  /**
   * An object that notifies when the player wins the game.
   */
  private PropertyChangeSupport isWinnerNotification;

  /**
   * Creates a new character.
   *
   * @param name the character's name
   * @param hp   the initial (and max) hit points of the character
   * @param atk  the base damage the character does
   * @param def  the base defense of the character
   * @param evd  the base evasion of the character
   */
  public Player(final String name, final int hp, final int atk, final int def,
                final int evd) {
    this.nm = name;
    this.mxHp = hp;
    this.currentHp = hp;
    this.attack = atk;
    this.defense = def;
    this.evade = evd;
    panel = null;
    normaLevel = 1;
    stars = 0;
    wins = 0;
    diceThrown = 0;
    random = new Random();
    obj = new Objective(0);
    isWinnerNotification = new PropertyChangeSupport(this);
  }

  /**
   * Gets the aleatory number on the dice.
   *
   * @return a uniformly distributed random value in [1, 6]
   */
  public int roll() {
    // The number of faces of the dice.
    int dice6 = 6;
    int number = random.nextInt(dice6) + 1;
    setDiceThrown(number);
    return number;
  }

  /**
   * Increases this player's star count by an amount.
   *
   * @param amount It's the number of stars to add
   */
  public void increaseStarsBy(final int amount) {
    stars += amount;
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    normaLevel++;
    if (getNormaLevel() == 6) {
      isWinnerNotification.firePropertyChange("PLAYER_WON", null, this);
    }
  }


  /**
   * Set's the seed for this player's random number generator.
   *
   * <p>The random number generator is used for taking
   * non-deterministic decisions, this method is
   * declared to avoid non-deterministic behaviour while testing the code.
   *
   * @param seed A number that makes the random object constant
   */
  public void setSeed(final long seed) {
    random.setSeed(seed);
  }

  /**
   * Reduces this player's star count by a given amount.
   *
   * <p>The star count will must always be greater or equal to 0
   *
   * @param amount It's the number of stars to reduce
   */
  public void reduceStarsBy(final int amount) {
    stars = Math.max(0, stars - amount);
  }

  /**
   * Sets the current character's hit points.
   *
   * <p>The character's hit points have a constraint
   * to always be between 0 and maxHP, both
   * inclusive.
   *
   * @param newHp It's the new HP of the player
   */
  public void setCurrentHp(final int newHp) {
    this.currentHp = Math.max(Math.min(newHp, mxHp), 0);
  }

  /**
   * Gets the number of starts of the player.
   *
   * @return this player's star count
   */
  public int getStars() {
    return stars;
  }

  /**
   * Gets the character's name.
   *
   * @return the character's name
   */
  public String getName() {
    return nm;
  }

  /**
   * Gets the character's max hit points.
   *
   * @return the current character's max hit points
   */
  public int getMaxHp() {
    return mxHp;
  }

  /**
   * Gets the character's attack points.
   *
   * @return the current character's attack points
   */
  public int getAtk() {
    return attack;
  }

  /**
   * Gets the character's defense points.
   *
   * @return the current character's defense points
   */
  public int getDef() {
    return defense;
  }

  /**
   * Gets the character's evasion points.
   *
   * @return the current character's evasion points
   */
  public int getEvd() {
    return evade;
  }

  /**
   * Gets the norma level.
   *
   * @return the current norma level
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Gets the hit points of the character.
   *
   * @return the current hit points of the character
   */
  public int getCurrentHp() {
    return currentHp;
  }

  /**
   * Checks if the objects are the same.
   *
   * @param o An object
   * @return true if both objects are the same
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Player player)) {
      return false;
    }
    return getMaxHp() == player.getMaxHp()
        && getAtk() == player.getAtk()
        && getDef() == player.getDef()
        && getEvd() == player.getEvd()
        && getNormaLevel() == player.getNormaLevel()
        && getStars() == player.getStars()
        && getCurrentHp() == player.getCurrentHp()
        && getName().equals(player.getName());
  }

  /**
   * Generates a hashcode for the id of the player.
   *
   * @return a number with the code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getMaxHp(), getAtk(), getDef(),
        getEvd(), getNormaLevel(), getStars(), getClass());
  }

  /**
   * Gets a copy of the character.
   *
   * @return a copy of this character
   */
  public Player copy() {
    return new Player(nm, mxHp, attack, defense, evade);
  }


  /**
   * Gets the number of wins.
   *
   * @return the number of wins of the player
   */
  public int getWins() {
    return wins;
  }

  /**
   * Changes the number of wins of the player.
   *
   * @param win the number that indicates a defeat of an enemy
   */
  public void setWins(final int win) {
    this.wins = win;
  }

  /**
   * Gets the objective of the player.
   *
   * @return the actual objective of the player
   */
  public final Objective getObj() {
    return obj;
  }

  /**
   * Changes the objective of the players game.
   *
   * @param objective A new objective
   */
  public void setObj(final Objective objective) {
    this.obj = objective;
  }

  /**
   * Gets if this player is dead or alive.
   *
   * @return true if the player is dead
   */
  public boolean isKo() {
    return currentHp == 0;
  }

  /**
   * Gets the number on the dice of the actual throw.
   *
   * @return the number on the dice
   */
  public int getDiceThrown() {
    return diceThrown;
  }

  /**
   * Changes the number of the actual throw of the dice.
   *
   * @param dice dice just thrown on the board
   */
  public void setDiceThrown(final int dice) {
    this.diceThrown = dice;
  }

  /**
   * Changes the panel where it is the player.
   *
   * @param newPanel The new location of the player
   */
  public void setPanel(final Panel newPanel) {
    this.panel = newPanel;
  }

  /**
   * Gets the location of the player.
   *
   * @return the panel where is located the player
   */
  public Panel getPanel() {
    return this.panel;
  }

  /**
   * Adds a handler to notify when the player wins.
   *
   * @param winHandler A handler of the Win of a player
   */
  public void addListener(final IHandler winHandler) {
    isWinnerNotification.addPropertyChangeListener(winHandler);
  }
}
