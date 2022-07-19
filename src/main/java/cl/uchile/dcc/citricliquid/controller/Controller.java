package cl.uchile.dcc.citricliquid.controller;

import cl.uchile.dcc.citricliquid.controller.handler.WinHandler;
import cl.uchile.dcc.citricliquid.controller.handler.interfaces.IHandler;
import cl.uchile.dcc.citricliquid.controller.state.StartState;
import cl.uchile.dcc.citricliquid.controller.state.State;
import cl.uchile.dcc.citricliquid.exceptions.InvalidStateOperationException;
import cl.uchile.dcc.citricliquid.model.board.cards.Card;
import cl.uchile.dcc.citricliquid.model.board.enemies.BossUnit;
import cl.uchile.dcc.citricliquid.model.board.enemies.EnemyGenerator;
import cl.uchile.dcc.citricliquid.model.board.enemies.WildUnit;
import cl.uchile.dcc.citricliquid.model.board.objective.Objective;
import cl.uchile.dcc.citricliquid.model.board.panels.*;
import cl.uchile.dcc.citricliquid.model.board.panels.abstracts.Panel;
import cl.uchile.dcc.citricliquid.model.board.players.Player;
import cl.uchile.dcc.citricliquid.model.board.players.singleton.Aru;
import cl.uchile.dcc.citricliquid.model.board.players.singleton.Suguri;
import cl.uchile.dcc.citricliquid.model.board.players.singleton.Tomomo;
import cl.uchile.dcc.citricliquid.model.board.players.singleton.Yuki;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * The controller of the game. Starts and regulates the flow of the game.
 */
public class Controller {
  /**
   * Creates a random object.
   */
  private final Random random = new Random();
  /**
   * The player in turn.
   */
  private Player turn;
  /**
   * The number of movements left of the player in turn.
   */
  private int numberOfMovements = 0;
  /**
   * The actual chapter of the game.
   */
  private int chapter;
  /**
   * The list of players of the game.
   */
  private final List<Player> listOfPlayers = new ArrayList<>();
  /**
   * It's the state of the game.
   */
  private State state = new StartState(this);
  /**
   * The generator of random enemies.
   */
  private EnemyGenerator eg = new EnemyGenerator();
  /**
   * The panel where the player in turn is.
   */
  private Panel actualPanel = null;
  /**
   * Indicates if a card is being played by the actual player.
   */
  private boolean isPlayingCard = false;
  /**
   * Indicates if the card is playable.
   */
  private boolean isCardPlayable = false;
  /**
   * Indicates if the player found another player.
   */
  private boolean isPlayersEncounter = false;
  /**
   * Indicates if the player found his/her home panel.
   */
  private boolean isHomePanelEncounter = false;
  /**
   * Indicates if there's a path split.
   */
  private boolean isPathSplitEncounter = false;
  /**
   * Indicates if a path is chosen.
   */
  private boolean isPathChosen = false;
  /**
   * Indicates if the player wants to fight.
   */
  private boolean wantsToFight = false;
  /**
   * The attack power of the player in turn.
   */
  private int attackPower = 0;
  /**
   * The winner of the game.
   */
  private Player winner = null;
  /**
   * Indicates if a card is being played by the players on the fight.
   */
  private Boolean isPlayingFightCard = false;
  /**
   * The panels on the table board.
   */
  private final Set<Panel> boardTable = new HashSet<>();
  /**
   * The handler of when a player wins.
   */
  private final IHandler winHandler = new WinHandler(this);
  /**
   * The list of cards of the game.
   */
  private final List<Card> cards = new ArrayList<>();
  /**
   * The target that the actual player is attacking.
   */
  private Player target = null;
  /**
   * Indicates if the target is evading.
   */
  private boolean isEvading = false;
  /**
   * Indicates if the target is defending.
   */
  private boolean isDefending = false;
  /**
   * The evasion power of the target.
   */
  private int evadePower = 0;
  /**
   * The defense power of the target.
   */
  private int defensePower = 0;
  /**
   * The winner of the actual battle.
   */
  private Player battleWinner = null;
  /**
   * The loser of the actual battle.
   */
  private Player battleLoser = null;
  /**
   * The attack power of the target.
   */
  private int counterAttackPower = 0;
  /**
   * Indicates if the player in turn is evading.
   */
  private boolean isTurnEvading = false;
  /**
   * Indicates if the player in turn is defending.
   */
  private boolean isTurnDefending = false;
  /**
   * The player in turns evasion power.
   */
  private int counterEvadePower = 0;
  /**
   * The player in turns evading power.
   */
  private int counterDefensePower = 0;
  /**
   * The list of players we can fight.
   */
  private List<Player> listOfFight = new ArrayList<>();

  /**
   * Creates a controller with a given input.
   */
  public Controller() {
    this.chapter = 1;
  }

  /**
   * Creates a controller with a determined chapter.
   *
   * @param ch the chapter of the game
   */
  public Controller(final int ch) {
    this.chapter = ch;
  }

  /**
   * Changes the state of the game.
   *
   * @param st A state of the game
   */
  public void setState(final State st) {
    this.state = st;
  }

  /**
   * Runs the action of the actual state.
   */
  public void runContextAction() {
    state.toDo();
  }

  /**
   * Tries to start the turn.
   */
  public void tryStart() {
    runContextAction();
  }

  /**
   * Tries to run the action for Stars State.
   */
  public void tryStars() {
    runContextAction();
  }

  /**
   * Tries to run the action for Recover State.
   */
  public void tryToRecover() {
    runContextAction();
  }

  /**
   * Tries to run the action for Wait State.
   */
  public void tryWait() {
    runContextAction();
  }

  /**
   * Tries to run the action for Card State.
   */
  public void tryCard() {
    runContextAction();
  }

  /**
   * Tries to run the action for Roll State.
   */
  public void tryRoll() {
    runContextAction();
  }

  /**
   * Tries to run the action for Move State.
   */
  public void tryMove() {
    runContextAction();
  }

  /**
   * Tries to start a fight with a player on the same panel.
   */
  public void tryBattle() {
    runContextAction();
  }

