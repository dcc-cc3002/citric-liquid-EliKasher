package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Recovery State.
 */
public class RecoveryState extends State {

  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public RecoveryState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Recovery State";
  }

  /**
   * Checks if the player is recovered
   * otherwise ends the turn.
   */
  @Override
  public void toDo() {
    context.promptThrowAction();
    if (context.getNumberOfMovements() == context.getRecoveryNumber()) {
      context.recovered();
      context.stars();
    } else {
      context.end();
    }
  }

  /**
   * Changes the state to the Starts State.
   */
  @Override
  public void toStarsState() {
    context.setState(new StarsState(context));
  }

  /**
   * Changes the state to the Final State.
   */
  @Override
  public void toFinalState() {
    context.setState(new FinalState(context));
  }

  /**
   * Gets if we are in Recovery State.
   *
   * @return true if it's Recovery State
   */
  @Override
  public boolean isRecoveryState() {
    return true;
  }
}
