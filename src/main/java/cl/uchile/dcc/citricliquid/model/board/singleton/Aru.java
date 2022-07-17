package cl.uchile.dcc.citricliquid.model.board.singleton;

import cl.uchile.dcc.citricliquid.model.board.Player;

/**
 * Creates a unique instance of a player named Aru.
 */
public final class Aru extends Player {
  /**
   * An unique player named Aru.
   */
  private static Aru uniqueAru;

  /**
   * Creates an Aru instance.
   */
  private Aru() {
    super("Aru", 5, -1, -1, 2);
  }

  /**
   * Creates an Aru if there's no Aru created.
   *
   * @return An unique Aru
   */
  public static Aru oneAru() {
    if (uniqueAru == null) {
      uniqueAru = new Aru();
    }
    return uniqueAru;
  }
}
