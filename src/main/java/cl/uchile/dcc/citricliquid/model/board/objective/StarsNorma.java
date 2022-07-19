package cl.uchile.dcc.citricliquid.model.board.objective;

import cl.uchile.dcc.citricliquid.model.board.objective.interfaces.Norma;
import cl.uchile.dcc.citricliquid.model.board.players.interfaces.IPlayer;

/**
 * Creates a class that implements the case of the Star Norma.
 */
public class StarsNorma implements Norma {
  /**
   * Checks if the norma checks it's accomplished for the star objective.
   *
   * @param player The main character of the game
   * @return true if the star norma it's accomplished
   */
  @Override
  public boolean normaCheck(final IPlayer player) {
    int norma = player.getNormaLevel();
    int stars = player.getStars();

    if (norma == 1) {
      return stars >= 10 && stars < 30;
    }
    if (norma == 2) {
      return stars >= 30 && stars < 70;
    }
    if (norma == 3) {
      return stars >= 70 && stars < 120;
    }
    if (norma == 4) {
      return stars >= 120 && stars < 200;
    }
    if (norma == 5) {
      return stars >= 200;
    }
    return false;
  }
}
