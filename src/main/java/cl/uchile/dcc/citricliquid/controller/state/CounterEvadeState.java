package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a Counter Evade State Object.
 */
public class CounterEvadeState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public CounterEvadeState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Counter Evade State";
  }

  /**
   * The player in turn rolls for evading power,
   * then is we have more attack power
   * we hit the player.
   * If it dies, the state changes to end battle.
   * If it doesn't we enter Counter Attack State.
   */
  @Override
  public void toDo() {
    context.rollTurnForEvading();
    if (context.getCounterAttackPower() > context.getCounterEvadePower()) {
      context.hitTurn();
      if (context.isKo(context.getTurn())) {
        context.setBattleWinner(context.getTarget());
        context.setBattleLoser(context.getTurn());
        context.endBattle();
      } else {
        context.attack();
      }
    } else {
      context.attack();
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
   * Gets if we are in Counter Evade State.
   *
   * @return true if it's Counter Evade State.
   */
  @Override
  public boolean isCounterEvadeState() {
    return true;
  }
}
