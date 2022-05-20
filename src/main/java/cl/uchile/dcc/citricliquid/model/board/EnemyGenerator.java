package cl.uchile.dcc.citricliquid.model.board;

import java.util.Random;

/**
 * Class that generates enemy characters.
 */
public class EnemyGenerator {
  /** A random object that returns random numbers. */
  private Random rndm;
  /** It's the seed that makes the random variable constant. */
  private long sd;
  /** The number on the dice. */
  private final int dice1 = 1;
  /** The number on the dice. */
  private final int dice2 = 2;
  /** The number on the dice. */
  private final int dice3 = 3;
  /** Name of the store manager boss. */
  private final String storeManager = "Store Manager";
  /** The Store Manager Hit Points. */
  private final int smhp = 8;
  /** The Store Manager Attack Points. */
  private final int smatk = 3;
  /** The Store Manager Defense Points. */
  private final int smdef = 2;
  /** The Store Manager Evasion Points. */
  private final int smevd = -1;
  /** The wins that only bosses give. */
  private final int bossWins = 3;
  /** Name of the shifu robot boss. */
  private final String shifuRobot = "Shifu Robot";
  /** The Shifu Robot Hit Points. */
  private final int srhp = 7;
  /** The Shifu Robot Attack Points. */
  private final int sratk = 2;
  /** The Shifu Robot Defense Points. */
  private final int srdef = 3;
  /** The Shifu Robot Evasion Points. */
  private final int srevd = -2;
  /** Name of the flying castle boss. */
  private final String flyingCastle = "Flying Castle";
  /** The Flying Castle Hit Points. */
  private final int fchp = 10;
  /** The Flying Castle Attack Points. */
  private final int fcatk = 2;
  /** The Flying Castle Defense Points. */
  private final int fcdef = 1;
  /** The Flying Castle Evasion Points. */
  private final int fcevd = -3;
  /** Name of the chicken wild unit. */
  private final String chicken = "Chicken";
  /** The Chicken Hit Points. */
  private final int chp = 3;
  /** The Chicken Attack Points. */
  private final int catk = -1;
  /** The Chicken Defense Points. */
  private final int cdef = -1;
  /** The Chicken Evasion Points. */
  private final int cevd = 1;
  /** The wins that only wild units give. */
  private final int wildWins = 1;
  /** Name of the Robo Ball wild unit. */
  private final String roboBall = "Robo Ball";
  /** The Robo Ball Hit Points. */
  private final int rbhp = 3;
  /** The Robo Ball Attack Points. */
  private final int rbatk = -1;
  /** The Robo Ball Defense Points. */
  private final int rbdef = 1;
  /** The Robo Ball Evasion Points. */
  private final int rbevd = -1;
  /** Name of the Seagull wild unit. */
  private final String seagull = "Seagull";
  /** The Seagull Hit Points. */
  private final int shp = 3;
  /** The Seagull Attack Points. */
  private final int satk = 1;
  /** The Seagull Defense Points. */
  private final int sdef = -1;
  /** The Seagull Evasion Points. */
  private final int sevd = -1;

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
    this.sd = seed;
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
      return new BossUnit(storeManager, smhp, smatk, smdef, smevd, bossWins);
    }
    if (random == dice2) {
      return new BossUnit(shifuRobot, srhp, sratk, srdef, srevd, bossWins);
    }
    if (random == dice3) {
      return new BossUnit(flyingCastle, fchp, fcatk, fcdef, fcevd, bossWins);
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
      return new WildUnit(chicken, chp, catk, cdef, cevd, wildWins);
    }
    if (random == dice2) {
      return new WildUnit(roboBall, rbhp, rbatk, rbdef, rbevd, wildWins);
    }
    if (random == dice3) {
      return new WildUnit(seagull, shp, satk, sdef, sevd, wildWins);
    }
    return null;
  }

}
