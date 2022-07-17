package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Path State Object.
 */
public class PathState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public PathState(final Controller context) {
    super(context);
  }

  /**
   * Asks the player to choose a path.
   * Goes to the Move State.
   */
  @Override
  public void toDo() {
    context.promptPathSelection();
    if (context.getIsPathChosen()) {
      context.move();
    }
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Path State";
  }

  /**
   * Changes the state to Move State.
   */
  @Override
  public void toMoveState() {
    context.setState(new MoveState(context));
  }

  /**
   * Gets if we are in Path State.
   *
   * @return true if it's Path State
   */
  @Override
  public boolean isPathState() {
    return true;
  }
}
