package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Evade State Object.
 */
public class EvadeState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public EvadeState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Evade State";
  }

  /**
   * The target rolls for evading power,
   * then is we have more attack power
   * we hit the target.
   * If it dies, the state changes to end battle.
   * If it doesn't we enter Counter Attack State.
   */
  @Override
  public void toDo() {
    context.rollForEvading();
    if (context.getAttackPower() > context.getEvadePower()) {
      context.hitTarget();
      if (context.isKo(context.getTarget())) {
        context.setBattleWinner(context.getTurn());
        context.setBattleLoser(context.getTarget());
        context.endBattle();
      } else {
        context.counter();
      }
    } else {
      context.counter();
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
   * Gets if we are in Evade State.
   *
   * @return true if it's Evade State.
   */
  @Override
  public boolean isEvadeState() {
    return true;
  }
}
