package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates an StartState object to initialize the game.
 */
public class StartState extends State {

  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public StartState(final Controller context) {
    super(context);
  }

  /**
   * Checks if the player is KO
   * if it is goes to Recovery State
   * and tries to recover,
   * if it's not goes to Stars State
   * and gets the initial stars.
   */
  @Override
  public void toDo() {
    if (context.isKo(context.getTurn())) {
      context.recovery();
    } else {
      context.stars();
    }
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Start State";
  }

  /**
   * Changes the state to Recovery State.
   */
  @Override
  public void toRecoveryState() {
    context.setState(new RecoveryState(context));
  }

  /**
   * Changes the state to Starts State.
   */
  @Override
  public void toStarsState() {
    context.setState(new StarsState(context));
  }

  /**
   * Gets if we are in Start State.
   *
   * @return true if it's Start State.
   */
  @Override
  public boolean isStartState() {
    return true;
  }

}
