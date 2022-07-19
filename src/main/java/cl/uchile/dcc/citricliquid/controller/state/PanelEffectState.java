package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;

/**
 * Creates the Panel Effect State.
 */
public class PanelEffectState extends State {
  /**
   * Sets the state of the game.
   *
   * @param context The controller of the game.
   */
  public PanelEffectState(final Controller context) {
    super(context);
  }

  /**
   * Gets the actual state.
   *
   * @return the actual state
   */
  @Override
  public String toString() {
    return "Panel Effect State";
  }

  /**
   * Activates the effect of the
   * panel and ends the turn.
   */
  @Override
  public void toDo() {
    context.activatedBy();
    context.end();
  }

  /**
   * Changes the state to Final State.
   */
  @Override
  public void toFinalState() {
    context.setState(new FinalState(context));
  }

  /**
   * Gets if we are in Panel Effect State.
   *
   * @return true if it's Panel Effect State
   */
  @Override
  public boolean isPanelEffectState() {
    return true;
  }

}