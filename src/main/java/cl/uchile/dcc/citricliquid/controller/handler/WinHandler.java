package cl.uchile.dcc.citricliquid.controller.handler;

import cl.uchile.dcc.citricliquid.controller.Controller;
import cl.uchile.dcc.citricliquid.controller.handler.interfaces.IHandler;
import cl.uchile.dcc.citricliquid.model.board.players.Player;

import java.beans.PropertyChangeEvent;

/**
 * Creates a Win Handler.
 */
public class WinHandler implements IHandler {
  /** The controller of the game. */
  private Controller controller;

  /**
   * Creates a Win Handler with a determined controller.
   *
   * @param context The game controller
   */
  public WinHandler(final Controller context) {
    this.controller = context;
  }

  /**
   * Changes the winner to the player with norma = 6.
   *
   * @param propertyChangeEvent A PropertyChangeEvent
   *                           object describing the event source
   *                           and the property that has changed.
   */
  @Override
  public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
    controller.setWinner((Player) propertyChangeEvent.getNewValue());
  }
}
