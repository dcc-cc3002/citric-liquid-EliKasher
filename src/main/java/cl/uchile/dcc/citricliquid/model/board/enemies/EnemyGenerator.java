package cl.uchile.dcc.citricliquid.model.board.enemies;

import cl.uchile.dcc.citricliquid.model.board.enemies.interfaces.IEnemyGenerator;

import java.util.Random;

/**
 * Class that generates enemy characters.
 */
public class EnemyGenerator implements IEnemyGenerator {
  /** A random object that returns random numbers. */
  private Random rndm;
  /** The number on the dice. */
  private final int dice1 = 1;
  /** The number on the dice. */
  private final int dice2 = 2;
  /** The number on the dice. */
  private final int dice3 = 3;



  /**
   * Creates the class Enemy Generator that generates enemies.
   */
  public EnemyGenerator() {
    this.rndm = new Random();
  }

  /**
   * Returns a uniformly distributed random value in [1, 3].
   *
   * @param seed A number that helps random throw the same result
   * @return a random number between 1 and 3
   */
  public int pickEnemyS(final long seed) {
    setEnemySeed(seed);
    return rndm.nextInt(dice3) + 1;
  }

  /**
   * Puts a seed into a random object.
   *
   * @param seed A number that helps random throw the same result
   */
  public void setEnemySeed(final long seed) {
    this.rndm = new Random(seed);
  }

  /**
   * Generates a random boss unit.
   *
   * @param random It's a random number
   * @return a random boss unit
   */
  public BossUnit bossGen(final long random) {
    if (random == dice1) {
      return new StoreManager();
    }
    if (random == dice2) {
      return new ShifuRobot();
    }
    if (random == dice3) {
      return new FlyingCastle();
    }

    return null;
  }

  /**
   * Generates a random wild unit.
   *
   * @param random It's a random object
   * @return a random wild unit
   */
  public WildUnit wildGen(final long random) {
    if (random == dice1) {
      return new Chicken();
    }
    if (random == dice2) {
      return new RoboBall();
    }
    if (random == dice3) {
      return new SeaGull();
    }
    return null;
  }

}