  /**
   * Tries to fight a player on the same panel.
   */
  public void tryFight() {
    runContextAction();
  }

  /**
   * Tries to ask for a fight card to the players on the same panel.
   */
  public void tryFightCard() {
    runContextAction();
  }

  /**
   * Tries to activate the fight cards of the players fighting.
   */
  public void tryFightCardActivation() {
    runContextAction();
  }

  /**
   * Tries to attack a target player.
   */
  public void tryAttack() {
    runContextAction();
  }

  /**
   * Tries to defend from the attack of the player in turn player.
   */
  public void tryDefend() {
    runContextAction();
  }

  /**
   * Tries to evade from the attack of the player in turn player.
   */
  public void tryEvade() {
    runContextAction();
  }

  /**
   * Tries to counter the attack of the player in turn.
   */
  public void tryCounterAttack() {
    runContextAction();
  }

  /**
   * Tries to counter the attack of the target evading.
   */
  public void tryCounterEvade() {
    runContextAction();
  }

  /**
   * Tries to counter the attack of the target defending.
   */
  public void tryCounterDefend() {
    runContextAction();
  }

  /**
   * Tries to end the battle.
   */
  public void tryEndBattle() {
    runContextAction();
  }

  /**
   * Tries to activate the effect of the panel.
   */
  public void tryPanelEffect() {
    runContextAction();
  }

  /**
   * Tries to choose a path.
   */
  public void tryPath() {
    runContextAction();
  }

  /**
   * Tries to activate a card.
   */
  public void tryCardActivation() {
    runContextAction();
  }

  /**
   * Tries to end the turn.
   */
  public void tryEnd() {
    runContextAction();
  }

