package cl.uchile.dcc.citricliquid.model.board.players.singleton;

import cl.uchile.dcc.citricliquid.model.board.players.Player;

/**
 * Creates a unique instance of a player named Yuki.
 */
public final class Yuki extends Player {
  /** An unique player named Yuki. */
  private static Yuki uniqueYuki;

  /**
   * Creates a Yuki instance.
   */
  private Yuki() {
    super("Yuki", 5, 2, -1, -1);
  }

  /**
   * Creates a Yuki if there's no Yuki created.
   *
   * @return An unique Yuki
   */
  public static Yuki oneYuki() {
    if (uniqueYuki == null) {
      uniqueYuki = new Yuki();
    }
    return uniqueYuki;
  }
}
