package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates a new Fight State.
 */
public class FightState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public FightState(final Controller context) {
    super(context);
  }

  /**
   * Prompts the character selection, to attack a player.
   * Changes the state to Fight Card State.
   */
  @Override
  public void toDo() {
    context.promptCharacterSelection();
    context.fightCard();
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Fight State";
  }

  /**
   * Changes the state to Fight Card State.
   */
  @Override
  public void toFightCardState() {
    context.setState(new FightCardState(context));
  }

  /**
   * Gets if we are in Fight State.
   *
   * @return true if it's Fight State.
   */
  @Override
  public boolean isFightState() {
    return true;
  }
}
