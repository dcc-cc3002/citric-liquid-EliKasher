package cl.uchile.dcc.citricliquid.model.board;

import static org.junit.jupiter.api.Assertions.*;
import cl.uchile.dcc.citricliquid.controller.Controller;
import cl.uchile.dcc.citricliquid.controller.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTest {
  Controller controller;
  StartState startState;
  RecoveryState recoveryState;
  StarsState starsState;
  WaitState waitState;
  CardState cardState;
  FightCardState fightCardState;
  RollState rollState;
  BattleState battleState;
  FightState fightState;
  CardActivationState cardActivationState;
  FightCardActivationState fightCardActivationState;
  PathState pathState;
  MoveState moveState;
  PanelEffectState panelEffectState;
  DefendState defendState;
  CounterDefendState counterDefendState;
  EvadeState evadeState;
  CounterEvadeState counterEvadeState;
  AttackState attackState;
  CounterAttackState counterAttackState;
  EndBattleState endBattleState;
  FinalState finalState;

  State state;


  @BeforeEach
  public void setUp() {
    controller = new Controller();
    startState = new StartState(controller);
    recoveryState = new RecoveryState(controller);
    starsState = new StarsState(controller);
    waitState = new WaitState(controller);
    cardState = new CardState(controller);
    fightCardState = new FightCardState(controller);
    rollState = new RollState(controller);
    battleState = new BattleState(controller);
    fightState = new FightState(controller);
    cardActivationState = new CardActivationState(controller);
    fightCardActivationState = new FightCardActivationState(controller);
    pathState = new PathState(controller);
    moveState = new MoveState(controller);
    panelEffectState = new PanelEffectState(controller);
    attackState = new AttackState(controller);
    defendState = new DefendState(controller);
    evadeState = new EvadeState(controller);
    counterAttackState = new CounterAttackState(controller);
    counterDefendState = new CounterDefendState(controller);
    counterEvadeState = new CounterEvadeState(controller);
    endBattleState = new EndBattleState(controller);
    finalState = new FinalState(controller);
    state = new State(controller);
  }

  @Test
  public void toStringTest() {
    assertEquals("Start State", startState.toString());
    assertEquals("Recovery State", recoveryState.toString());
    assertEquals("Stars State", starsState.toString());
    assertEquals("Wait State", waitState.toString());
    assertEquals("Card State", cardState.toString());
    assertEquals("Fight Card State", fightCardState.toString());
    assertEquals("Roll State", rollState.toString());
    assertEquals("Battle State", battleState.toString());
    assertEquals("Fight State", fightState.toString());
    assertEquals("Card Activation State", cardActivationState.toString());
    assertEquals("Fight Card Activation State", fightCardActivationState.toString());
    assertEquals("Path State", pathState.toString());
    assertEquals("Move State", moveState.toString());
    assertEquals("Panel Effect State", panelEffectState.toString());
    assertEquals("Attack State", attackState.toString());
    assertEquals("Defend State", defendState.toString());
    assertEquals("Evade State", evadeState.toString());
    assertEquals("Counter Attack State", counterAttackState.toString());
    assertEquals("Counter Defend State", counterDefendState.toString());
    assertEquals("Counter Evade State", counterEvadeState.toString());
    assertEquals("End Battle State", endBattleState.toString());
    assertEquals("Final State", finalState.toString());
    assertEquals("State", state.toString());
  }

  @Test
  public void isStateTest() {
    assertTrue(startState.isStartState());
    assertFalse(startState.isRecoveryState());
    assertFalse(startState.isStarsState());
    assertFalse(startState.isWaitState());
    assertFalse(startState.isCardState());
    assertFalse(starsState.isFightCardState());
    assertFalse(startState.isRollState());
    assertFalse(startState.isBattleState());
    assertFalse(startState.isFightState());
    assertFalse(startState.isCardActivationState());
    assertFalse(startState.isFightCardActivationState());
    assertFalse(startState.isPathState());
    assertFalse(startState.isMoveState());
    assertFalse(startState.isPanelEffectState());
    assertFalse(startState.isAttackState());
    assertFalse(startState.isDefendState());
    assertFalse(starsState.isEvadeState());
    assertFalse(startState.isCounterAttackState());
    assertFalse(startState.isCounterDefendState());
    assertFalse(startState.isCounterEvadeState());
    assertFalse(startState.isEndBattleState());
    assertFalse(startState.isFinalState());

    assertTrue(recoveryState.isRecoveryState());
    assertFalse(recoveryState.isStartState());
    assertFalse(recoveryState.isStarsState());
    assertFalse(recoveryState.isWaitState());
    assertFalse(recoveryState.isCardState());
    assertFalse(recoveryState.isFightCardState());
    assertFalse(recoveryState.isRollState());
    assertFalse(recoveryState.isBattleState());
    assertFalse(recoveryState.isFightState());
    assertFalse(recoveryState.isCardActivationState());
    assertFalse(recoveryState.isFightCardActivationState());
    assertFalse(recoveryState.isPathState());
    assertFalse(recoveryState.isMoveState());
    assertFalse(recoveryState.isPanelEffectState());
    assertFalse(recoveryState.isAttackState());
    assertFalse(recoveryState.isDefendState());
    assertFalse(recoveryState.isEvadeState());
    assertFalse(recoveryState.isCounterAttackState());
    assertFalse(recoveryState.isCounterDefendState());
    assertFalse(recoveryState.isCounterEvadeState());
    assertFalse(recoveryState.isEndBattleState());
    assertFalse(recoveryState.isFinalState());

    assertTrue(starsState.isStarsState());
    assertFalse(starsState.isRecoveryState());
    assertFalse(starsState.isStartState());
    assertFalse(starsState.isWaitState());
    assertFalse(starsState.isCardState());
    assertFalse(starsState.isFightCardState());
    assertFalse(starsState.isRollState());
    assertFalse(starsState.isBattleState());
    assertFalse(starsState.isFightState());
    assertFalse(starsState.isCardActivationState());
    assertFalse(starsState.isFightCardActivationState());
    assertFalse(starsState.isPathState());
    assertFalse(starsState.isMoveState());
    assertFalse(starsState.isPanelEffectState());
    assertFalse(starsState.isAttackState());
    assertFalse(starsState.isDefendState());
    assertFalse(starsState.isEvadeState());
    assertFalse(starsState.isCounterAttackState());
    assertFalse(starsState.isCounterDefendState());
    assertFalse(starsState.isCounterEvadeState());
    assertFalse(starsState.isEndBattleState());
    assertFalse(starsState.isFinalState());

    assertTrue(waitState.isWaitState());
    assertFalse(waitState.isRecoveryState());
    assertFalse(waitState.isStarsState());
    assertFalse(waitState.isStartState());
    assertFalse(waitState.isCardState());
    assertFalse(waitState.isFightCardState());
    assertFalse(waitState.isRollState());
    assertFalse(waitState.isBattleState());
    assertFalse(waitState.isFightState());
    assertFalse(waitState.isCardActivationState());
    assertFalse(waitState.isFightCardActivationState());
    assertFalse(waitState.isPathState());
    assertFalse(waitState.isMoveState());
    assertFalse(waitState.isPanelEffectState());
    assertFalse(waitState.isAttackState());
    assertFalse(waitState.isDefendState());
    assertFalse(waitState.isEvadeState());
    assertFalse(waitState.isCounterAttackState());
    assertFalse(waitState.isCounterEvadeState());
    assertFalse(waitState.isCounterDefendState());
    assertFalse(waitState.isEndBattleState());
    assertFalse(waitState.isFinalState());

    assertTrue(cardState.isCardState());
    assertFalse(cardState.isFightCardState());
    assertFalse(cardState.isRecoveryState());
    assertFalse(cardState.isStarsState());
    assertFalse(cardState.isWaitState());
    assertFalse(cardState.isStartState());
    assertFalse(cardState.isRollState());
    assertFalse(cardState.isBattleState());
    assertFalse(cardState.isFightState());
    assertFalse(cardState.isCardActivationState());
    assertFalse(cardState.isFightCardActivationState());
    assertFalse(cardState.isPathState());
    assertFalse(cardState.isMoveState());
    assertFalse(cardState.isPanelEffectState());
    assertFalse(cardState.isAttackState());
    assertFalse(cardState.isDefendState());
    assertFalse(cardState.isEvadeState());
    assertFalse(cardState.isCounterAttackState());
    assertFalse(cardState.isCounterEvadeState());
    assertFalse(cardState.isCounterDefendState());
    assertFalse(cardState.isEndBattleState());
    assertFalse(cardState.isFinalState());

    assertTrue(fightCardState.isFightCardState());
    assertFalse(fightCardState.isCardState());
    assertFalse(fightCardState.isRecoveryState());
    assertFalse(fightCardState.isStarsState());
    assertFalse(fightCardState.isWaitState());
    assertFalse(fightCardState.isStartState());
    assertFalse(fightCardState.isRollState());
    assertFalse(fightCardState.isBattleState());
    assertFalse(fightCardState.isFightState());
    assertFalse(fightCardState.isCardActivationState());
    assertFalse(fightCardState.isFightCardActivationState());
    assertFalse(fightCardState.isPathState());
    assertFalse(fightCardState.isMoveState());
    assertFalse(fightCardState.isPanelEffectState());
    assertFalse(fightCardState.isAttackState());
    assertFalse(fightCardState.isDefendState());
    assertFalse(fightCardState.isEvadeState());
    assertFalse(fightCardState.isCounterAttackState());
    assertFalse(fightCardState.isCounterEvadeState());
    assertFalse(fightCardState.isCounterDefendState());
    assertFalse(fightCardState.isEndBattleState());
    assertFalse(fightCardState.isFinalState());

    assertTrue(rollState.isRollState());
    assertFalse(rollState.isRecoveryState());
    assertFalse(rollState.isStarsState());
    assertFalse(rollState.isWaitState());
    assertFalse(rollState.isCardState());
    assertFalse(rollState.isFightCardState());
    assertFalse(rollState.isStartState());
    assertFalse(rollState.isBattleState());
    assertFalse(rollState.isFightState());
    assertFalse(rollState.isCardActivationState());
    assertFalse(rollState.isFightCardActivationState());
    assertFalse(rollState.isPathState());
    assertFalse(rollState.isMoveState());
    assertFalse(rollState.isPanelEffectState());
    assertFalse(rollState.isAttackState());
    assertFalse(rollState.isDefendState());
    assertFalse(rollState.isEvadeState());
    assertFalse(rollState.isCounterAttackState());
    assertFalse(rollState.isCounterEvadeState());
    assertFalse(rollState.isCounterDefendState());
    assertFalse(rollState.isEndBattleState());
    assertFalse(rollState.isFinalState());

    assertTrue(battleState.isBattleState());
    assertFalse(battleState.isFightState());
    assertFalse(battleState.isRecoveryState());
    assertFalse(battleState.isStarsState());
    assertFalse(battleState.isWaitState());
    assertFalse(battleState.isCardState());
    assertFalse(battleState.isFightCardState());
    assertFalse(battleState.isRollState());
    assertFalse(battleState.isStartState());
    assertFalse(battleState.isCardActivationState());
    assertFalse(battleState.isFightCardActivationState());
    assertFalse(battleState.isPathState());
    assertFalse(battleState.isMoveState());
    assertFalse(battleState.isPanelEffectState());
    assertFalse(battleState.isAttackState());
    assertFalse(battleState.isDefendState());
    assertFalse(battleState.isEvadeState());
    assertFalse(battleState.isCounterAttackState());
    assertFalse(battleState.isCounterDefendState());
    assertFalse(battleState.isCounterEvadeState());
    assertFalse(battleState.isEndBattleState());
    assertFalse(battleState.isFinalState());

    assertTrue(fightState.isFightState());
    assertFalse(fightState.isBattleState());
    assertFalse(fightState.isRecoveryState());
    assertFalse(fightState.isStarsState());
    assertFalse(fightState.isWaitState());
    assertFalse(fightState.isCardState());
    assertFalse(fightState.isFightCardState());
    assertFalse(fightState.isRollState());
    assertFalse(fightState.isStartState());
    assertFalse(fightState.isCardActivationState());
    assertFalse(fightState.isFightCardActivationState());
    assertFalse(fightState.isPathState());
    assertFalse(fightState.isMoveState());
    assertFalse(fightState.isPanelEffectState());
    assertFalse(fightState.isAttackState());
    assertFalse(fightState.isDefendState());
    assertFalse(fightState.isEvadeState());
    assertFalse(fightState.isCounterAttackState());
    assertFalse(fightState.isCounterDefendState());
    assertFalse(fightState.isCounterEvadeState());
    assertFalse(fightState.isEndBattleState());
    assertFalse(fightState.isFinalState());

    assertTrue(cardActivationState.isCardActivationState());
    assertFalse(cardActivationState.isFightCardActivationState());
    assertFalse(cardActivationState.isRecoveryState());
    assertFalse(cardActivationState.isStarsState());
    assertFalse(cardActivationState.isWaitState());
    assertFalse(cardActivationState.isCardState());
    assertFalse(cardActivationState.isFightCardState());
    assertFalse(cardActivationState.isRollState());
    assertFalse(cardActivationState.isBattleState());
    assertFalse(cardActivationState.isFightState());
    assertFalse(cardActivationState.isStartState());
    assertFalse(cardActivationState.isPathState());
    assertFalse(cardActivationState.isMoveState());
    assertFalse(cardActivationState.isPanelEffectState());
    assertFalse(cardActivationState.isAttackState());
    assertFalse(cardActivationState.isDefendState());
    assertFalse(cardActivationState.isEvadeState());
    assertFalse(cardActivationState.isCounterAttackState());
    assertFalse(cardActivationState.isCounterDefendState());
    assertFalse(cardActivationState.isCounterEvadeState());
    assertFalse(cardActivationState.isEndBattleState());
    assertFalse(cardActivationState.isFinalState());

    assertTrue(fightCardActivationState.isFightCardActivationState());
    assertFalse(fightCardActivationState.isCardActivationState());
    assertFalse(fightCardActivationState.isRecoveryState());
    assertFalse(fightCardActivationState.isStarsState());
    assertFalse(fightCardActivationState.isWaitState());
    assertFalse(fightCardActivationState.isCardState());
    assertFalse(fightCardActivationState.isFightCardState());
    assertFalse(fightCardActivationState.isRollState());
    assertFalse(fightCardActivationState.isBattleState());
    assertFalse(fightCardActivationState.isFightState());
    assertFalse(fightCardActivationState.isStartState());
    assertFalse(fightCardActivationState.isPathState());
    assertFalse(fightCardActivationState.isMoveState());
    assertFalse(fightCardActivationState.isPanelEffectState());
    assertFalse(fightCardActivationState.isAttackState());
    assertFalse(fightCardActivationState.isDefendState());
    assertFalse(fightCardActivationState.isEvadeState());
    assertFalse(fightCardActivationState.isCounterAttackState());
    assertFalse(fightCardActivationState.isCounterDefendState());
    assertFalse(fightCardActivationState.isCounterEvadeState());
    assertFalse(fightCardActivationState.isEndBattleState());
    assertFalse(fightCardActivationState.isFinalState());

    assertTrue(pathState.isPathState());
    assertFalse(pathState.isRecoveryState());
    assertFalse(pathState.isStarsState());
    assertFalse(pathState.isWaitState());
    assertFalse(pathState.isCardState());
    assertFalse(pathState.isFightCardState());
    assertFalse(pathState.isRollState());
    assertFalse(pathState.isBattleState());
    assertFalse(pathState.isFightState());
    assertFalse(pathState.isCardActivationState());
    assertFalse(pathState.isFightCardActivationState());
    assertFalse(pathState.isStartState());
    assertFalse(pathState.isMoveState());
    assertFalse(pathState.isPanelEffectState());
    assertFalse(pathState.isAttackState());
    assertFalse(pathState.isDefendState());
    assertFalse(pathState.isEvadeState());
    assertFalse(pathState.isCounterAttackState());
    assertFalse(pathState.isCounterDefendState());
    assertFalse(pathState.isCounterEvadeState());
    assertFalse(pathState.isEndBattleState());
    assertFalse(pathState.isFinalState());

    assertTrue(moveState.isMoveState());
    assertFalse(moveState.isRecoveryState());
    assertFalse(moveState.isStarsState());
    assertFalse(moveState.isWaitState());
    assertFalse(moveState.isCardState());
    assertFalse(moveState.isFightCardState());
    assertFalse(moveState.isRollState());
    assertFalse(moveState.isBattleState());
    assertFalse(moveState.isFightState());
    assertFalse(moveState.isCardActivationState());
    assertFalse(moveState.isFightCardActivationState());
    assertFalse(moveState.isPathState());
    assertFalse(moveState.isStartState());
    assertFalse(moveState.isPanelEffectState());
    assertFalse(moveState.isAttackState());
    assertFalse(moveState.isDefendState());
    assertFalse(moveState.isEvadeState());
    assertFalse(moveState.isCounterAttackState());
    assertFalse(moveState.isCounterDefendState());
    assertFalse(moveState.isCounterEvadeState());
    assertFalse(moveState.isEndBattleState());
    assertFalse(moveState.isFinalState());

    assertTrue(panelEffectState.isPanelEffectState());
    assertFalse(panelEffectState.isRecoveryState());
    assertFalse(panelEffectState.isStarsState());
    assertFalse(panelEffectState.isWaitState());
    assertFalse(panelEffectState.isCardState());
    assertFalse(panelEffectState.isFightCardState());
    assertFalse(panelEffectState.isRollState());
    assertFalse(panelEffectState.isBattleState());
    assertFalse(panelEffectState.isFightState());
    assertFalse(panelEffectState.isCardActivationState());
    assertFalse(panelEffectState.isFightCardActivationState());
    assertFalse(panelEffectState.isPathState());
    assertFalse(panelEffectState.isMoveState());
    assertFalse(panelEffectState.isStartState());
    assertFalse(panelEffectState.isAttackState());
    assertFalse(panelEffectState.isDefendState());
    assertFalse(panelEffectState.isEvadeState());
    assertFalse(panelEffectState.isCounterAttackState());
    assertFalse(panelEffectState.isCounterEvadeState());
    assertFalse(panelEffectState.isCounterDefendState());
    assertFalse(panelEffectState.isEndBattleState());
    assertFalse(panelEffectState.isFinalState());

    assertTrue(counterDefendState.isCounterDefendState());
    assertFalse(counterDefendState.isDefendState());
    assertFalse(counterDefendState.isRecoveryState());
    assertFalse(counterDefendState.isStarsState());
    assertFalse(counterDefendState.isWaitState());
    assertFalse(counterDefendState.isCardState());
    assertFalse(counterDefendState.isFightCardState());
    assertFalse(counterDefendState.isRollState());
    assertFalse(counterDefendState.isBattleState());
    assertFalse(counterDefendState.isFightState());
    assertFalse(counterDefendState.isCardActivationState());
    assertFalse(counterDefendState.isFightCardActivationState());
    assertFalse(counterDefendState.isPathState());
    assertFalse(counterDefendState.isMoveState());
    assertFalse(counterDefendState.isPanelEffectState());
    assertFalse(counterDefendState.isStartState());
    assertFalse(counterDefendState.isAttackState());
    assertFalse(counterDefendState.isEvadeState());
    assertFalse(counterDefendState.isCounterAttackState());
    assertFalse(counterDefendState.isCounterEvadeState());
    assertFalse(counterDefendState.isEndBattleState());
    assertFalse(counterDefendState.isFinalState());

    assertTrue(defendState.isDefendState());
    assertFalse(defendState.isCounterDefendState());
    assertFalse(defendState.isRecoveryState());
    assertFalse(defendState.isStarsState());
    assertFalse(defendState.isWaitState());
    assertFalse(defendState.isCardState());
    assertFalse(defendState.isFightCardState());
    assertFalse(defendState.isRollState());
    assertFalse(defendState.isBattleState());
    assertFalse(defendState.isFightState());
    assertFalse(defendState.isCardActivationState());
    assertFalse(defendState.isFightCardActivationState());
    assertFalse(defendState.isPathState());
    assertFalse(defendState.isMoveState());
    assertFalse(defendState.isPanelEffectState());
    assertFalse(defendState.isStartState());
    assertFalse(defendState.isAttackState());
    assertFalse(defendState.isEvadeState());
    assertFalse(defendState.isCounterAttackState());
    assertFalse(defendState.isCounterEvadeState());
    assertFalse(defendState.isEndBattleState());
    assertFalse(defendState.isFinalState());

    assertTrue(evadeState.isEvadeState());
    assertFalse(evadeState.isCounterEvadeState());
    assertFalse(evadeState.isRecoveryState());
    assertFalse(evadeState.isStarsState());
    assertFalse(evadeState.isWaitState());
    assertFalse(evadeState.isCardState());
    assertFalse(evadeState.isFightCardState());
    assertFalse(evadeState.isRollState());
    assertFalse(evadeState.isBattleState());
    assertFalse(evadeState.isFightState());
    assertFalse(evadeState.isCardActivationState());
    assertFalse(evadeState.isPathState());
    assertFalse(evadeState.isMoveState());
    assertFalse(evadeState.isPanelEffectState());
    assertFalse(evadeState.isStartState());
    assertFalse(evadeState.isDefendState());
    assertFalse(evadeState.isCounterAttackState());
    assertFalse(evadeState.isEndBattleState());
    assertFalse(evadeState.isFinalState());

    assertTrue(counterEvadeState.isCounterEvadeState());
    assertFalse(counterEvadeState.isEvadeState());
    assertFalse(counterEvadeState.isRecoveryState());
    assertFalse(counterEvadeState.isStarsState());
    assertFalse(counterEvadeState.isWaitState());
    assertFalse(counterEvadeState.isCardState());
    assertFalse(counterEvadeState.isFightCardState());
    assertFalse(counterEvadeState.isRollState());
    assertFalse(counterEvadeState.isBattleState());
    assertFalse(counterEvadeState.isFightState());
    assertFalse(counterEvadeState.isCardActivationState());
    assertFalse(counterEvadeState.isPathState());
    assertFalse(counterEvadeState.isMoveState());
    assertFalse(counterEvadeState.isPanelEffectState());
    assertFalse(counterEvadeState.isStartState());
    assertFalse(counterEvadeState.isDefendState());
    assertFalse(counterEvadeState.isCounterAttackState());
    assertFalse(counterEvadeState.isEndBattleState());
    assertFalse(counterEvadeState.isFinalState());

    assertTrue(attackState.isAttackState());
    assertFalse(attackState.isCounterAttackState());
    assertFalse(attackState.isRecoveryState());
    assertFalse(attackState.isStarsState());
    assertFalse(attackState.isWaitState());
    assertFalse(attackState.isCardState());
    assertFalse(attackState.isFightCardState());
    assertFalse(attackState.isRollState());
    assertFalse(attackState.isBattleState());
    assertFalse(attackState.isFightState());
    assertFalse(attackState.isCardActivationState());
    assertFalse(attackState.isFightCardActivationState());
    assertFalse(attackState.isPathState());
    assertFalse(attackState.isMoveState());
    assertFalse(attackState.isPanelEffectState());
    assertFalse(attackState.isEvadeState());
    assertFalse(attackState.isDefendState());
    assertFalse(attackState.isCounterDefendState());
    assertFalse(attackState.isCounterEvadeState());
    assertFalse(attackState.isEndBattleState());
    assertFalse(attackState.isStartState());
    assertFalse(attackState.isFinalState());

    assertTrue(counterAttackState.isCounterAttackState());
    assertFalse(counterAttackState.isAttackState());
    assertFalse(counterAttackState.isRecoveryState());
    assertFalse(counterAttackState.isStarsState());
    assertFalse(counterAttackState.isWaitState());
    assertFalse(counterAttackState.isCardState());
    assertFalse(counterAttackState.isFightCardState());
    assertFalse(counterAttackState.isRollState());
    assertFalse(counterAttackState.isBattleState());
    assertFalse(counterAttackState.isFightState());
    assertFalse(counterAttackState.isCardActivationState());
    assertFalse(counterAttackState.isFightCardActivationState());
    assertFalse(counterAttackState.isPathState());
    assertFalse(counterAttackState.isMoveState());
    assertFalse(counterAttackState.isPanelEffectState());
    assertFalse(counterAttackState.isEvadeState());
    assertFalse(counterAttackState.isDefendState());
    assertFalse(counterAttackState.isCounterDefendState());
    assertFalse(counterAttackState.isCounterEvadeState());
    assertFalse(counterAttackState.isEndBattleState());
    assertFalse(counterAttackState.isStartState());
    assertFalse(counterAttackState.isFinalState());

    assertTrue(endBattleState.isEndBattleState());
    assertFalse(endBattleState.isAttackState());
    assertFalse(endBattleState.isRecoveryState());
    assertFalse(endBattleState.isStarsState());
    assertFalse(endBattleState.isWaitState());
    assertFalse(endBattleState.isCardState());
    assertFalse(endBattleState.isFightCardState());
    assertFalse(endBattleState.isRollState());
    assertFalse(endBattleState.isBattleState());
    assertFalse(endBattleState.isFightState());
    assertFalse(endBattleState.isCardActivationState());
    assertFalse(endBattleState.isFightCardActivationState());
    assertFalse(endBattleState.isPathState());
    assertFalse(endBattleState.isMoveState());
    assertFalse(endBattleState.isPanelEffectState());
    assertFalse(endBattleState.isEvadeState());
    assertFalse(endBattleState.isDefendState());
    assertFalse(endBattleState.isCounterDefendState());
    assertFalse(endBattleState.isCounterEvadeState());
    assertFalse(endBattleState.isCounterAttackState());
    assertFalse(endBattleState.isStartState());
    assertFalse(endBattleState.isFinalState());

    assertTrue(finalState.isFinalState());
    assertFalse(finalState.isRecoveryState());
    assertFalse(finalState.isStarsState());
    assertFalse(finalState.isWaitState());
    assertFalse(finalState.isCardState());
    assertFalse(finalState.isFightCardState());
    assertFalse(finalState.isRollState());
    assertFalse(finalState.isBattleState());
    assertFalse(finalState.isFightState());
    assertFalse(finalState.isCardActivationState());
    assertFalse(finalState.isFightCardActivationState());
    assertFalse(finalState.isPathState());
    assertFalse(finalState.isMoveState());
    assertFalse(finalState.isPanelEffectState());
    assertFalse(finalState.isAttackState());
    assertFalse(finalState.isDefendState());
    assertFalse(finalState.isEvadeState());
    assertFalse(finalState.isCounterAttackState());
    assertFalse(finalState.isCounterEvadeState());
    assertFalse(finalState.isCounterDefendState());
    assertFalse(finalState.isEndBattleState());
    assertFalse(finalState.isStartState());

    assertFalse(state.isStartState());
    assertFalse(state.isRecoveryState());
    assertFalse(state.isStarsState());
    assertFalse(state.isWaitState());
    assertFalse(state.isCardState());
    assertFalse(state.isFightCardState());
    assertFalse(state.isRollState());
    assertFalse(state.isBattleState());
    assertFalse(state.isFightState());
    assertFalse(state.isCardActivationState());
    assertFalse(state.isFightCardActivationState());
    assertFalse(state.isPathState());
    assertFalse(state.isMoveState());
    assertFalse(state.isPanelEffectState());
    assertFalse(state.isAttackState());
    assertFalse(state.isDefendState());
    assertFalse(state.isEvadeState());
    assertFalse(state.isCounterAttackState());
    assertFalse(state.isCounterDefendState());
    assertFalse(state.isCounterEvadeState());
    assertFalse(state.isEndBattleState());
    assertFalse(state.isFinalState());
  }


  @Test
  public void StartStateTest() {
    Controller context = new Controller();
    context.choosePlayer("1");
    context.tryStart();

    assertTrue(context.isStarsState());
  }

  @Test
  public void RecoveryStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    yuki.setCurrentHp(0);

    context.tryStart();
    assertTrue(context.isRecoveryState());
    assertEquals(6, context.getRecoveryNumber());

    //seed
    context.setSeed(5);
    context.tryToRecover();
    assertEquals(6, context.getNumberOfMovements());
    assertTrue(context.isStarsState());
    assertEquals(5, yuki.getCurrentHp());

    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    yuki2.setCurrentHp(0);

    context2.tryStart();
    assertTrue(context2.isRecoveryState());

    //seed
    context2.setSeed(1);
    context2.tryToRecover();
    assertTrue(context2.isFinalState());
    assertEquals(0, yuki2.getCurrentHp());
  }

  @Test
  public void StarsStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    yuki.setCurrentHp(5);
    context.tryStart();

    yuki.reduceStarsBy(17);
    context.tryStars();
    assertTrue(context.isWaitState());
    assertEquals(1, yuki.getStars());
  }

  @Test
  public void WaitStateTest() {
    Controller context1 = new Controller();
    Player yuki = context1.choosePlayer("1");
    yuki.setCurrentHp(5);
    context1.tryStart();
    context1.tryStars();
    context1.setIsPlayingCard(false);

    context1.tryWait();
    assertTrue(context1.isRollState());

    Controller context2 = new Controller();
    context2.choosePlayer("1");
    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(true);

    context2.tryWait();
    assertTrue(context2.isCardState());
  }

  @Test
  public void CardStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    yuki.setCurrentHp(5);
    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(true);
    context.tryWait();

    context.setIsCardPlayable(true);
    context.tryCard();
    assertTrue(context.isCardActivationState());

    Controller context2 = new Controller();
    context2.choosePlayer("1");
    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(true);
    context2.tryWait();

    context2.setIsCardPlayable(false);
    context2.tryCard();
    assertTrue(context2.isRollState());
  }

  @Test
  public void RollStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    HomePanel homePanel = context.createHomePanel(yuki, 1);
    NeutralPanel neutralPanel = context.createNeutralPanel(2);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();

    //seed
    context.setSeed(11);
    context.tryRoll();
    assertTrue(context.isBattleState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    HomePanel homePanel2 = context2.createHomePanel(yuki, 3);
    NeutralPanel neutralPanel3 = context2.createNeutralPanel(4);
    NeutralPanel neutralPanel4 = context2.createNeutralPanel(5);
    homePanel2.addNextPanel(neutralPanel3);
    homePanel2.addNextPanel(neutralPanel4);
    context2.placePlayer(yuki2, homePanel2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();

    //seed
    context2.setSeed(1);
    context2.tryRoll();
    assertTrue(context2.isPathState());


    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    HomePanel homePanel3 = context3.createHomePanel(yuki3, 6);
    NeutralPanel neutralPanel9 = context3.createNeutralPanel(7);
    homePanel3.addNextPanel(neutralPanel9);
    context3.placePlayer(yuki3, homePanel3);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();

    //seed
    context3.setSeed(11);
    context3.tryRoll();
    assertTrue(context3.isPanelEffectState());
  }

  @Test
  public void CardActivationStateTest() {
    Controller context = new Controller();
    context.choosePlayer("1");
    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(true);
    context.tryWait();
    context.setIsCardPlayable(true);
    context.tryCard();
    context.tryCardActivation();
    assertTrue(context.isPanelEffectState());
  }

  @Test
  public void FightStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    HomePanel homePanel = context.createHomePanel(yuki, 8);
    NeutralPanel neutralPanel = context.createNeutralPanel(9);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    assertTrue(context.getListOfFight().contains(suguri));
    context.tryBattle();
    assertTrue(context.isFightState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri2 = context2.choosePlayer("2");
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 10);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(11);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    suguri2.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(suguri2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(false);
    context2.tryBattle();
    assertTrue(context2.isMoveState());
  }

  @Test
  public void BattleStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    HomePanel homePanel = context.createHomePanel(yuki, 12);
    NeutralPanel neutralPanel = context.createNeutralPanel(13);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();

    //seed
    context.setSeed(11);
    context.tryRoll();
    assertTrue(context.isBattleState());
  }

  @Test
  public void FightCardStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    HomePanel homePanel = context.createHomePanel(yuki, 14);
    NeutralPanel neutralPanel = context.createNeutralPanel(15);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(suguri);
    context.tryFight();
    assertTrue(context.isFightCardState());
  }

  @Test
  public void FightCardActivationStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    HomePanel homePanel = context.createHomePanel(yuki, 16);
    NeutralPanel neutralPanel = context.createNeutralPanel(17);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(suguri);
    context.tryFight();
    context.setIsPlayingFightCard(true);
    context.tryFightCard();
    assertTrue(context.isFightCardActivationState());
    context.tryFightCardActivation();
    assertTrue(context.isAttackState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri2 = context2.choosePlayer("2");
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 18);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(19);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    suguri2.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(suguri2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(suguri2);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    assertTrue(context2.isAttackState());
  }

  @Test
  public void PathStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    HomePanel homePanel = context.createHomePanel(yuki,20);
    NeutralPanel neutralPanel2 = context.createNeutralPanel(21);
    NeutralPanel neutralPanel3 = context.createNeutralPanel(22);
    homePanel.addNextPanel(neutralPanel2);
    homePanel.addNextPanel(neutralPanel3);
    context.placePlayer(yuki, homePanel);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();

    //seed
    context.setSeed(1);
    context.tryRoll();
    context.setPath(1);
    context.tryPath();
    assertEquals(neutralPanel2, yuki.getPanel());
    assertTrue(context.isMoveState());
  }

  @Test
  public void MoveStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    HomePanel homePanel = context.createHomePanel(yuki, 23);
    NeutralPanel neutralPanel2 = context.createNeutralPanel(24);
    NeutralPanel neutralPanel3 = context.createNeutralPanel(25);
    homePanel.addNextPanel(neutralPanel2);
    homePanel.addNextPanel(neutralPanel3);
    context.placePlayer(yuki, homePanel);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();

    //seed
    context.setSeed(17);
    context.tryRoll();
    context.setPath(1);
    context.tryPath();
    context.tryMove();
    assertTrue(context.isPanelEffectState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri = context2.choosePlayer("2");
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 26);
    NeutralPanel neutralPanel4 = context2.createNeutralPanel(27);
    NeutralPanel neutralPanel5 = context2.createNeutralPanel(28);
    homePanel2.addNextPanel(neutralPanel4);
    homePanel2.addNextPanel(neutralPanel5);
    context2.placePlayer(yuki2, homePanel2);
    suguri.setPanel(neutralPanel4);
    neutralPanel4.addPlayer(suguri);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();

    //seed
    context2.setSeed(17);
    context2.tryRoll();
    context2.setPath(1);
    context2.tryPath();
    context2.tryMove();
    assertTrue(context2.isBattleState());


    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    HomePanel homePanel3 = context3.createHomePanel(yuki3,29);
    NeutralPanel neutralPanel7 = context3.createNeutralPanel(30);
    NeutralPanel neutralPanel8 = context3.createNeutralPanel(31);
    NeutralPanel neutralPanel9 = context3.createNeutralPanel(32);
    NeutralPanel neutralPanel10 = context3.createNeutralPanel(33);
    homePanel3.addNextPanel(neutralPanel7);
    homePanel3.addNextPanel(neutralPanel8);
    neutralPanel7.addNextPanel(neutralPanel9);
    neutralPanel7.addNextPanel(neutralPanel10);
    context3.placePlayer(yuki3, homePanel3);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();

    //seed
    context3.setSeed(2);
    context3.tryRoll();
    context3.setPath(1);
    context3.setPathChosen(true);
    context3.tryPath();
    context3.tryMove();
    assertTrue(context3.isPathState());

  }

  @Test
  public void PanelEffectStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    context.choosePlayer("2");
    NeutralPanel neutralPanel = context.createNeutralPanel(34);
    context.placePlayer(yuki, neutralPanel);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(true);
    context.tryWait();
    context.setIsCardPlayable(true);
    context.tryCard();
    context.tryCardActivation();

    context.tryPanelEffect();
    assertEquals(neutralPanel, yuki.getPanel());
    assertTrue(context.isFinalState());
  }

  @Test
  public void AttackStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    HomePanel homePanel = context.createHomePanel(yuki, 35);
    NeutralPanel neutralPanel = context.createNeutralPanel(36);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(suguri);
    context.tryFight();
    context.setIsPlayingFightCard(false);
    context.tryFightCard();
    context.setSeed(1);
    context.setIsDefending(true);
    context.tryAttack();
    assertEquals(6, context.getAttackPower());
    assertTrue(context.isDefendState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri2 = context2.choosePlayer("2");
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 37);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(38);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    suguri2.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(suguri2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(suguri2);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    context2.setSeed(1);
    context2.setIsEvading(true);
    context2.tryAttack();
    assertEquals(6, context2.getAttackPower());
    assertTrue(context2.isEvadeState());
  }

  @Test
  public void EvadeStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    suguri.setCurrentHp(2);
    HomePanel homePanel = context.createHomePanel(yuki, 39);
    NeutralPanel neutralPanel = context.createNeutralPanel(40);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(suguri);
    context.tryFight();
    context.setIsPlayingFightCard(false);
    context.tryFightCard();
    context.setSeed(1);
    context.setIsEvading(true);
    context.tryAttack();
    assertEquals(6, context.getAttackPower());
    context.setTargetSeed(2);
    context.tryEvade();
    assertEquals(7, context.getEvadePower());
    assertFalse(suguri.isKo());
    assertTrue(context.isCounterAttackState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri2 = context2.choosePlayer("2");
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 41);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(42);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    suguri2.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(suguri2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(suguri2);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    context2.setSeed(1);
    context2.setIsEvading(true);
    context2.tryAttack();
    assertEquals(6, context2.getAttackPower());
    context2.setTargetSeed(3);
    context2.tryEvade();
    assertEquals(5, context2.getEvadePower());
    assertTrue(suguri2.isKo());
    assertEquals(yuki2, context2.getBattleWinner());
    assertEquals(suguri2, context2.getBattleLoser());
    assertTrue(context2.isEndBattleState());


    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    Player tomomo = context3.choosePlayer("3");
    tomomo.setCurrentHp(4);
    HomePanel homePanel3 = context3.createHomePanel(yuki3, 43);
    NeutralPanel neutralPanel3 = context3.createNeutralPanel(44);
    homePanel3.addNextPanel(neutralPanel3);
    context3.placePlayer(yuki3, homePanel3);
    tomomo.setPanel(neutralPanel3);
    neutralPanel3.addPlayer(tomomo);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();
    context3.setSeed(17);
    context3.tryRoll();

    context3.setWantsToFight(true);
    context3.setListOfFight();
    context3.tryBattle();
    context3.setTarget(tomomo);
    context3.tryFight();
    context3.setIsPlayingFightCard(false);
    context3.tryFightCard();
    context3.setSeed(17);
    context3.setIsEvading(true);
    context3.tryAttack();
    assertEquals(3, context3.getAttackPower());
    context3.setTargetSeed(6);
    context3.tryEvade();
    assertEquals(2, context3.getEvadePower());
    assertFalse(tomomo.isKo());
    assertTrue(context3.isCounterAttackState());
  }

  @Test
  public void DefendStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player suguri = context.choosePlayer("2");
    suguri.setCurrentHp(4);
    HomePanel homePanel = context.createHomePanel(yuki, 45);
    NeutralPanel neutralPanel = context.createNeutralPanel(46);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    suguri.setPanel(neutralPanel);
    neutralPanel.addPlayer(suguri);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(suguri);
    context.tryFight();
    context.setIsPlayingFightCard(false);
    context.tryFightCard();
    context.setSeed(1);
    context.setIsDefending(true);
    context.tryAttack();
    assertEquals(6, context.getAttackPower());
    assertTrue(context.isDefendState());
    context.setTargetSeed(3);
    context.tryDefend();
    assertEquals(2, context.getDefensePower());
    assertTrue(suguri.isKo());
    assertEquals(yuki, context.getBattleWinner());
    assertEquals(suguri, context.getBattleLoser());
    assertTrue(context.isEndBattleState());



    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri2 = context2.choosePlayer("2");
    suguri2.setCurrentHp(4);
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 47);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(48);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    suguri2.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(suguri2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(suguri2);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    context2.setSeed(1);
    context2.setIsDefending(true);
    context2.tryAttack();
    assertEquals(6, context2.getAttackPower());
    assertTrue(context2.isDefendState());
    context2.setTargetSeed(2);
    context2.tryDefend();
    assertEquals(4, context2.getDefensePower());
    assertFalse(suguri2.isKo());
    assertTrue(context2.isCounterAttackState());
  }

  @Test
  public void CounterAttackStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player tomomo2 = context.choosePlayer("3");
    tomomo2.setCurrentHp(4);
    HomePanel homePanel = context.createHomePanel(yuki, 49);
    NeutralPanel neutralPanel = context.createNeutralPanel(50);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    tomomo2.setPanel(neutralPanel);
    neutralPanel.addPlayer(tomomo2);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(tomomo2);
    context.tryFight();
    context.setIsPlayingFightCard(false);
    context.tryFightCard();
    context.setSeed(17);
    context.setIsEvading(true);
    context.tryAttack();
    assertEquals(3, context.getAttackPower());
    context.setTargetSeed(6);
    context.tryEvade();
    assertEquals(2, context.getEvadePower());
    assertFalse(tomomo2.isKo());
    assertTrue(context.isCounterAttackState());
    context.setTargetSeed(5);
    context.setIsTurnDefending(true);
    context.tryCounterAttack();
    assertEquals(8, context.getCounterAttackPower());
    assertTrue(context.isCounterDefendState());


    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    Player tomomo = context3.choosePlayer("3");
    tomomo.setCurrentHp(4);
    HomePanel homePanel3 = context3.createHomePanel(yuki3, 51);
    NeutralPanel neutralPanel3 = context3.createNeutralPanel(52);
    homePanel3.addNextPanel(neutralPanel3);
    context3.placePlayer(yuki3, homePanel3);
    tomomo.setPanel(neutralPanel3);
    neutralPanel3.addPlayer(tomomo);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();
    context3.setSeed(17);
    context3.tryRoll();

    context3.setWantsToFight(true);
    context3.setListOfFight();
    context3.tryBattle();
    context3.setTarget(tomomo);
    context3.tryFight();
    context3.setIsPlayingFightCard(false);
    context3.tryFightCard();
    context3.setSeed(17);
    context3.setIsEvading(true);
    context3.tryAttack();
    assertEquals(3, context3.getAttackPower());
    context3.setTargetSeed(6);
    context3.tryEvade();
    assertEquals(2, context3.getEvadePower());
    assertFalse(tomomo.isKo());
    assertTrue(context3.isCounterAttackState());
    context3.setTargetSeed(1);
    context3.setIsTurnEvading(true);
    context3.tryCounterAttack();
    assertEquals(6, context3.getCounterAttackPower());
    assertTrue(context3.isCounterEvadeState());
  }

  @Test
  public void CounterEvadeStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player tomomo2 = context.choosePlayer("3");
    yuki.setCurrentHp(4);
    tomomo2.setCurrentHp(4);
    HomePanel homePanel = context.createHomePanel(yuki, 53);
    NeutralPanel neutralPanel = context.createNeutralPanel(54);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    tomomo2.setPanel(neutralPanel);
    neutralPanel.addPlayer(tomomo2);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(tomomo2);
    context.tryFight();
    context.setIsPlayingFightCard(false);
    context.tryFightCard();
    context.setSeed(17);
    context.setIsEvading(true);
    context.tryAttack();
    assertEquals(3, context.getAttackPower());
    context.setTargetSeed(6);
    context.tryEvade();
    assertEquals(2, context.getEvadePower());
    assertFalse(tomomo2.isKo());
    assertTrue(context.isCounterAttackState());
    context.setTargetSeed(11);
    context.setIsTurnEvading(true);
    context.tryCounterAttack();
    assertEquals(3, context.getCounterAttackPower());
    assertTrue(context.isCounterEvadeState());

    context.setSeed(3);
    context.tryCounterEvade();
    assertEquals(2, context.getCounterEvadePower());
    assertFalse(yuki.isKo());
    assertTrue(context.isAttackState());


    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player tomomo3 = context2.choosePlayer("3");
    yuki2.setCurrentHp(4);
    tomomo3.setCurrentHp(4);
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 55);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(56);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    tomomo3.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(tomomo3);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(tomomo3);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    context2.setSeed(17);
    context2.setIsEvading(true);
    context2.tryAttack();
    assertEquals(3, context2.getAttackPower());
    context2.setTargetSeed(6);
    context2.tryEvade();
    assertEquals(2, context2.getEvadePower());
    assertFalse(tomomo3.isKo());
    assertTrue(context2.isCounterAttackState());
    context2.setTargetSeed(11);
    context2.setIsTurnEvading(true);
    context2.tryCounterAttack();
    assertEquals(3, context2.getCounterAttackPower());
    assertTrue(context2.isCounterEvadeState());

    context2.setSeed(7);
    context2.tryCounterEvade();
    assertEquals(4, context2.getCounterEvadePower());
    assertFalse(yuki2.isKo());
    assertTrue(context2.isAttackState());




    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    Player tomomo = context3.choosePlayer("3");
    yuki3.setCurrentHp(4);
    tomomo.setCurrentHp(4);
    HomePanel homePanel3 = context3.createHomePanel(yuki3, 57);
    NeutralPanel neutralPanel3 = context3.createNeutralPanel(58);
    homePanel3.addNextPanel(neutralPanel3);
    context3.placePlayer(yuki3, homePanel3);
    tomomo.setPanel(neutralPanel3);
    neutralPanel3.addPlayer(tomomo);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();
    context3.setSeed(17);
    context3.tryRoll();

    context3.setWantsToFight(true);
    context3.setListOfFight();
    context3.tryBattle();
    context3.setTarget(tomomo);
    context3.tryFight();
    context3.setIsPlayingFightCard(false);
    context3.tryFightCard();
    context3.setSeed(17);
    context3.setIsEvading(true);
    context3.tryAttack();
    assertEquals(3, context3.getAttackPower());
    context3.setTargetSeed(6);
    context3.tryEvade();
    assertEquals(2, context3.getEvadePower());
    assertFalse(tomomo.isKo());
    assertTrue(context3.isCounterAttackState());
    context3.setTargetSeed(1);
    context3.setIsTurnEvading(true);
    context3.tryCounterAttack();
    assertEquals(6, context3.getCounterAttackPower());
    assertTrue(context3.isCounterEvadeState());

    context3.setSeed(1);
    context3.tryCounterEvade();
    assertEquals(3, context3.getCounterEvadePower());
    assertTrue(yuki3.isKo());
    assertEquals(tomomo, context3.getBattleWinner());
    assertEquals(yuki3, context3.getBattleLoser());
    assertTrue(context3.isEndBattleState());
  }

  @Test
  public void CounterDefendStateTest() {
    Controller context = new Controller();
    Player yuki = context.choosePlayer("1");
    Player tomomo2 = context.choosePlayer("3");
    tomomo2.setCurrentHp(4);
    HomePanel homePanel = context.createHomePanel(yuki, 59);
    NeutralPanel neutralPanel = context.createNeutralPanel(60);
    homePanel.addNextPanel(neutralPanel);
    context.placePlayer(yuki, homePanel);
    tomomo2.setPanel(neutralPanel);
    neutralPanel.addPlayer(tomomo2);

    context.tryStart();
    context.tryStars();
    context.setIsPlayingCard(false);
    context.tryWait();
    context.setSeed(17);
    context.tryRoll();

    context.setWantsToFight(true);
    context.setListOfFight();
    context.tryBattle();
    context.setTarget(tomomo2);
    context.tryFight();
    context.setIsPlayingFightCard(false);
    context.tryFightCard();
    context.setSeed(17);
    context.setIsEvading(true);
    context.tryAttack();
    assertEquals(3, context.getAttackPower());
    context.setTargetSeed(6);
    context.tryEvade();
    assertEquals(2, context.getEvadePower());
    assertFalse(tomomo2.isKo());
    assertTrue(context.isCounterAttackState());
    context.setTargetSeed(5);
    context.setIsTurnDefending(true);
    context.tryCounterAttack();
    assertEquals(8, context.getCounterAttackPower());
    assertTrue(context.isCounterDefendState());

    context.setSeed(2);
    context.tryCounterDefend();
    assertEquals(4, context.getCounterDefensePower());
    assertFalse(yuki.isKo());
    assertTrue(context.isAttackState());

    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player tomomo = context2.choosePlayer("3");
    tomomo.setCurrentHp(4);
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 61);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(62);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    tomomo.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(tomomo);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(tomomo);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    context2.setSeed(17);
    context2.setIsEvading(true);
    context2.tryAttack();
    assertEquals(3, context2.getAttackPower());
    context2.setTargetSeed(6);
    context2.tryEvade();
    assertEquals(2, context2.getEvadePower());
    assertFalse(tomomo.isKo());
    assertTrue(context2.isCounterAttackState());
    context2.setTargetSeed(5);
    context2.setIsTurnDefending(true);
    context2.tryCounterAttack();
    assertEquals(8, context2.getCounterAttackPower());
    assertTrue(context2.isCounterDefendState());

    context2.setSeed(2);
    context2.tryCounterDefend();
    assertEquals(4, context2.getCounterDefensePower());
    assertTrue(yuki2.isKo());
    assertEquals(yuki2, context2.getBattleLoser());
    assertEquals(tomomo, context2.getBattleWinner());
    assertTrue(context2.isEndBattleState());
  }

  @Test
  public void EndBattleStateTest() {
    Controller context2 = new Controller();
    Player yuki2 = context2.choosePlayer("1");
    Player suguri2 = context2.choosePlayer("2");
    yuki2.setCurrentHp(5);
    yuki2.setWins(0);
    yuki2.reduceStarsBy(100);
    suguri2.setCurrentHp(4);
    suguri2.increaseStarsBy(4);
    assertEquals(4, suguri2.getStars());
    HomePanel homePanel2 = context2.createHomePanel(yuki2, 63);
    NeutralPanel neutralPanel2 = context2.createNeutralPanel(64);
    homePanel2.addNextPanel(neutralPanel2);
    context2.placePlayer(yuki2, homePanel2);
    suguri2.setPanel(neutralPanel2);
    neutralPanel2.addPlayer(suguri2);

    context2.tryStart();
    context2.tryStars();
    context2.setIsPlayingCard(false);
    context2.tryWait();
    context2.setSeed(17);
    context2.tryRoll();

    context2.setWantsToFight(true);
    context2.setListOfFight();
    context2.tryBattle();
    context2.setTarget(suguri2);
    context2.tryFight();
    context2.setIsPlayingFightCard(false);
    context2.tryFightCard();
    context2.setSeed(2);
    context2.setIsEvading(true);
    context2.tryAttack();
    assertEquals(7, context2.getAttackPower());
    context2.setTargetSeed(3);
    context2.tryEvade();
    assertEquals(5, context2.getEvadePower());
    assertTrue(suguri2.isKo());
    assertEquals(yuki2, context2.getBattleWinner());
    assertEquals(suguri2, context2.getBattleLoser());
    assertTrue(context2.isEndBattleState());
    context2.tryEndBattle();
    assertEquals(2, yuki2.getWins());
    assertEquals(3, yuki2.getStars());
  }

  @Test
  public void FinalStateTest() {
    Controller context3 = new Controller();
    Player yuki3 = context3.choosePlayer("1");
    Player suguri = context3.choosePlayer("2");
    HomePanel homePanel3 = context3.createHomePanel(yuki3,65);
    NeutralPanel neutralPanel9 = context3.createNeutralPanel(66);
    homePanel3.addNextPanel(neutralPanel9);
    context3.placePlayer(yuki3, homePanel3);

    context3.tryStart();
    context3.tryStars();
    context3.setIsPlayingCard(false);
    context3.tryWait();

    //seed
    context3.setSeed(11);
    context3.tryRoll();
    context3.tryPanelEffect();

    context3.tryEnd();
    assertTrue(context3.isStartState());
    assertEquals(suguri, context3.getTurn());
    assertEquals(0, context3.getNumberOfMovements());
  }
}
