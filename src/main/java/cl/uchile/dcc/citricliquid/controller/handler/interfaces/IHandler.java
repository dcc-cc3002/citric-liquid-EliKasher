package cl.uchile.dcc.citricliquid.controller.handler.interfaces;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Creates an interface for the handlers.
 */
public interface IHandler extends PropertyChangeListener {

  /**
   * Do something on the handled situation.
   *
   * @param propertyChangeEvent A PropertyChangeEvent
   *                            object describing the event source
   *                            and the property that has changed.
   */
  void propertyChange(PropertyChangeEvent propertyChangeEvent);

}
