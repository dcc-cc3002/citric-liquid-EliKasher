package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Attack State.
 */
public class AttackState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public AttackState(final Controller context) {
    super(context);
  }

  /**
   * Rolls for base attack.
   * Asks the target it's next move.
   * If the player evades, changes the state to Evade State.
   * If the player defends, changes the state to Defend State.
   */
  @Override
  public void toDo() {
    context.rollForAtk();
    context.promptDefendEvade();
    if (context.getIsEvading()) {
      context.evade();
    }
    if (context.getIsDefending()) {
      context.defend();
    }
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Attack State";
  }

  /**
   * Changes the state to Evade State.
   */
  @Override
  public void toEvadeState() {
    context.setState(new EvadeState(context));
  }

  /**
   * Changes the state to Defend State.
   */
  @Override
  public void toDefendState() {
    context.setState(new DefendState(context));
  }

  /**
   * Gets if we are in Attack State.
   *
   * @return true if it's Attack State.
   */
  @Override
  public boolean isAttackState() {
    return true;
  }
}
