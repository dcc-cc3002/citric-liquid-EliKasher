package cl.uchile.dcc.citricliquid.model.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Random;

import cl.uchile.dcc.citricliquid.model.board.panels.*;
import cl.uchile.dcc.citricliquid.model.board.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
class PanelTest {
  private final static String PLAYER_NAME = "Suguri";
  private final static int BASE_HP = 4;
  private final static int BASE_ATK = 1;
  private final static int BASE_DEF = -1;
  private final static int BASE_EVD = 2;
  private HomePanel testHomePanel;
  private NeutralPanel testNeutralPanel;
  private BonusPanel testBonusPanel;
  private DropPanel testDropPanel;
  private EncounterPanel testEncounterPanel;
  private BossPanel testBossPanel;
  private DrawPanel testDrawPanel;
  private Player suguri;
  private Player amari;
  private long testSeed;

  @BeforeEach
  public void setUp() {
    suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    amari = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);

    testHomePanel = new HomePanel(suguri);
    testBonusPanel = new BonusPanel();
    testNeutralPanel = new NeutralPanel();
    testDropPanel = new DropPanel();

    testBossPanel = new BossPanel();
    testEncounterPanel = new EncounterPanel();
    testDrawPanel = new DrawPanel();

    testSeed = new Random().nextLong();
  }

  @Test
  public void constructorTest() {
    assertEquals("Bonus", testBonusPanel.getType());
    assertEquals("Boss", testBossPanel.getType());
    assertEquals("Drop", testDropPanel.getType());
    assertEquals("Encounter", testEncounterPanel.getType());
    assertEquals("Home", testHomePanel.getType());
    assertEquals("Neutral", testNeutralPanel.getType());
    assertEquals("Draw", testDrawPanel.getType());
  }

  @Test
  public void nextPanelTest() {
    assertTrue(testNeutralPanel.getNextPanels().isEmpty());
    final var expectedPanel1 = new NeutralPanel(1);
    final var expectedPanel2 = new NeutralPanel(2);

    testNeutralPanel.addNextPanel(expectedPanel1);
    assertEquals(1, testNeutralPanel.getNextPanels().size());

    testNeutralPanel.addNextPanel(expectedPanel2);
    assertEquals(2, testNeutralPanel.getNextPanels().size());

    assertEquals(List.of(expectedPanel1, expectedPanel2),
        testNeutralPanel.getNextPanels());
  }

  @Test
  public void homePanelTest() {
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    testHomePanel.activatedBy(suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());

    assertEquals(suguri, testHomePanel.getOwner());

    suguri.setCurrentHp(1);
    testHomePanel.activatedBy(suguri);
    assertEquals(2, suguri.getCurrentHp());
    assertEquals(1, suguri.getNormaLevel());

    suguri.increaseStarsBy(10);
    testHomePanel.activatedBy(suguri);
    assertEquals(2, suguri.getNormaLevel());

    assertEquals(0, suguri.getObj().getObjective());

    suguri.getObj().changeObjective(1);
    assertEquals(1, suguri.getObj().getObjective());

    suguri.setWins(2);
    testHomePanel.activatedBy(suguri);
    suguri.getObj().changeObjective(0);
    assertEquals(4, suguri.getCurrentHp());
    assertEquals(3, suguri.getNormaLevel());

    suguri.reduceStarsBy(10);
    assertEquals(0, suguri.getStars());
    suguri.increaseStarsBy(70);

    testHomePanel.activatedBy(suguri);
    suguri.getObj().changeObjective(1);
    assertEquals(4, suguri.getCurrentHp());
    assertEquals(4, suguri.getNormaLevel());

    suguri.setWins(9);
    testHomePanel.activatedBy(suguri);
    suguri.getObj().changeObjective(0);
    assertEquals(5, suguri.getNormaLevel());

    suguri.increaseStarsBy(150);
    testHomePanel.activatedBy(suguri);
    assertEquals(6, suguri.getNormaLevel());

    testHomePanel.activatedBy(suguri);
    assertEquals(6, suguri.getNormaLevel());

    amari.increaseStarsBy(10);
    testHomePanel.activatedBy(amari);
    assertEquals(2, amari.getNormaLevel());

    amari.increaseStarsBy(20);
    testHomePanel.activatedBy(amari);
    amari.getObj().changeObjective(1);
    assertEquals(3, amari.getNormaLevel());

    amari.setWins(5);
    testHomePanel.activatedBy(amari);
    amari.getObj().changeObjective(0);
    assertEquals(4, amari.getNormaLevel());

    amari.increaseStarsBy(90);
    testHomePanel.activatedBy(amari);
    amari.getObj().changeObjective(1);
    assertEquals(5, amari.getNormaLevel());

    amari.setWins(14);
    testHomePanel.activatedBy(amari);
    assertEquals(6, amari.getNormaLevel());

    testHomePanel.activatedBy(amari);
    assertEquals(6, amari.getNormaLevel());
  }

  @Test
  public void neutralPanelTest() {
    final var expectedSuguri = suguri.copy();
    testNeutralPanel.activatedBy(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  // region : Consistency tests
  @RepeatedTest(100)
  public void bonusPanelConsistencyTest() {

    int expectedStars = 0;
    assertEquals(expectedStars, suguri.getStars());
    final var testRandom = new Random(testSeed);
    suguri.setSeed(testSeed);
    for(int normaLvl = 1; normaLvl <= 6; normaLvl++) {
      final int roll = testRandom.nextInt(6) + 1;
      testBonusPanel.activatedBy(suguri);
      expectedStars += roll * Math.min(3, normaLvl);
      assertEquals(expectedStars, suguri.getStars(),
          "Test failed with seed: " + testSeed);
      suguri.normaClear();
    }
  }

  @RepeatedTest(100)
  public void dropPanelConsistencyTest() {
    int expectedStars = 30;
    suguri.increaseStarsBy(30);
    assertEquals(expectedStars, suguri.getStars());
    final var testRandom = new Random(testSeed);
    suguri.setSeed(testSeed);
    for(int normaLvl = 1; normaLvl <= 6; normaLvl++) {
      final int roll = testRandom.nextInt(6) + 1;
      testDropPanel.activatedBy(suguri);
      expectedStars = Math.max(expectedStars - roll * normaLvl, 0);
      assertEquals(expectedStars, suguri.getStars(),
          "Test failed with seed: " + testSeed);
      suguri.normaClear();
    }
  }

  @Test
  public void bossPanelTest() {
    final var expectedSuguri = suguri.copy();
    testBossPanel.activatedBy(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  @Test
  public void encounterPanelTest() {
    final var expectedSuguri = suguri.copy();
    testEncounterPanel.activatedBy(suguri);
    assertEquals(expectedSuguri, suguri);
  }

  @Test
  public void drawPanelTest() {
    final var expectedSuguri = suguri.copy();
    testDrawPanel.activatedBy(suguri);
    assertEquals(expectedSuguri, suguri);
  }
  // endregion
}