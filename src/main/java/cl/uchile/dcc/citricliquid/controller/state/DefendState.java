package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Defend State Object.
 */
public class DefendState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public DefendState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Defend State";
  }

  /**
   * Rolls for defense power,
   * the target gets hit with defense power.
   * If it dies, changes the state to End Battle State.
   * If it doesn't change the state to Counter Attack State.
   */
  @Override
  public void toDo() {
    context.rollForDefending();
    context.hitTargetWithDefense();
    if (!context.isKo(context.getTarget())) {
      context.counter();
    } else {
      context.setBattleWinner(context.getTurn());
      context.setBattleLoser(context.getTarget());
      context.endBattle();
    }
  }

  /**
   * Changes the state to Counter Attack State.
   */
  @Override
  public void toCounterAttackState() {
    context.setState(new CounterAttackState(context));
  }


  /**
   * Changes the state to End Battle State.
   */
  public void toEndBattleState() {
    context.setState(new EndBattleState(context));
  }

  /**
   * Gets if we are in Defend State.
   *
   * @return true if it's Defend State
   */
  @Override
  public boolean isDefendState() {
    return true;
  }
}
