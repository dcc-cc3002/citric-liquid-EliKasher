package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a Fight Card Activation State.
 */
public class FightCardActivationState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public FightCardActivationState(final Controller context) {
    super(context);
  }

  /**
   * Asks the player and the target to choose a card.
   * Activates its effect and goes to Attack State.
   */
  @Override
  public void toDo() {
    context.promptFightCardSelection();
    context.promptCardSelectionTarget();
    context.activateFightCard();
    context.activateFightCardTarget();
    context.attack();
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Fight Card Activation State";
  }

  /**
   * Changes the state to Attack State.
   */
  @Override
  public void toAttackState() {
    context.setState(new AttackState(context));
  }

  /**
   * Gets if we are in Fight Card Activation State.
   *
   * @return true if it's Fight Card Activation State.
   */
  @Override
  public boolean isFightCardActivationState() {
    return true;
  }
}
