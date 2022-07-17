package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Roll State.
 */
public class RollState extends State {

  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public RollState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Roll State";
  }

  /**
   * If there's a split goes to Path State.
   * If there's not, checks if the player wants to fight a nearby player.
   * (Goes to Battle State)
   * If not, checks if the player wants to stop at a nearby home panel.
   * (Goes to Panel Effect State)
   * If not, it moves the quantity indicated on the dice.
   */
  @Override
  public void toDo() {
      context.promptThrowAction();
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
   * Gets if we are in Roll State.
   *
   * @return true if it's Roll State
   */
  @Override
  public boolean isRollState() {
    return true;
  }
}
