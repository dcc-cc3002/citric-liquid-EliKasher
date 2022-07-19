package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a Battle State Object.
 */
public class BattleState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public BattleState(final Controller context) {
    super(context);
  }

  /**
   * Asks the player if it wants to fight and
   * changes the state to fight or move.
   */
  @Override
  public void toDo() {
    context.promptChooseToFight();
    if (context.getWantsToFight()) {
      context.fight();
    } else {
      context.move();
    }
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Battle State";
  }

  /**
   * Gets if we are in Battle State.
   *
   * @return true if it's Battle State
   */
  @Override
  public boolean isBattleState() {
    return true;
  }

  /**
   * Changes the state to Fight State.
   */
  @Override
  public void toFightState() {
    context.setState(new FightState(context));
  }

  /**
   * Changes the state to Move State.
   */
  @Override
  public void toMoveState() {
    context.setState(new MoveState(context));
  }
}
