package cl.uchile.dcc.citricliquid.model.board;

import java.util.Objects;

/**
 * Class for the enemies.
 */
public class EnemyUnit {
  /** The name of the character. */
  private final String nm;
  /** The max HP of the character. */
  private final int mxHp;
  /** The atk points of the character. */
  private final int attack;
  /** The defense points of the character. */
  private final int defense;
  /** The evasion points of the character. */
  private final int evade;
  /** The current wins of the character. */
  private final int wins;
  /** The current hp of the character. */
  private int currentHp;

  /**
   * Creates a new character.
   *
   * @param name the name of the character.
   * @param hp  the initial (and max) hit points of the character.
   * @param atk the base damage the character does.
   * @param def the base defense of the character.
   * @param evd the base evasion of the character.
   * @param win the quantity of wins that has the character.
   */
  public EnemyUnit(final String name, final int hp, final int atk,
                   final int def, final int evd, final int win) {
    this.nm = name;
    this.mxHp = hp;
    this.currentHp = hp;
    this.attack = atk;
    this.defense = def;
    this.evade = evd;
    this.wins = win;
  }

  /**
   * Checks if both items are the same.
   *
   * @param o An object
   * @return if both objects are the same
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final EnemyUnit enemyUnit)) {
      return false;
    }
    return getMaxHp() == enemyUnit.getMaxHp()
        && getAtk() == enemyUnit.getAtk()
        && getDef() == enemyUnit.getDef()
        && getEvd() == enemyUnit.getEvd()
        && getWins() == enemyUnit.getWins()
        && getCurrentHp() == enemyUnit.getCurrentHp()
        && getName().equals(enemyUnit.getName());
  }

  /**
   * Generates a hashcode for the id of the panel.
   *
   * @return a number with the code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMaxHp(), getAtk(), getDef(),
        getEvd(), getWins(), getCurrentHp(), getName(), getClass());
  }

  /**
   * Gets the name of the unit.
   *
   * @return the name of the enemy unit.
   */
  public String getName() {
    return nm;
  }

  /**
   * Gets the max hp of the unit.
   *
   * @return the max hp of the enemy character.
   */
  public int getMaxHp() {
    return mxHp;
  }

  /**
   * Gets the attack points of the unit.
   *
   * @return the attack points of the enemy character.
   */
  public int getAtk() {
    return attack;
  }

  /**
   * Gets the defense points of the unit.
   *
   * @return the defense points of the enemy character.
   */
  public int getDef() {
    return defense;
  }

  /**
   * Gets the evd points of the unit.
   *
   * @return the evd points of the enemy character.
   */
  public int getEvd() {
    return evade;
  }

  /**
   * Gets the wins that the unit gives.
   *
   * @return the wins that this enemy gives.
   */
  public int getWins() {
    return wins;
  }

  /**
   * Gets the hp of the unit.
   *
   * @return the actual hp of the enemy character.
   */
  public int getCurrentHp() {
    return currentHp;
  }

  /**
   * Changes the hp of the enemy character between 0 and the maxHP.
   *
   * @param newHp The actual hp we assign to the character.
   */
  public void setCurrentHp(final int newHp) {
    this.currentHp = Math.max(Math.min(newHp, mxHp), 0);
  }

  /**
   * Gets the copy of the unit.
   *
   * @return a copy of the enemy character.
   */
  public EnemyUnit copy() {
    return new EnemyUnit(nm, mxHp, attack, defense, evade, wins);
  }
}
