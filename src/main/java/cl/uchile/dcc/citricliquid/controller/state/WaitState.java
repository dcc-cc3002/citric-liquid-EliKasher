package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Wait State.
 */
public class WaitState extends State {

  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public WaitState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Wait State";
  }

  /**
   * Checks if a card is being played
   * if it is changes to Card State
   * if it's not changes to Roll State.
   */
  @Override
  public void toDo() {
    context.promptUseCard();
    if (context.getIsPlayingCard()) {
      context.card();
    } else {
      context.roll();
    }
  }

  /**
   * Changes the state to Card State.
   */
  @Override
  public void toCardState() {
    context.setState(new CardState(context));
  }

  /**
   * Changes the state to Roll State.
   */
  @Override
  public void toRollState() {
    context.setState(new RollState(context));
  }

  /**
   * Gets if we are in Wait State.
   *
   * @return true if it's Wait State
   */
  @Override
  public boolean isWaitState() {
    return true;
  }
}
