package cl.uchile.dcc.citricliquid.model.board.singleton;

import cl.uchile.dcc.citricliquid.model.board.Player;

/**
 * Creates a unique instance of a player named Tomomo.
 */
public final class Tomomo extends Player {
  /** An unique player named Tomomo. */
  private static Tomomo uniqueTomomo;

  /**
   * Creates a Tomomo instance.
   */
  private Tomomo() {
    super("Tomomo", 4, 2, 0, 0);
  }

  /**
   * Creates a Tomomo if there's no Tomomo created.
   *
   * @return An unique Tomomo
   */
  public static Tomomo oneTomomo() {
    if (uniqueTomomo == null) {
      uniqueTomomo = new Tomomo();
    }
    return uniqueTomomo;
  }
}
