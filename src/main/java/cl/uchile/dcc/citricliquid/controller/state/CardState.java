package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Card State Object.
 */
public class CardState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public CardState(final Controller context) {
    super(context);
  }

  /**
   * Asks the player to play a card.
   * If the card is playable goes to
   * Card Activation State.
   * If it's not goes to Roll State.
   */
  @Override
  public void toDo() {
    context.promptCardSelection();
    if (context.getIsCardPlayable()) {
      context.cardActivation();
    } else {
      context.roll();
    }
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Card State";
  }

  /**
   * Changes the state to Roll State.
   */
  @Override
  public void toRollState() {
    context.setState(new RollState(context));
  }

  /**
   * Changes the state to Card Activation State.
   */
  @Override
  public void toCardActivationState() {
    context.setState(new CardActivationState(context));
  }

  /**
   * Gets if we are in Card State.
   *
   * @return true if it's Card State
   */
  @Override
  public boolean isCardState() {
    return true;
  }
}