  /**
   * Changes the state to Start State.
   */
  public void start() {
    try {
      state.toStartState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Recovery State.
   */
  public void recovery() {
    try {
      state.toRecoveryState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Stars State.
   */
  public void stars() {
    try {
      state.toStarsState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Wait State.
   */
  public void waitPlayer() {
    try {
      state.toWaitState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Card State.
   */
  public void card() {
    try {
      state.toCardState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Roll State.
   */
  public void roll() {
    try {
      state.toRollState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Battle State.
   */
  public void battle() {
    try {
      state.toBattleState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Fight State.
   */
  public void fight() {
    try {
      state.toFightState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Fight Card State.
   */
  public void fightCard() {
    try {
      state.toFightCardState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Fight Card Activation State.
   */
  public void fightCardActivation() {
    try {
      state.toFightCardActivationState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Attack State.
   */
  public void attack() {
    try {
      state.toAttackState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Evade State.
   */
  public void evade() {
    try {
      state.toEvadeState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Defend State.
   */
  public void defend() {
    try {
      state.toDefendState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Counter Attack State.
   */
  public void counter() {
    try {
      state.toCounterAttackState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to End Battle State.
   */
  public void endBattle() {
    try {
      state.toEndBattleState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Counter Evade State.
   */
  public void counterEvade() {
    try {
      state.toCounterEvadeState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Counter Defend State.
   */
  public void counterDefend() {
    try {
      state.toCounterDefendState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Path State.
   */
  public void path() {
    try {
      state.toPathState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Move State.
   */
  public void move() {
    try {
      state.toMoveState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Card Activation State.
   */
  public void cardActivation() {
    try {
      state.toCardActivationState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Panel Effect State.
   */
  public void panelEffect() {
    try {
      state.toPanelEffectState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Changes the state to Final State.
   */
  public void end() {
    try {
      state.toFinalState();
    } catch (InvalidStateOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Implements the initial stars given when
   * it's the start of a turn (if not K.O),
   * the stars given are floor(chapter/5) + 1.
   */
  public void setInitialStars() {
    turn.increaseStarsBy(((int) Math.floor(chapter / 5)) + 1);
  }

  /**
   * Gets the actual chapter of the game.
   *
   * @return the chapter of the game
   */
  public int getChapter() {
    return chapter;
  }

  /**
   * Changes the chapter of the game.
   *
   * @param ch It's the round of the game we are at
   */
  public void setChapter(final int ch) {
    this.chapter = ch;
  }


  /**
   * Gets the player in turn.
   *
   * @return the player in turn
   */
  public Player getTurn() {
    return turn;
  }

  /**
   * Changes the player with the actual turn.
   *
   * @param actualTurn The player with the actual turn
   */
  private void setTurn(final Player actualTurn) {
    this.turn = actualTurn;
  }

  /**
   * Chooses a character according to the number.
   * For testing purposes.
   *
   * @param number It's the number corresponding
   *               to the character you want to play
   * @return the player chosen
   */
  public Player choosePlayer(final String number) {
    System.out.println("Choose your player:");
    System.out.println("Character 1: Yuki");
    System.out.println("Character 2: Suguri");
    System.out.println("Character 3: Tomomo");
    System.out.println("Character 4: Aru");
    Yuki yuki = Yuki.oneYuki();
    Aru aru = Aru.oneAru();
    Tomomo tomomo = Tomomo.oneTomomo();
    Suguri suguri = Suguri.oneSuguri();

    if (parseInt(number) == 1) {
      yuki.addListener(winHandler);
      if (listOfPlayers.size() == 0) {
        setTurn(yuki);
      }
      listOfPlayers.add(yuki);
      return yuki;
    }
    if (parseInt(number) == 2) {
      suguri.addListener(winHandler);
      if (listOfPlayers.size() == 0) {
        setTurn(suguri);
      }
      listOfPlayers.add(suguri);
      return suguri;
    }
    if (parseInt(number) == 3) {
      tomomo.addListener(winHandler);
      if (listOfPlayers.size() == 0) {
        setTurn(tomomo);
      }
      listOfPlayers.add(tomomo);
      return tomomo;
    }
    if (parseInt(number) == 4) {
      aru.addListener(winHandler);
      if (listOfPlayers.size() == 0) {
        setTurn(aru);
      }
      listOfPlayers.add(aru);
      return aru;
    } else {
      return null;
    }
  }

  /**
   * Gets the state of the player (Dead or Alive).
   *
   * @param player A character of the game
   * @return True if the player is dead
   */
  public boolean isKo(final Player player) {
    return player.isKo();
  }

  /**
   * Changes the hp of the actual player to the recovery number.
   */
  public void recovered() {
    getTurn().setCurrentHp(Math.min(getTurn().getMaxHp(),
        getNumberOfMovements()));
  }

  /**
   * Gets if the player is playing a card.
   *
   * @return true if a card is played
   */
  public boolean getIsPlayingCard() {
    return this.isPlayingCard;
  }

  /**
   * Gets the hashmap with the responses of the players fighting.
   *
   * @return the hashmap with the players responses
   */
  public Boolean getIsPlayingFightCard() {
    return isPlayingFightCard;
  }

  /**
   * Changes the value of the decision of a player playing a card.
   *
   * @param ipc Indicates if the player wants to play a card
   */
  public void setIsPlayingCard(final boolean ipc) {
    isPlayingCard = ipc;
  }

  /**
   * Changes the value of the indicator of the player playing a card.
   *
   * @param ipfc A boolean that indicates if a fight card is being played
   */
  public void setIsPlayingFightCard(final boolean ipfc) {
    this.isPlayingFightCard = ipfc;
  }

  /**
   * Gets the necessary number to recover
   * according to the number of the chapter.
   *
   * @return the number to recover
   */
  public int getRecoveryNumber() {
    return 7 - getChapter();
  }

  /**
   * Gets if we are on a path split.
   *
   * @param panel A panel of the board
   * @return true if there's a split on the way
   */
  public boolean isPathSplitEncounter(final Panel panel) {
    return panel.getNextPanels().size() >= 2;
  }

  /**
   * Gets if the player's on the same panels as another a player.
   *
   * @param panel A panel of the board
   * @return true if the players are on the same panel
   */
  public boolean isPlayersEncounter(final Panel panel) {
    return panel.getListOfPlayers().size() >= 2
        && panel.getListOfPlayers().contains(getTurn());
  }

  /**
   * Gets if the player is on his/her home panel.
   *
   * @param panel A panel of the board
   * @return true if the player is at his/her home panel
   */
  public boolean isHomePanelEncounter(final Panel panel) {
    if (panel.toString().equals("Home")) {
      return Objects.equals(((HomePanel) panel).getOwner().getName(),
          getTurn().getName());
    } else {
      return false;
    }
  }

  /**
   * Gets the number of movements left of the player.
   *
   * @return the number of movements
   */
  public int getNumberOfMovements() {
    return numberOfMovements;
  }

  /**
   * Changes the number of movements of the player.
   *
   * @param number The number of movements left of the player in turn
   */
  public void setNumberOfMovements(final int number) {
    this.numberOfMovements = number;
  }

  /**
   * Changes the actual panel of the player in turn.
   *
   * @param panel The panel where the player in turn is
   */
  private void setActualPanel(final Panel panel) {
    this.actualPanel = panel;
  }

  /**
   * Gets the actual panel of the player.
   *
   * @return the panel where the player is
   */
  public Panel getActualPanel() {
    return actualPanel;
  }

  /**
   * Creates a bonus panel with a chosen id.
   *
   * @param id The identification of the panel
   * @return A bonus panel
   */
  public BonusPanel createBonusPanel(final int id) {
    BonusPanel bonusPanel = new BonusPanel(id);
    addToBoardTable(bonusPanel);
    return bonusPanel;
  }

  /**
   * Creates a boss panel with a chosen id.
   *
   * @param id The identification of the panel
   * @return A boss panel
   */
  public BossPanel createBossPanel(final int id) {
    BossPanel bossPanel = new BossPanel(id);
    addToBoardTable(bossPanel);
    return bossPanel;
  }

  /**
   * Creates a draw panel with a chosen id.
   *
   * @param id The identification of the panel
   * @return A draw panel
   */
  public DrawPanel createDrawPanel(final int id) {
    DrawPanel drawPanel = new DrawPanel(id);
    addToBoardTable(drawPanel);
    return drawPanel;
  }

  /**
   * Creates a drop panel with a chosen id.
   *
   * @param id The identification of the panel
   * @return A drop panel
   */
  public DropPanel createDropPanel(final int id) {
    DropPanel dropPanel = new DropPanel(id);
    addToBoardTable(dropPanel);
    return dropPanel;
  }

  /**
   * Creates an encounter panel with a chosen id.
   *
   * @param id The identification of the panel
   * @return An encounter panel
   */
  public EncounterPanel createEncounterPanel(final int id) {
    EncounterPanel encounterPanel = new EncounterPanel(id);
    addToBoardTable(encounterPanel);
    return encounterPanel;
  }

  /**
   * Creates a home panel with a chosen id and player.
   *
   * @param id    The identification of the panel
   * @param owner The owner of the home panel
   * @return A home panel
   */
  public HomePanel createHomePanel(final Player owner, final int id) {
    HomePanel homePanel = new HomePanel(owner, id);
    homePanel.addPlayer(owner);
    addToBoardTable(homePanel);
    return homePanel;
  }

  /**
   * Creates a neutral panel with a chosen id.
   *
   * @param id The identification of the panel
   * @return A neutral panel
   */
  public NeutralPanel createNeutralPanel(final int id) {
    NeutralPanel neutralPanel = new NeutralPanel(id);
    addToBoardTable(neutralPanel);
    return neutralPanel;
  }

  /**
   * Adds a panel to the board.
   *
   * @param panel A piece of the board with a predefined effect
   */
  private void addToBoardTable(final Panel panel) {
    boardTable.add(panel);
  }

  /**
   * Gets a copy of the board panels.
   *
   * @return all the panels of the board
   */
  public Set<Panel> getBoardTable() {
    return Set.copyOf(boardTable);
  }

  /**
   * Sets the position of the player on one panel
   * if it doesn't have a panel yet.
   * Changes the position if there's a panel set.
   *
   * @param player The main character of the game
   * @param panel  A piece of the board with a predefined effect
   */
  public void placePlayer(final Player player, final Panel panel) {
    if (getActualPanel() == null) {
      player.setPanel(panel);
      setActualPanel(panel);
      panel.addPlayer(player);
    } else {
      player.setPanel(panel);
      getActualPanel().removePlayer(player);
      setActualPanel(panel);
      panel.addPlayer(player);
    }
  }

  /**
   * Creates a seed induced Boss Unit,
   * for testing purposes.
   *
   * @param seed A number that makes the
   *             random object constant
   * @return the pseudo-random boss unit
   */
  public BossUnit createBossUnit(final long seed) {
    eg.pickEnemyS(seed);
    return eg.bossGen(seed);
  }

  /**
   * Creates a random Boss Unit.
   *
   * @return a random boss unit
   */
  public BossUnit createRandomBossUnit() {
    int number = random.nextInt(3) + 1;
    return eg.bossGen(number);
  }

  /**
   * Creates a seed induced Wild Unit,
   * for testing purposes.
   *
   * @param seed A number that makes the
   *             random object constant
   * @return the pseudo-random wild unit
   */
  public WildUnit createWildUnit(final long seed) {
    eg.pickEnemyS(seed);
    return eg.wildGen(seed);
  }

  /**
   * Creates a random Wild Unit.
   *
   * @return a random wild unit
   */
  public WildUnit createRandomWildUnit() {
    int number = random.nextInt(3) + 1;
    return eg.wildGen(number);
  }

  /**
   * Gets the winner of the game.
   *
   * @return the player that won the game
   */
  public Player getWinner() {
    return this.winner;
  }

  /**
   * Changes the winner of the game.
   *
   * @param winnerPlayer The player that won the game
   */
  public void setWinner(final Player winnerPlayer) {
    this.winner = winnerPlayer;
  }

  /**
   * Sets a forthcoming panel to the actual panel.
   *
   * @param panel     The panel to whom is set the next panel
   * @param nextPanel The next panel we are assigning
   */
  public void setNextPanel(final Panel panel, final Panel nextPanel) {
    panel.addNextPanel(nextPanel);
  }

  /**
   * Changes the actual objective of the player.
   * Only changeable
   *
   * @param obj The objective of the game
   */
  public void changeObj(final String obj) {
    if (getTurn().getNormaLevel() > 1) {
      if (Objects.equals(obj, "STARS")) {
        getTurn().setObj(new Objective(0));
      }
      if (Objects.equals(obj, "WINS")) {
        getTurn().setObj(new Objective(1));
      } else {
        System.out.println("Not a valid objective. Please try again.");
      }
    } else {
      System.out.println("You can't change objective yet."
          + " Level up to change objective.");
    }
  }

  /**
   * Gets the actual objective of the player in turn.
   *
   * @return The actual objective of the players game
   */
  public String getObj() {
    return getTurn().getObj().toString();
  }

  /**
   * Gets the list of players of the game.
   *
   * @return the list of players
   */
  public List<Player> getListOfPlayers() {
    return listOfPlayers;
  }

  /**
   * Generates a board for the game and
   * sets the home panels of the players.
   */
  public void generateBoard() {
    Player yuki = choosePlayer("1");
    Player suguri = choosePlayer("2");
    Player tomomo = choosePlayer("3");
    Player aru = choosePlayer("4");

    ArrayList<Panel> panels = new ArrayList<>();

    panels.add(createHomePanel(yuki, 1));
    panels.add(createHomePanel(suguri, 2));
    panels.add(createHomePanel(tomomo, 3));
    panels.add(createHomePanel(aru, 4));

    panels.add(createBonusPanel(5));
    panels.add(createBossPanel(6));
    panels.add(createDropPanel(7));
    panels.add(createEncounterPanel(8));
    panels.add(createNeutralPanel(9));
    panels.add(createDrawPanel(10));

    panels.add(createBonusPanel(11));
    panels.add(createBossPanel(12));
    panels.add(createDropPanel(13));
    panels.add(createEncounterPanel(14));
    panels.add(createNeutralPanel(15));
    panels.add(createDrawPanel(16));

    panels.add(createBonusPanel(17));
    panels.add(createBossPanel(18));
    panels.add(createDropPanel(19));
    panels.add(createEncounterPanel(20));
    panels.add(createNeutralPanel(21));
    panels.add(createDrawPanel(22));

    panels.add(createBonusPanel(23));
    panels.add(createBossPanel(24));
    panels.add(createDropPanel(25));
    panels.add(createEncounterPanel(26));
    panels.add(createNeutralPanel(27));
    panels.add(createDrawPanel(28));

    panels.add(createBonusPanel(29));
    panels.add(createBossPanel(30));
    panels.add(createDropPanel(31));
    panels.add(createNeutralPanel(32));

    setNextPanel(panels.get(10), panels.get(9));
    setNextPanel(panels.get(9), panels.get(8));
    setNextPanel(panels.get(8), panels.get(7));
    setNextPanel(panels.get(7), panels.get(6));
    setNextPanel(panels.get(6), panels.get(5));
    setNextPanel(panels.get(5), panels.get(4));
    setNextPanel(panels.get(4), panels.get(1));
    setNextPanel(panels.get(1), panels.get(31));
    setNextPanel(panels.get(31), panels.get(30));
    setNextPanel(panels.get(30), panels.get(29));
    setNextPanel(panels.get(29), panels.get(28));
    setNextPanel(panels.get(28), panels.get(27));
    setNextPanel(panels.get(27), panels.get(26));
    setNextPanel(panels.get(26), panels.get(25));
    setNextPanel(panels.get(25), panels.get(2));
    setNextPanel(panels.get(2), panels.get(24));
    setNextPanel(panels.get(24), panels.get(23));
    setNextPanel(panels.get(23), panels.get(22));
    setNextPanel(panels.get(22), panels.get(21));
    setNextPanel(panels.get(21), panels.get(20));
    setNextPanel(panels.get(20), panels.get(19));
    setNextPanel(panels.get(19), panels.get(18));
    setNextPanel(panels.get(18), panels.get(3));
    setNextPanel(panels.get(3), panels.get(17));
    setNextPanel(panels.get(17), panels.get(16));
    setNextPanel(panels.get(16), panels.get(16));
    setNextPanel(panels.get(15), panels.get(14));
    setNextPanel(panels.get(14), panels.get(13));
    setNextPanel(panels.get(13), panels.get(12));
    setNextPanel(panels.get(12), panels.get(11));
    setNextPanel(panels.get(11), panels.get(0));
    setNextPanel(panels.get(0), panels.get(10));

    setNextPanel(panels.get(0), panels.get(11));
    setNextPanel(panels.get(11), panels.get(12));
    setNextPanel(panels.get(12), panels.get(13));
    setNextPanel(panels.get(13), panels.get(14));
    setNextPanel(panels.get(14), panels.get(15));
    setNextPanel(panels.get(15), panels.get(16));
    setNextPanel(panels.get(16), panels.get(17));
    setNextPanel(panels.get(17), panels.get(3));
    setNextPanel(panels.get(3), panels.get(18));
    setNextPanel(panels.get(18), panels.get(19));
    setNextPanel(panels.get(19), panels.get(20));
    setNextPanel(panels.get(20), panels.get(21));
    setNextPanel(panels.get(21), panels.get(22));
    setNextPanel(panels.get(22), panels.get(23));
    setNextPanel(panels.get(23), panels.get(24));
    setNextPanel(panels.get(24), panels.get(2));
    setNextPanel(panels.get(2), panels.get(25));
    setNextPanel(panels.get(25), panels.get(26));
    setNextPanel(panels.get(26), panels.get(27));
    setNextPanel(panels.get(27), panels.get(28));
    setNextPanel(panels.get(28), panels.get(29));
    setNextPanel(panels.get(29), panels.get(30));
    setNextPanel(panels.get(30), panels.get(31));
    setNextPanel(panels.get(31), panels.get(1));
    setNextPanel(panels.get(1), panels.get(4));
    setNextPanel(panels.get(4), panels.get(5));
    setNextPanel(panels.get(5), panels.get(6));
    setNextPanel(panels.get(6), panels.get(7));
    setNextPanel(panels.get(7), panels.get(8));
    setNextPanel(panels.get(8), panels.get(9));
    setNextPanel(panels.get(9), panels.get(10));
    setNextPanel(panels.get(10), panels.get(0));

    setCoordinates(panels.get(0), 4, 0);
    setCoordinates(panels.get(1), 0, 4);
    setCoordinates(panels.get(2), -4, 0);
    setCoordinates(panels.get(3), 0, -4);
    setCoordinates(panels.get(4), 1, 4);
    setCoordinates(panels.get(5), 1, 3);
    setCoordinates(panels.get(6), 1, 2);
    setCoordinates(panels.get(7), 1, 1);
    setCoordinates(panels.get(8), 2, 1);
    setCoordinates(panels.get(9), 3, 1);
    setCoordinates(panels.get(10), 4, 1);
    setCoordinates(panels.get(11), 4, -1);
    setCoordinates(panels.get(12), 3, -1);
    setCoordinates(panels.get(13), 2, -1);
    setCoordinates(panels.get(14), 1, -1);
    setCoordinates(panels.get(15), 1, -2);
    setCoordinates(panels.get(16), 1, -3);
    setCoordinates(panels.get(17), 1, -4);
    setCoordinates(panels.get(18), -1, -4);
    setCoordinates(panels.get(19), -1, -3);
    setCoordinates(panels.get(20), -1, -2);
    setCoordinates(panels.get(21), -1, -1);
    setCoordinates(panels.get(22), -2, -1);
    setCoordinates(panels.get(23), -3, -1);
    setCoordinates(panels.get(24), -4, -1);
    setCoordinates(panels.get(25), -4, 1);
    setCoordinates(panels.get(26), -3, 1);
    setCoordinates(panels.get(27), -2, 1);
    setCoordinates(panels.get(28), -1, 1);
    setCoordinates(panels.get(29), -1, 2);
    setCoordinates(panels.get(30), -1, 3);
    setCoordinates(panels.get(31), -1, 4);
  }

  /**
   * Sets the coordinates of a given panel.
   *
   * @param panel The panel we want to locate
   * @param x     The x-axis
   * @param y     The y-axis
   */
  public void setCoordinates(final Panel panel, final int x, final int y) {
    panel.setCoordinates(x, y);
  }

  /**
   * Gets the player coordinates,
   * according to their player number.
   *
   * @param number The number of the player
   * @return the selected player number
   */
  public int[] getPlayerCoordinates(final int number) {
    return listOfPlayers.get(number - 1).getPanel().getCoordinates();
  }

  /**
   * Gets if the actual state is Start State.
   *
   * @return true if we are in Start State
   */
  public boolean isStartState() {
    return state.isStartState();
  }

  /**
   * Gets if the actual state is Stars State.
   *
   * @return true if we are in Stars State
   */
  public boolean isStarsState() {
    return state.isStarsState();
  }

  /**
   * Gets if the actual state is Recovery State.
   *
   * @return true if we are in Recovery State
   */
  public boolean isRecoveryState() {
    return state.isRecoveryState();
  }

  /**
   * Gets if the actual state is Wait State.
   *
   * @return true if we are in Wait State
   */
  public boolean isWaitState() {
    return state.isWaitState();
  }

  /**
   * Gets if the actual state is Card State.
   *
   * @return true if we are in Card State
   */
  public boolean isCardState() {
    return state.isCardState();
  }

  /**
   * Gets if the actual state is Card Activation State.
   *
   * @return true if we are in Card Activation State
   */
  public boolean isCardActivationState() {
    return state.isCardActivationState();
  }

  /**
   * Gets if the actual state is Roll State.
   *
   * @return true if we are in Roll State
   */
  public boolean isRollState() {
    return state.isRollState();
  }

  /**
   * Gets if the actual state is Path State.
   *
   * @return true if we are in Path State
   */
  public boolean isPathState() {
    return state.isPathState();
  }

  /**
   * Gets if the actual state is Move State.
   *
   * @return true if we are in Move State
   */
  public boolean isMoveState() {
    return state.isMoveState();
  }

  /**
   * Gets if the actual state is Panel Effect State.
   *
   * @return true if we are in Panel Effect State
   */
  public boolean isPanelEffectState() {
    return state.isPanelEffectState();
  }

  /**
   * Gets if the actual state is Battle State.
   *
   * @return true if we are in Battle State
   */
  public boolean isBattleState() {
    return state.isBattleState();
  }

  /**
   * Gets if the actual state is Fight State.
   *
   * @return true if we are in Fight State
   */
  public boolean isFightState() {
    return state.isFightState();
  }

  /**
   * Gets if the actual state is Fight Card State.
   *
   * @return true if we are in Fight Card State
   */
  public boolean isFightCardState() {
    return state.isFightCardState();
  }

  /**
   * Gets if the actual state is Fight Card Activation State.
   *
   * @return true if we are in Fight Card Activation State
   */
  public boolean isFightCardActivationState() {
    return state.isFightCardActivationState();
  }

  /**
   * Gets if the actual state is Attack State.
   *
   * @return true if we are in Attack State
   */
  public boolean isAttackState() {
    return state.isAttackState();
  }

  /**
   * Gets if the actual state is Counter Attack State.
   *
   * @return true if we are in Counter Attack State
   */
  public boolean isCounterAttackState() {
    return state.isCounterAttackState();
  }

  /**
   * Gets if the actual state is Evade State.
   *
   * @return true if we are in Evade State
   */
  public boolean isEvadeState() {
    return state.isEvadeState();
  }

  /**
   * Gets if the actual state is Counter Evade State.
   *
   * @return true if we are in Counter Evade State
   */
  public boolean isCounterEvadeState() {
    return state.isCounterEvadeState();
  }

  /**
   * Gets if the actual state is Defend State.
   *
   * @return true if we are in Defend State
   */
  public boolean isDefendState() {
    return state.isDefendState();
  }

  /**
   * Gets if the actual state is Counter Defend State.
   *
   * @return true if we are in Counter Defend State
   */
  public boolean isCounterDefendState() {
    return state.isCounterDefendState();
  }

  /**
   * Gets if the actual state is End Battle State.
   *
   * @return true if we are in End Battle State
   */
  public boolean isEndBattleState() {
    return state.isEndBattleState();
  }

  /**
   * Gets if the actual state is Final State.
   *
   * @return true if we are in Final State
   */
  public boolean isFinalState() {
    return state.isFinalState();
  }

  /**
   * Moves the player recursively, checking in every panel
   * if there's an encounter with a player, home panel or path split.
   * If not, keeps moving until there's no movements left.
   */
  public void playerMovement() {
    Player turnOwner = getTurn();
    Panel panel = getActualPanel();

    if (getNumberOfMovements() > 0) {
      if (!isPathSplitEncounter(panel)) {
        setIsPathSplitEncounter(false);
        setNumberOfMovements(getNumberOfMovements() - 1);

        Panel nextPanel = panel.getNextPanels().get(0);
        placePlayer(turnOwner, nextPanel);
        if (isPlayersEncounter(nextPanel)) {
          //we found a player, choose to fight or not
          setIsPlayersEncounter(true);
          setIsHomePanelEncounter(false);
        }
        if (isHomePanelEncounter(nextPanel)) {
          //we found a home panel, choose to stop or not
          setIsHomePanelEncounter(true);
          setIsPlayersEncounter(false);
        } else {
          //we didn't find anything different, keep moving
          playerMovement();
        }
      } else {
        //input handler for path choosing
        setIsPathSplitEncounter(true);
      }
    } else {
      if (!isPathSplitEncounter(panel)) {
        setIsPathSplitEncounter(false);
        if (isPlayersEncounter(panel)) {
          //we found a player, choose to fight or not
          setIsPlayersEncounter(true);
          setIsHomePanelEncounter(false);
        }
        if (isHomePanelEncounter(panel)) {
          //we found a home panel, choose to stop or not
          setIsHomePanelEncounter(true);
          setIsPlayersEncounter(false);
        }
      } else {
        setIsPathSplitEncounter(true);
      }
    }
  }

  /**
   * Changes the value when there's a path split or not.
   *
   * @param ips Is there a path split?
   */
  public void setIsPathSplitEncounter(final boolean ips) {
    this.isPathSplitEncounter = ips;
  }

  /**
   * Changes the value when there's a home panel or not.
   *
   * @param ihpe Is there a home panel?
   */
  private void setIsHomePanelEncounter(final boolean ihpe) {
    this.isHomePanelEncounter = ihpe;
  }


  /**
   * Gets if there's a players encounter.
   *
   * @return true if there's a players encounter
   */
  public boolean getIsPlayersEncounter() {
    return this.isPlayersEncounter;
  }

  /**
   * Changes the value when there's a players encounter or not.
   *
   * @param ipe Is there a players encounter?
   */
  public void setIsPlayersEncounter(final boolean ipe) {
    this.isPlayersEncounter = ipe;
  }

  /**
   * Throws the player on turn's dice.
   * For testing purposes.
   */
  public void promptThrowAction() {
    int number = getTurn().roll();
    setNumberOfMovements(number);
  }

  /**
   * Gets whether if the card is playable or not.
   *
   * @return true if we can play the card
   */
  public boolean getIsCardPlayable() {
    return isCardPlayable;
  }

  /**
   * Changes the state of the playability of the card.
   *
   * @param icp Is the card playable?
   */
  public void setIsCardPlayable(final boolean icp) {
    this.isCardPlayable = icp;
  }

  /**
   * Gets if there's a home panel ahead of the player
   * and it's his own.
   *
   * @return true if the panel is a home panel
   *        and the owner is the actual player
   */
  public boolean getIsHomePanelEncounter() {
    return isHomePanelEncounter;
  }

  /**
   * Gets if there's a path split ahead.
   *
   * @return true if there's a path split
   */
  public boolean getIsPathSplitEncounter() {
    return this.isPathSplitEncounter;
  }

  /**
   * Gets if a path was chosen.
   *
   * @return true if the path was chosen
   */
  public boolean getIsPathChosen() {
    return this.isPathChosen;
  }

  /**
   * Changes the value that indicates if the path was chosen.
   *
   * @param pathChosen Was the path chosen?
   */
  public void setPathChosen(final boolean pathChosen) {
    isPathChosen = pathChosen;
  }

  /**
   * Gets if the player wants to fight or not.
   *
   * @return true if the player wants to fight.
   */
  public boolean getWantsToFight() {
    return this.wantsToFight;
  }

  /**
   * Change the value if the wants to fight or doesn't.
   *
   * @param wtf Wants to fight?
   */
  public void setWantsToFight(final boolean wtf) {
    wantsToFight = wtf;
  }

  /**
   * Gets the target of the actual player in turn.
   *
   * @return a player that is a target of attack
   */
  public Player getTarget() {
    return this.target;
  }

  /**
   * Changes the player we are attacking.
   *
   * @param trgt the target of the attack
   */
  public void setTarget(final Player trgt) {
    this.target = trgt;
  }

  /**
   * Activates the effect of the panel
   * onto the actual player.
   */
  public void activatedBy() {
    Player t = getTurn();
    getActualPanel().activatedBy(t);
  }

  /**
   * Activates a card.
   */
  public void activateCard() {
  }

  /**
   * Activates a fight card.
   */
  public void activateFightCard() {
  }

  /**
   * Activates the fight card of the target.
   */
  public void activateFightCardTarget() {
  }

  /**
   * Creates a circular turn change.
   * Changes the actual turn to the next player in line.
   * If all the players have passed, then changes the chapter.
   */
  public void changeTurn() {
    Player actualTurn = getTurn();
    int index = getListOfPlayers().indexOf(actualTurn);
    int nextTurn = (index + 1) % getListOfPlayers().size();
    setTurn(getListOfPlayers().get(nextTurn));
    if (nextTurn == 0) {
      setChapter(getChapter() + 1);
    }
  }

  /**
   * Rolls the dice and gets the base attack of the player.
   */
  public void rollForAtk() {
    int attack = getTurn().roll();
    setAttackPower(attack);
  }

  /**
   * Rolls the dice and gets the base attack of the target.
   */
  public void rollForCounterAtk() {
    int attack = getTarget().roll();
    setCounterAttackPower(attack);
  }

  /**
   * Rolls the dice and gets the base evasion of the target.
   */
  public void rollForEvading() {
    int evade = getTarget().roll();
    setEvadePower(evade);
  }

  /**
   * Rolls the dice and gets the base evasion of the player in turn.
   */
  public void rollTurnForEvading() {
    int evade = getTurn().roll();
    setCounterEvadePower(evade);
  }

  /**
   * Changes the evasion power of the target.
   *
   * @param evade The additional points of evasion for the target
   */
  private void setEvadePower(final int evade) {
    this.evadePower = getTarget().getEvd() + evade;
  }

  /**
   * Gets the evasion power of the target.
   *
   * @return the evasion power of the actual target
   */
  public int getEvadePower() {
    return this.evadePower;
  }

  /**
   * Rolls the dice and gets the base defense of the target.
   */
  public void rollForDefending() {
    int defense = getTarget().roll();
    setDefensePower(defense);
  }

  /**
   * Rolls the dice and gets the base defense of the player in turn.
   */
  public void rollTurnForDefending() {
    int defense = getTurn().roll();
    setCounterDefensePower(defense);
  }

  /**
   * Changes the evasion power of the player in turn.
   *
   * @param evade The additional points of evasion for the player in turn
   */
  private void setCounterEvadePower(final int evade) {
    this.counterEvadePower = getTurn().getEvd() + evade;
  }

  /**
   * Gets the evasion power of the player in turn.
   *
   * @return the evasion power of the player in turn
   */
  public int getCounterEvadePower() {
    return this.counterEvadePower;
  }

  /**
   * Changes the defending power of the target.
   *
   * @param defense The additional points of defense for the target
   */
  private void setDefensePower(final int defense) {
    this.defensePower = getTarget().getDef() + defense;
  }

  /**
   * Gets the evasion power of the player in turn.
   *
   * @return the evasion power of the player in turn
   */
  public int getCounterDefensePower() {
    return this.counterDefensePower;
  }

  /**
   * Changes the defending power of the player in turn.
   *
   * @param defense The additional points of defense for the player in turn
   */
  private void setCounterDefensePower(final int defense) {
    this.counterDefensePower = getTurn().getDef() + defense;
  }

  /**
   * Gets the evasion power of the target.
   *
   * @return the evasion power of the actual target
   */
  public int getDefensePower() {
    return this.defensePower;
  }


  /**
   * Sets the attack power of the actual player.
   *
   * @param attack the additional attack points of the player.
   */
  public void setAttackPower(final int attack) {
    this.attackPower = getTurn().getAtk() + attack;
  }

  /**
   * Sets the attack power of the target.
   *
   * @param attack the additional attack points of the target.
   */
  private void setCounterAttackPower(final int attack) {
    this.counterAttackPower = getTarget().getAtk() + attack;
  }

  /**
   * Gets the attack power of the player in turn.
   *
   * @return the number with the attack power of the player
   */
  public int getAttackPower() {
    return this.attackPower;
  }

  /**
   * Gets the attack power of the target.
   *
   * @return the number with the attack power of the target
   */
  public int getCounterAttackPower() {
    return this.counterAttackPower;
  }

  /**
   * Gets if the target is evading.
   *
   * @return true if the target is evading
   */
  public boolean getIsEvading() {
    return this.isEvading;
  }

  /**
   * Gets if the player in turn is evading.
   *
   * @return true if the player in turn is evading
   */
  public boolean getIsTurnEvading() {
    return this.isTurnEvading;
  }

  /**
   * Changes if the target is evading or not.
   *
   * @param ie Is the player evading?
   */
  public void setIsEvading(final boolean ie) {
    this.isEvading = ie;
  }

  /**
   * Changes if the player in turn is evading or not.
   *
   * @param ie Is the player evading?
   */
  public void setIsTurnEvading(final boolean ie) {
    this.isTurnEvading = ie;
  }

  /**
   * Gets if the target is defending.
   *
   * @return true if the target is defending
   */
  public boolean getIsDefending() {
    return this.isDefending;
  }

  /**
   * Gets if the player in turn is defending.
   *
   * @return true if the player in turn is defending
   */
  public boolean getIsTurnDefending() {
    return this.isTurnDefending;
  }

  /**
   * Changes if the target is defending or not.
   *
   * @param id Is the target defending?
   */
  public void setIsDefending(final boolean id) {
    this.isDefending = id;
  }

  /**
   * Changes if the player in turn is defending or not.
   *
   * @param id Is the player in turn defending?
   */
  public void setIsTurnDefending(final boolean id) {
    this.isTurnDefending = id;
  }

  /**
   * Changes the hp points of the
   * target depending on the attack power of the player
   * and the hp points of the target.
   */
  public void hitTarget() {
    Player t = getTarget();
    int hit = getAttackPower();
    int hp = t.getCurrentHp();
    t.setCurrentHp(Math.max(0, hp - hit));
  }

  /**
   * Changes the hp points of the player in turn
   * depending on the attack power of the target
   * and the hp points of the player.
   */
  public void hitTurn() {
    Player t = getTurn();
    int hit = getCounterAttackPower();
    int hp = t.getCurrentHp();
    t.setCurrentHp(Math.max(0, hp - hit));
  }

  /**
   * Changes the hp points of the target
   * depending on the attack power of the player
   * and defense power of the target.
   */
  public void hitTargetWithDefense() {
    Player t = getTarget();
    int defense = getDefensePower();
    int attack = getAttackPower();
    int hit = Math.max(1, (attack - defense));
    int hp = t.getCurrentHp();
    t.setCurrentHp(Math.max(0, hp - hit));
  }

  /**
   * Changes the hp points of the player in turn
   * depending on the attack power of the target
   * and defense power of the player in turn.
   */
  public void hitTurnWithDefense() {
    Player t = getTurn();
    int defense = getCounterDefensePower();
    int attack = getCounterAttackPower();
    int hit = Math.max(1, (attack - defense));
    int hp = t.getCurrentHp();
    t.setCurrentHp(Math.max(0, hp - hit));
  }

  /**
   * Asks if the player wants to use a card.
   */
  public void promptUseCard() {
  }

  /**
   * Asks if the target wants to use a card.
   */
  public void promptUseCardTarget() {
  }

  /**
   * Asks for a card of the election of the player.
   */
  public void promptCardSelection() {

  }

  /**
   * Asks for a card of the election of the target.
   */
  public void promptCardSelectionTarget() {

  }

  /**
   * Asks for a path to the player.
   */
  public void promptPathSelection() {

  }

  /**
   * Asks the player if it wants to fight.
   */
  public void promptChooseToFight() {

  }

  /**
   * Asks the player to select a target.
   */
  public void promptCharacterSelection() {
    setListOfFight();
  }

  /**
   * Asks the player to select a card.
   */
  public void promptFightCardSelection() {
  }

  /**
   * Asks the target it's next move.
   * Defend/Evade.
   */
  public void promptDefendEvade() {
  }

  /**
   * Asks the player in turn if it wants to
   * defend or evade.
   */
  public void promptTurnDefendEvade() {
  }

  /**
   * Changes the winner of the actual battle.
   *
   * @param player A character of the game
   */
  public void setBattleWinner(final Player player) {
    this.battleWinner = player;
  }

  /**
   * Gets the winner of the actual battle.
   *
   * @return The player that won the battle
   */
  public Player getBattleWinner() {
    return this.battleWinner;
  }

  /**
   * Changes the loser of the actual battle.
   *
   * @param player A character of the game
   */
  public void setBattleLoser(final Player player) {
    this.battleLoser = player;
  }

  /**
   * Gets the loser of the actual battle.
   *
   * @return The player that lost the battle
   */
  public Player getBattleLoser() {
    return this.battleLoser;
  }

  /**
   * Given a winner and a loser of a battle
   * transfers half of the loser stars to the winner
   * and gives 2 wins.
   */
  public void battleResult() {
    Player win = getBattleWinner();
    Player loser = getBattleLoser();

    if (win != null) {
      int stars = loser.getStars();
      int givenStars = (int) Math.floor(stars / 2);

      int actualWins = win.getWins();
      win.setWins(actualWins + 2);
      win.increaseStarsBy(givenStars);
    }
  }

  /**
   * Removes the player we are actually fighting.
   */
  public void foughtCheck() {
    getListOfFight().remove(getTarget());
  }

  /**
   * Gets the list of players we can fight.
   *
   * @return a list of players we can fight
   */
  public List<Player> getListOfFight() {
    return this.listOfFight;
  }

  /**
   * Changes the list of players we can fight.
   */
  public void setListOfFight() {
    List<Player> fight = getActualPanel().getListOfPlayers();
    fight.remove(getTurn());
    this.listOfFight = fight;
  }

  /**
   * Executes a norma check.
   */
  public void normaCheck() {
    getActualPanel().activatedBy(getTurn());
  }


  /**
   * Set's the seed for this player's random number generator.
   *
   * <p>The random number generator is used for taking
   * non-deterministic decisions, this method is
   * declared to avoid non-deterministic behaviour while testing the code.
   *
   * @param seed A number that makes the random object constant
   */
  public void setSeed(final long seed) {
    getTurn().setSeed(seed);
  }

  /**
   * Set's the seed for this player's random number generator.
   *
   * <p>The random number generator is used for taking
   * non-deterministic decisions, this method is
   * declared to avoid non-deterministic behaviour while testing the code.
   *
   * @param seed A number that makes the random object constant
   */
  public void setTargetSeed(final long seed) {
    getTarget().setSeed(seed);
  }

  /**
   * Changes the position of the player to the chosen path.
   *
   * @param path The number of the path chosen
   */
  public void setPath(final int path) {
    List<Panel> next = getActualPanel().getNextPanels();
    Panel chosen = next.get(path - 1);
    setNumberOfMovements(getNumberOfMovements() - 1);
    placePlayer(getTurn(), chosen);
    setIsPathSplitEncounter(false);
    setPathChosen(true);

  }
}
