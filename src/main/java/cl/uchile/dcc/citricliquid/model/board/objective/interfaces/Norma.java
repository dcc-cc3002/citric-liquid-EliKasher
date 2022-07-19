package cl.uchile.dcc.citricliquid.model.board.objective.interfaces;

import cl.uchile.dcc.citricliquid.model.board.players.interfaces.IPlayer;

/**
 * Interface that implements the norma checks.
 */
public interface Norma {
  /**
   * Checks if the player accomplished the current objective of the game.
   *
   * @param player The main character of the game
   * @return True if the player accomplished the objective
   */
  boolean normaCheck(IPlayer player);
}
