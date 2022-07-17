package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Final State.
 */
public class FinalState extends State {

  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public FinalState(final Controller context) {
    super(context);
  }

  /**
   * Changes the turn to the next player,
   * sets the number of movements to 0,
   * and goes to Start State.
   */
  @Override
  public void toDo() {
    context.changeTurn();
    context.setNumberOfMovements(0);
    context.start();
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Final State";
  }

  /**
   * Gets if we are in Final State.
   *
   * @return true if it's Final State
   */
  @Override
  public boolean isFinalState() {
    return true;
  }

  /**
   * Changes the state to Start State.
   */
  @Override
  public void toStartState() {
    context.setState(new StartState(context));
  }
}
