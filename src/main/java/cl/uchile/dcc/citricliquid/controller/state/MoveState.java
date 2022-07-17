package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Move State Object.
 */
public class MoveState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public MoveState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Move State";
  }

  /**
   * Moves the player on what is left of the turn.
   */
  @Override
  public void toDo() {
    context.playerMovement();
    if (context.getIsPlayersEncounter()) {
      context.battle();
    }
    if (context.getIsPathSplitEncounter()) {
      context.path();
    }
    if (!context.getIsPlayersEncounter()
        && !context.getIsPathSplitEncounter()) {
      context.panelEffect();
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
   * Changes the State to Path State.
   */
  @Override
  public void toPathState() {
    context.setState(new PathState(context));
  }

  /**
   * Changes the State to Panel Effect State.
   */
  @Override
  public void toPanelEffectState() {
    context.setState(new PanelEffectState(context));
  }

  /**
   * Gets if we are in Move State.
   *
   * @return true if it's Move State
   */
  @Override
  public boolean isMoveState() {
    return true;
  }
}
