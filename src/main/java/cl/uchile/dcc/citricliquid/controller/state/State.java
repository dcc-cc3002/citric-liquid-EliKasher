package cl.uchile.dcc.citricliquid.controller.state;

import cl.uchile.dcc.citricliquid.controller.Controller;
import cl.uchile.dcc.citricliquid.exceptions.InvalidStateOperationException;

/**
 * Creates the States of the Game.
 */
public class State {
  /**
   * The controller of the game.
   */
  protected final Controller context;

  /**
   * Sets the state of the game.
   *
   * @param controller The controller of the game.
   */
  public State(final Controller controller) {
    this.context = controller;
  }

  /**
   * Gets the controller of the state.
   *
   * @return a controller
   */
  public Controller getController() {
    return context;
  }


  /**
   * Gets the name of the actual state.
   *
   * @return The name of the state
   */
  public String toString() {
    return "State";
  }

  /**
   * The action that corresponds to the actual state of the game.
   */
  public void toDo() {

  }

  /**
   * Changes the state to Start State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toStartState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Start State.
   *
   * @return true if it's in Start State
   */
  public boolean isStartState() {
    return false;
  }

  /**
   * Changes the state to Wait State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toWaitState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Wait State.
   *
   * @return true if it's in Wait State
   */
  public boolean isWaitState() {
    return false;
  }

  /**
   * Changes the state to Stars State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toStarsState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Stars State.
   *
   * @return true if it's in Stars State
   */
  public boolean isStarsState() {
    return false;
  }

  /**
   * Changes the state to Recovery State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toRecoveryState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Recovery State.
   *
   * @return true if it's in Recovery State
   */
  public boolean isRecoveryState() {
    return false;
  }

  /**
   * Changes the state to Card State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toCardState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Card State.
   *
   * @return true if it's in Card State
   */
  public boolean isCardState() {
    return false;
  }

  /**
   * Changes the state to Roll State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toRollState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Roll State.
   *
   * @return true if it's in Roll State
   */
  public boolean isRollState() {
    return false;
  }

  /**
   * Changes the state to Battle State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toBattleState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Battle State.
   *
   * @return true if it's in Battle State
   */
  public boolean isBattleState() {
    return false;
  }

  /**
   * Changes the state to Fight State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toFightState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Fight State.
   *
   * @return true if it's in Fight State
   */
  public boolean isFightState() {
    return false;
  }

  /**
   * Changes the state to Evade State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toEvadeState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Evade State.
   *
   * @return true if it's in Evade State
   */
  public boolean isEvadeState() {
    return false;
  }

  /**
   * Changes the state to Defend State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toDefendState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Defend State.
   *
   * @return true if it's in Defend State
   */
  public boolean isDefendState() {
    return false;
  }

  /**
   * Changes the state to Counter Attack State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toCounterAttackState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Counter Attack State.
   *
   * @return true if it's in Counter Attack State
   */
  public boolean isCounterAttackState() {
    return false;
  }

  /**
   * Changes the state to Path State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toPathState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Path State.
   *
   * @return true if it's in Path State
   */
  public boolean isPathState() {
    return false;
  }

  /**
   * Changes the state to Card Activation State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toCardActivationState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Card Activation State.
   *
   * @return true if it's in Card Activation State
   */
  public boolean isCardActivationState() {
    return false;
  }

  /**
   * Changes the state to Fight Card State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toFightCardState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Fight Card State.
   *
   * @return true if it's in Fight Card State
   */
  public boolean isFightCardState() {
    return false;
  }

  /**
   * Changes the state to Fight Card Activation State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toFightCardActivationState()
      throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Fight Card Activation State.
   *
   * @return true if it's in Fight Card Activation State
   */
  public boolean isFightCardActivationState() {
    return false;
  }

  /**
   * Changes the state to Attack State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toAttackState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Attack State.
   *
   * @return true if it's in Attack State
   */
  public boolean isAttackState() {
    return false;
  }


  /**
   * Changes the state to Move State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toMoveState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Move State.
   *
   * @return true if it's in Move State
   */
  public boolean isMoveState() {
    return false;
  }

  /**
   * Changes the state to Panel Effect State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toPanelEffectState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Panel Effect State.
   *
   * @return true if it's in Panel Effect State
   */
  public boolean isPanelEffectState() {
    return false;
  }

  /**
   * Changes the state to Final State.
   *
   * @throws InvalidStateOperationException Invalid state
   */
  public void toFinalState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Final State.
   *
   * @return true if it's in Final State
   */
  public boolean isFinalState() {
    return false;
  }

  /**
   * Changes the state to End Battle State.
   *
   * @throws InvalidStateOperationException Invalid State
   */
  public void toEndBattleState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in End Battle State.
   *
   * @return true if it's in End Battle State
   */
  public boolean isEndBattleState() {
    return false;
  }

  /**
   * Changes the state to Counter Evade State.
   *
   * @throws InvalidStateOperationException Invalid State
   */
  public void toCounterEvadeState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Counter Evade State.
   *
   * @return true if it's in Counter Evade State
   */
  public boolean isCounterEvadeState() {
    return false;
  }

  /**
   * Changes the state to Counter Defend State.
   *
   * @throws InvalidStateOperationException Invalid State
   */
  public void toCounterDefendState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  /**
   * Gets if we are in Counter Defend State.
   *
   * @return true if it's in Counter Defend State
   */
  public boolean isCounterDefendState() {
    return false;
  }
}
