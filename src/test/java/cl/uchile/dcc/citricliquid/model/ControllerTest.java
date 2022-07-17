package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.controller.Controller;
import cl.uchile.dcc.citricliquid.model.board.*;
import cl.uchile.dcc.citricliquid.model.board.abstracts.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
  Controller controller;
  Controller controller2;
  private final static String PLAYER_NAME = "Suguri";

  @BeforeEach
  public void setUp() {
    controller = new Controller();
    controller2 = new Controller();
  }

  @Test
  public void ChaptersTest() {
    assertEquals(1, controller.getChapter());
    controller.setChapter(2);
    assertEquals(2, controller.getChapter());
  }

  @Test
  public void aBoardExampleTest() {
    Controller context2 = new Controller();
    context2.generateBoard();
    assertEquals(32, context2.getBoardTable().size());
  }

  @Test
  public void generatePanelsTest() {
    Player suguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    Panel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    panel1 = controller.createBonusPanel(1);
    assertTrue(controller.getBoardTable().contains(panel1));
    panel2 = controller.createBossPanel(2);
    assertTrue(controller.getBoardTable().contains(panel2));
    panel3 = controller.createDrawPanel(3);
    assertTrue(controller.getBoardTable().contains(panel3));
    panel4 = controller.createDropPanel(4);
    assertTrue(controller.getBoardTable().contains(panel4));
    panel5 = controller.createEncounterPanel(5);
    assertTrue(controller.getBoardTable().contains(panel5));
    panel6 = controller.createHomePanel(suguri, 6);
    assertTrue(controller.getBoardTable().contains(panel6));
    panel7 = controller.createNeutralPanel(7);
    assertTrue(controller.getBoardTable().contains(panel7));
  }

  @Test
  public void designatePanelsTest() {
    Panel panel1, panel2, panel3, panel4;
    panel1 = controller.createBonusPanel(1);
    panel2 = controller.createBossPanel(2);
    panel3 = controller.createDrawPanel(3);
    panel4 = controller.createDropPanel(4);

    controller.setNextPanel(panel1, panel2);
    assertEquals(List.of(panel2), panel1.getNextPanels());
    assertEquals(1, panel1.getNextPanels().size());
    assertEquals(0, panel2.getNextPanels().size());
    controller.setNextPanel(panel1, panel3);
    assertEquals(List.of(panel2, panel3), panel1.getNextPanels());
    assertEquals(2, panel1.getNextPanels().size());
    controller.setNextPanel(panel2, panel4);
    controller.setNextPanel(panel3, panel4);
    assertEquals(1, panel2.getNextPanels().size());
    assertEquals(1, panel3.getNextPanels().size());
  }

  @Test
  public void allPanelsTest() {
    Set<Panel> board = controller2.getBoardTable();
    assertEquals(0,board.size());

    Panel panel1, panel2, panel3, panel4;
    panel1 = controller2.createBonusPanel(1);
    assertEquals(1, controller2.getBoardTable().size());
    assertTrue(controller2.getBoardTable().contains(panel1));
    panel2 = controller2.createBossPanel(2);
    assertEquals(2, controller2.getBoardTable().size());
    assertTrue(controller2.getBoardTable().contains(panel2));
    panel3 = controller2.createDrawPanel(3);
    assertEquals(3, controller2.getBoardTable().size());
    assertTrue(controller2.getBoardTable().contains(panel3));
    panel4 = controller2.createDropPanel(4);
    assertEquals(4, controller2.getBoardTable().size());
    assertTrue(controller2.getBoardTable().contains(panel4));
  }

  @Test
  public void generatePlayersTest() {
    Player yuki;
    Object yukiCopy;
    yuki = controller.choosePlayer("1");
    HomePanel yukiHome = controller.createHomePanel(yuki, 1);
    controller.placePlayer(yuki, yukiHome);
    yukiCopy = new Player("Yuki", 5, 2, -1, -1);
    assertNotEquals(yuki, yuki.copy());
    assertNotEquals(yuki, yukiCopy);
    assertTrue(yukiHome.getListOfPlayers().contains(yuki));

    Player suguri;
    Object suguriCopy;
    suguri = controller.choosePlayer("2");
    HomePanel suguriHome = controller.createHomePanel(suguri, 2);
    controller.placePlayer(suguri, suguriHome);
    suguriCopy = new Player("Suguri", 4, 1, -1, 2);
    assertEquals(suguri, suguri.copy());
    assertEquals(suguri, suguriCopy);
    assertTrue(suguriHome.getListOfPlayers().contains(suguri));

    Player tomomo;
    Object tomomoCopy;
    tomomo = controller.choosePlayer("3");
    HomePanel tomomoHome = controller.createHomePanel(tomomo, 3);
    controller.placePlayer(tomomo, tomomoHome);
    tomomoCopy = new Player("Tomomo", 4, 2, 0, 0);
    assertEquals(tomomo, tomomo.copy());
    assertEquals(tomomo, tomomoCopy);
    assertTrue(tomomoHome.getListOfPlayers().contains(tomomo));

    Player aru;
    Object aruCopy;
    aru = controller.choosePlayer("4");
    HomePanel aruHome = controller.createHomePanel(aru, 4);
    controller.placePlayer(aru, aruHome);
    aruCopy = new Player("Aru", 5, -1, -1, 2);
    assertEquals(aru, aru.copy());
    assertEquals(aru, aruCopy);
    assertTrue(aruHome.getListOfPlayers().contains(aru));
  }

  @Test
  public void createBossUnitTest() {
    BossUnit storeManager;
    BossUnit flyingCastle;
    BossUnit shifuRobot;

    storeManager = controller.createBossUnit(1);
    shifuRobot = controller.createBossUnit(2);
    flyingCastle = controller.createBossUnit(3);

    assertEquals(new BossUnit("Store Manager", 8, 3, 2, -1, 3), storeManager);
    assertEquals(new BossUnit("Shifu Robot", 7, 2, 3, -2, 3), shifuRobot);
    assertEquals(new BossUnit("Flying Castle", 10, 2, 1, -3, 3), flyingCastle);
  }

  @Test
  public void createWildUnitTest() {
    WildUnit chicken;
    WildUnit seaGull;
    WildUnit roboBall;

    chicken = controller.createWildUnit(1);
    seaGull = controller.createWildUnit(3);
    roboBall = controller.createWildUnit(2);

    assertEquals(new WildUnit("Chicken", 3, -1, -1, 1, 1), chicken);
    assertEquals(new WildUnit("Robo Ball", 3, -1, 1, -1, 1), roboBall);
    assertEquals(new WildUnit("Seagull", 3, 1, -1, -1, 1), seaGull);
  }

  @Test
  public void maxNormTest() {
    Player yuki = controller.choosePlayer("1");
    assertNull(controller.getWinner());

    for(int i = 0; i < 4; i++){
      yuki.normaClear();
    }

    assertEquals(6, yuki.getNormaLevel());
    assertNotNull(controller.getWinner());
    assertEquals(yuki, controller.getWinner());
  }

  @Test
  public void definePlayerObjectiveTest() {
    Player yuki = controller.choosePlayer("1");
    assertEquals("STARS", controller.getObj());
    controller.changeObj("WINS");
    assertEquals("STARS", controller.getObj());
    yuki.normaClear();
    controller.changeObj("WINS");
    assertEquals("WINS", controller.getObj());
    controller.changeObj("STARS");
    assertEquals("STARS", controller.getObj());
  }

  @Test
  public void turnOwnerTest() {
    Player yuki = controller.choosePlayer("1");
    assertEquals(yuki, controller.getTurn());
    Player aru = controller.choosePlayer("4");
    assertEquals(yuki, controller.getTurn());
    assertNotEquals(aru, controller.getTurn());
  }

  @Test
  public void finishTurnTest() {
    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    Player suguri = context3.choosePlayer("2");
    HomePanel homePanel3 = context3.createHomePanel(yuki3,3);
    NeutralPanel neutralPanel9 = context3.createNeutralPanel(9);
    homePanel3.addNextPanel(neutralPanel9);
    context3.placePlayer(yuki3, homePanel3);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();

    //seed
    context3.setSeed(11);
    context3.tryRoll();
    context3.tryPanelEffect();

    context3.tryEnd();
    assertTrue(context3.isStartState());
    assertEquals(suguri, context3.getTurn());
    assertEquals(0, context3.getNumberOfMovements());
  }


  @Test
  public void defineHomePanelsTest() {
    Player yuki;
    yuki = controller.choosePlayer("1");
    HomePanel yukiHome = controller.createHomePanel(yuki, 1);
    controller.placePlayer(yuki, yukiHome);
    assertTrue(yukiHome.getListOfPlayers().contains(yuki));
    assertEquals(yuki, yukiHome.getOwner());
  }

  @Test
  public void normaCheckTest() {
    Player aru;
    Controller context = new Controller();
    aru = context.choosePlayer("4");
    HomePanel yukiHome = context.createHomePanel(aru, 2);
    context.placePlayer(aru, yukiHome);
    aru.setObj(new Objective(1));
    aru.setWins(14);
    aru.normaClear();
    aru.normaClear();
    aru.normaClear();
    aru.normaClear();
    context.normaCheck();
    assertEquals(aru, context.getWinner());
  }
}
