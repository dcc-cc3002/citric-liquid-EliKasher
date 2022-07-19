package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.model.board.enemies.BossUnit;
import cl.uchile.dcc.citricliquid.model.board.enemies.EnemyGenerator;
import cl.uchile.dcc.citricliquid.model.board.enemies.WildUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class EnemyTest {
  private WildUnit expectedChicken;
  private BossUnit expectedFlyingCastle;
  private WildUnit chicken;
  private WildUnit seaGull;
  private WildUnit roboBall;
  private BossUnit storeManager;
  private BossUnit flyingCastle;

  @Test
  public void constructorTest() {
    final EnemyGenerator eg = new EnemyGenerator();
    final long seed = eg.pickEnemyS(1);
    final long seed2 = eg.pickEnemyS(2); //2
    final long seed3 = eg.pickEnemyS(3);

    final var expectedChicken = eg.wildGen(seed);
    final var expectedSeaGull = eg.wildGen(seed3);
    final var expectedRoboBall = eg.wildGen(seed2);
    final var chicken = eg.wildGen(seed);
    final var seaGull = eg.wildGen(seed3);
    final var roboBall = eg.wildGen(seed2);

    final var expectedStoreManager = eg.bossGen(seed);
    final var expectedShifuRobot = eg.bossGen(seed2);
    final var expectedFlyingCastle = eg.bossGen(seed3);
    final var storeManager = eg.bossGen(seed);
    final var shifuRobot = eg.bossGen(seed2);
    final var flyingCastle = eg.bossGen(seed3);

    Assertions.assertEquals(expectedChicken, chicken);
    Assertions.assertEquals("Chicken", chicken.getName());
    Assertions.assertEquals(expectedSeaGull, seaGull);
    Assertions.assertEquals("Seagull", seaGull.getName());
    Assertions.assertEquals(expectedRoboBall, roboBall);
    Assertions.assertEquals("Robo Ball", roboBall.getName());

    Assertions.assertEquals(expectedStoreManager, storeManager);
    Assertions.assertEquals("Store Manager", storeManager.getName());
    Assertions.assertEquals(expectedShifuRobot, shifuRobot);
    Assertions.assertEquals("Shifu Robot", shifuRobot.getName());
    Assertions.assertEquals(expectedFlyingCastle, flyingCastle);
    Assertions.assertEquals("Flying Castle", flyingCastle.getName());
  }

  @Test
  public void testEquals() {
    final var o = new Object();
    final EnemyGenerator eg = new EnemyGenerator();
    final long seed = eg.pickEnemyS(1);
    final long seed3 = eg.pickEnemyS(3);

    chicken = eg.wildGen(seed);
    expectedChicken = eg.wildGen(seed);
    flyingCastle = eg.bossGen(seed3);
    expectedFlyingCastle = eg.bossGen(seed3);

    Assertions.assertNotEquals(chicken, o);
    Assertions.assertEquals(chicken, chicken);
    Assertions.assertEquals(expectedChicken, chicken);
    Assertions.assertNotEquals(flyingCastle, o);
    Assertions.assertEquals(flyingCastle, flyingCastle);
    Assertions.assertEquals(flyingCastle, expectedFlyingCastle);
  }

  @Test
  public void hitPointsTest() {
    final var o = new Object();
    final EnemyGenerator eg = new EnemyGenerator();
    final long seed = eg.pickEnemyS(1);
    final long seed3 = eg.pickEnemyS(3);

    seaGull = eg.wildGen(seed3);
    storeManager = eg.bossGen(seed);

    Assertions.assertEquals(seaGull.getMaxHp(), seaGull.getCurrentHp());
    seaGull.setCurrentHp(2);
    Assertions.assertEquals(2, seaGull.getCurrentHp());
    seaGull.setCurrentHp(-1);
    Assertions.assertEquals(0, seaGull.getCurrentHp());
    seaGull.setCurrentHp(5);
    Assertions.assertEquals(3, seaGull.getCurrentHp());

    Assertions.assertEquals(storeManager.getMaxHp(), storeManager.getCurrentHp());
    storeManager.setCurrentHp(2);
    Assertions.assertEquals(2, storeManager.getCurrentHp());
    storeManager.setCurrentHp(-1);
    Assertions.assertEquals(0, storeManager.getCurrentHp());
    storeManager.setCurrentHp(5);
    Assertions.assertEquals(5, storeManager.getCurrentHp());
  }

  @Test
  public void copyTest() {
    final EnemyGenerator eg = new EnemyGenerator();
    final long seed2 = eg.pickEnemyS(2);
    final long seed3 = eg.pickEnemyS(3);
    roboBall = eg.wildGen(seed2);
    flyingCastle = eg.bossGen(seed3);
    final var actualSeagull = roboBall.copy();
    final var actualFlyingCastle = flyingCastle.copy();
    // Checks that the copied player have the same parameters as the original
    Assertions.assertEquals(roboBall, actualSeagull);
    Assertions.assertEquals(flyingCastle, actualFlyingCastle);
    // Checks that the copied player doesn't reference the same object
    Assertions.assertNotSame(roboBall, actualSeagull);
    Assertions.assertEquals(flyingCastle, actualFlyingCastle);
  }

  // region : consistency tests
  @RepeatedTest(100)
  public void rollConsistencyTest() {
    final long testSeed = new Random().nextLong();
    EnemyGenerator eg = new EnemyGenerator();
    final int roll = eg.pickEnemyS(testSeed);
    Assertions.assertTrue(roll >= 1 && roll <= 3,
        roll + "is not in [1, 3]" + System.lineSeparator()
            + "Test failed with random seed: " + testSeed);
  }
}
