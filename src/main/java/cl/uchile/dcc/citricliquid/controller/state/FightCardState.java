package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Create a Fight Card State.
 */
public class FightCardState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public FightCardState(final Controller context) {
    super(context);
  }

  /**
   * Asks the player and target for a card
   * and changes states to the card activation.
   */
  @Override
  public void toDo() {
    context.promptUseCard();
    context.promptUseCardTarget();
    if (context.getIsPlayingFightCard()) {
      context.fightCardActivation();
    } else {
      context.attack();
    }
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Fight Card State";
  }

  /**
   * Changes the state to Fight Card Activation State.
   */
  @Override
  public void toFightCardActivationState() {
    context.setState(new FightCardActivationState(context));
  }

  /**
   * Changes the state to Attack State.
   */
  @Override
  public void toAttackState() {
    context.setState(new AttackState(context));
  }


  /**
   * Gets if we are in Fight Card State.
   *
   * @return true if it's Fight Card State.
   */
  @Override
  public boolean isFightCardState() {
    return true;
  }
}
