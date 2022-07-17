package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a Counter Defend State Object.
 */
public class CounterDefendState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public CounterDefendState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Counter Defend State";
  }

  /**
   * Rolls for defense power,
   * the target gets hit with defense power.
   * If it dies, changes the state to End Battle State.
   * If it doesn't change the state to Counter Attack State.
   */
  @Override
  public void toDo() {
    context.rollTurnForDefending();
    context.hitTurnWithDefense();
    if (!context.isKo(context.getTurn())) {
      context.attack();
    } else {
      context.setBattleWinner(context.getTarget());
      context.setBattleLoser(context.getTurn());
      context.endBattle();
    }
  }

  /**
   * Changes the state to Attack State.
   */
  @Override
  public void toAttackState() {
    context.setState(new AttackState(context));
  }


  /**
   * Changes the state to End Battle State.
   */
  public void toEndBattleState() {
    context.setState(new EndBattleState(context));
  }

  /**
   * Gets if we are in Counter Defend State.
   *
   * @return true if it's Counter Defend State
   */
  @Override
  public boolean isCounterDefendState() {
    return true;
  }
}
