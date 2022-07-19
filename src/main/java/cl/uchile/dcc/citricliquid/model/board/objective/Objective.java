package cl.uchile.dcc.citricliquid.model.board.objective;

/**
 * It's the class Objective for the objectives of the game.
 */
public class Objective {
  /** The number that indicates the actual objective. */
  private int objective;

  /**
   * Creates a class with an objective for the player.
   *
   * @param obj It's the mission we want to accomplish to win the game
   *            0: Stars Norma
   *            1: Wins Norma
   */
  public Objective(final int obj) {
    objective = obj;
  }

  /**
   * Gets the objective of the game.
   *
   * @return the actual objective in the game
   *     0: Stars Norma
   *     1: Wins Norma
   */
  public int getObjective() {
    return objective;
  }

  /**
   * Changes the actual objective in the game.
   *
   * @param newObj It refers to the Wins Norma or the Stars Norma
   *               0: Stars Norma
   *               1: Wins Norma
   */
  public void changeObjective(final int newObj) {
    this.objective = newObj;
  }

  /**
   * Gets the actual objective.
   *
   * @return The actual objective of the players game
   */
  public String toString() {
    if (getObjective() == 1) {
      return "WINS";
    }
    if (getObjective() == 0) {
      return "STARS";
    } else {
      return "NOT AN OBJECTIVE";
    }
  }
}
