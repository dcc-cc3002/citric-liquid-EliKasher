package cl.uchile.dcc.citricliquid.model.board.players.singleton;

import cl.uchile.dcc.citricliquid.model.board.players.Player;

/**
 * Creates a unique instance of a player named Suguri.
 */
public final class Suguri extends Player {
  /**
   * An unique player named Suguri.
   */
  private static Suguri uniqueSuguri;

  /**
   * Creates a Suguri instance.
   */
  private Suguri() {
    super("Suguri", 4, 1, -1, 2);
  }

  /**
   * Creates a Suguri if there's no Suguri created.
   *
   * @return An unique Suguri
   */
  public static Suguri oneSuguri() {
    if (uniqueSuguri == null) {
      uniqueSuguri = new Suguri();
    }
    return uniqueSuguri;
  }
}
