package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates an End Battle State Object.
 */
public class EndBattleState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public EndBattleState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "End Battle State";
  }

  /**
   * Gives the prize to the winner,
   * changes the state to Battle State if there's another player.
   * Changes to Move State if there's no player.
   */
  @Override
  public void toDo() {
    context.battleResult();
    if (context.getListOfFight().size() > 0) {
      context.battle();
    } else {
      context.move();
    }
  }

  /**
   * Changes the state to Battle State.
   */
  @Override
  public void toBattleState() {
    context.setState(new BattleState(context));
  }

  /**
   * Changes the state to Move State.
   */
  @Override
  public void toMoveState() {
    context.setState(new MoveState(context));
  }

  /**
   * Gets if we are in End Battle State.
   *
   * @return true if it's End Battle State.
   */
  @Override
  public boolean isEndBattleState() {
    return true;
  }
}
