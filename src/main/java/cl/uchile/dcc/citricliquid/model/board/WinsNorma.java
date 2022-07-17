package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.board.interfaces.Norma;

/**
 * Creates a class that implements the case of the Win Norma.
 */
public class WinsNorma implements Norma {
  /** Level 2. */
  private final int norma2 = 2;
  /** Level 3. */
  private final int norma3 = 3;
  /** Level 4. */
  private final int norma4 = 4;
  /** Level 5. */
  private final int norma5 = 5;
  /** First wins norma check. */
  private final int win1 = 2;
  /** Second wins norma check. */
  private final int win2 = 5;
  /** Third wins norma check. */
  private final int win3 = 9;
  /** Fourth wins norma check. */
  private final int win4 = 14;

  /**
   * Checks if the norma checks it's accomplished for the win objective.
   *
   * @param player The main character of the game
   * @return true if the win norma it's accomplished
   */
  @Override
  public boolean normaCheck(final Player player) {
    int norma = player.getNormaLevel();
    int wins = player.getWins();

    if (norma == norma2) {
      return wins >= win1 && wins < win2;
    }
    if (norma == norma3) {
      return wins >= win2 && wins < win3;
    }
    if (norma == norma4) {
      return wins >= win3 && wins < win4;
    }
    if (norma == norma5) {
      return wins >= win4;
    }
    return false;
  }
}
