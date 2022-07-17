package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Stars State Object.
 */
public class StarsState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public StarsState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Stars State";
  }

  /**
   * Sets the initial stars,
   * and goes ot wait state.
   * Tries to Wait for the
   * players input.
   */
  @Override
  public void toDo() {
    context.setInitialStars();
    context.waitPlayer();
  }

  /**
   * Changes the state to the Wait State.
   */
  @Override
  public void toWaitState() {
    context.setState(new WaitState(context));
  }

  /**
   * Gets if we are in Stars State.
   *
   * @return true if it's Stars State
   */
  @Override
  public boolean isStarsState() {
    return true;
  }
}
