package cl.uchile.dcc.citricliquid.model.board.objective;

import cl.uchile.dcc.citricliquid.model.board.objective.interfaces.Norma;
import cl.uchile.dcc.citricliquid.model.board.players.interfaces.IPlayer;

/**
 * Creates a class that implements the case of the Win Norma.
 */
public class WinsNorma implements Norma {

  /**
   * Checks if the norma checks it's accomplished for the win objective.
   *
   * @param player The main character of the game
   * @return true if the win norma it's accomplished
   */
  @Override
  public boolean normaCheck(final IPlayer player) {
    int norma = player.getNormaLevel();
    int wins = player.getWins();

    if (norma == 2) {
      return wins >= 2 && wins < 5;
    }
    if (norma == 3) {
      return wins >= 5 && wins < 9;
    }
    if (norma == 4) {
      return wins >= 9 && wins < 14;
    }
    if (norma == 5) {
      return wins >= 14;
    }
    return false;
  }
}
