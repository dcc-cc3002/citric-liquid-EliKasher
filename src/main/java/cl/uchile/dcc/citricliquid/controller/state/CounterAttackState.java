package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a Counter Attack State Object.
 */
public class CounterAttackState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public CounterAttackState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Counter Attack State";
  }

  /**
   * Rolls for attack power for the target.
   * Asks the player in turn it's next move.
   * Changes to Counter Evade/Defend according to the response.
   */
  @Override
  public void toDo() {
    context.rollForCounterAtk();
    context.promptTurnDefendEvade();
    if (context.getIsTurnEvading()) {
      context.counterEvade();
    }
    if (context.getIsTurnDefending()) {
      context.counterDefend();
    }
  }

  /**
   * Changes the state to Defend State.
   */
  @Override
  public void toCounterDefendState() {
    context.setState(new CounterDefendState(context));
  }

  /**
   * Changes the state to Evade State.
   */
  @Override
  public void toCounterEvadeState() {
    context.setState(new CounterEvadeState(context));
  }

  /**
   * Gets if we are in Counter Attack State.
   *
   * @return true if it's Counter Attack State
   */
  @Override
  public boolean isCounterAttackState() {
    return true;
  }
}
