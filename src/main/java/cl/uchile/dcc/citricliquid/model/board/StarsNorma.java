package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.interfaces.Norma;

/**
 * Creates a class that implements the case of the Star Norma.
 */
public class StarsNorma implements Norma {
  /** Level 1. */
  private final int norma1 = 1;
  /** Level 2. */
  private final int norma2 = 2;
  /** Level 3. */
  private final int norma3 = 3;
  /** Level 4. */
  private final int norma4 = 4;
  /** Level 5. */
  private final int norma5 = 5;
  /** First stars norma check. */
  private final int stars1 = 10;
  /** Second stars norma check. */
  private final int stars2 = 30;
  /** Third stars norma check. */
  private final int stars3 = 70;
  /** Fourth stars norma check. */
  private final int stars4 = 120;
  /** Fifth stars norma check. */
  private final int stars5 = 200;

  /**
   * Checks if the norma checks it's accomplished for the star objective.
   *
   * @param player The main character of the game
   * @return true if the star norma it's accomplished
   */
  @Override
  public boolean normaCheck(final Player player) {
    int norma = player.getNormaLevel();
    int stars = player.getStars();

    if (norma == norma1) {
      return stars >= stars1 && stars < stars2;
    }
    if (norma == norma2) {
      return stars >= stars2 && stars < stars3;
    }
    if (norma == norma3) {
      return stars >= stars3 && stars < stars4;
    }
    if (norma == norma4) {
      return stars >= stars4 && stars < stars5;
    }
    if (norma == norma5) {
      return stars >= stars5;
    }
    return false;
  }
}
