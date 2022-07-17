package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Card Activation State Object.
 */
public class CardActivationState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public CardActivationState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Card Activation State";
  }

  /**
   * Activates the card.
   * Changes the state to Panel Effect State.
   */
  @Override
  public void toDo() {
    context.activateCard();
    context.panelEffect();
  }

  /**
   * Changes the state to Panel Effect State.
   */
  @Override
  public void toPanelEffectState() {
    context.setState(new PanelEffectState(context));
  }

  /**
   * Gets if we are in Card Activation State.
   *
   * @return true if it's Card Activation State
   */
  @Override
  public boolean isCardActivationState() {
    return true;
  }
}
