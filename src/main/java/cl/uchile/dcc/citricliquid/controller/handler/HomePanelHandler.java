package cl.uchile.dcc.citricliquid.controller.handler;

import cl.uchile.dcc.citricliquid.controller.Controller;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Creates a HomePanelHandler Object.
 */
public class HomePanelHandler implements PropertyChangeListener {
  /** The controller of the game. */
  private Controller controller;

  /**
   * The handler for the player arriving to his own home panel.
   *
   * @param context The controller of the game
   */
  public HomePanelHandler(final Controller context) {
    this.controller = context;
  }

  /**
   * Executes a norma check on the player.
   *
   * @param propertyChangeEvent A PropertyChangeEvent object
   *                           describing the event source
   *                           and the property that has changed.
   */
  @Override
  public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
    controller.normaCheck();
  }
}
