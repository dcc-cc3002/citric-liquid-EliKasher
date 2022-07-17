package cl.uchile.dcc.citricliquid.model.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class NormaTest {
  private StarsNorma sn;
  private WinsNorma wn;
  private Player suguri;
  private Player amari;
  private final static String PLAYER_NAME = "Suguri";
  private final static int BASE_HP = 4;
  private final static int BASE_ATK = 1;
  private final static int BASE_DEF = -1;
  private final static int BASE_EVD = 2;

  @BeforeEach
  public void setUp() {
    sn = new StarsNorma();
    wn = new WinsNorma();
    suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    amari = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
  }

  @RepeatedTest(100)
  public void consistencyTest() {
    sn.normaCheck(suguri);
    wn.normaCheck(suguri);

    assertEquals(1, suguri.getNormaLevel());

    suguri.increaseStarsBy(10);
    assertTrue(sn.normaCheck(suguri));

    suguri.normaClear();
    suguri.setWins(2);
    assertTrue(wn.normaCheck(suguri));

    suguri.normaClear();
    suguri.increaseStarsBy(65);
    assertTrue(sn.normaCheck(suguri));

    suguri.normaClear();
    suguri.setWins(10);
    assertTrue(wn.normaCheck(suguri));

    suguri.normaClear();
    suguri.increaseStarsBy(150);
    assertTrue(sn.normaCheck(suguri));

    suguri.normaClear();

    amari.increaseStarsBy(10);
    assertTrue(sn.normaCheck(amari));

    amari.normaClear();
    amari.increaseStarsBy(20);
    assertTrue(sn.normaCheck(amari));

    amari.normaClear();
    amari.setWins(5);
    assertTrue(wn.normaCheck(amari));

    amari.normaClear();
    amari.increaseStarsBy(90);
    assertTrue(sn.normaCheck(amari));

    amari.normaClear();
    amari.setWins(14);
    assertTrue(wn.normaCheck(amari));

    amari.normaClear();

    assertEquals(6, suguri.getNormaLevel());
    assertEquals(6, amari.getNormaLevel());

    assertFalse(sn.normaCheck(suguri));
    assertFalse(wn.normaCheck(suguri));

    assertFalse(wn.normaCheck(amari));
    assertFalse(sn.normaCheck(amari));
  }

}
