package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.board.abstracts.EnemyUnit;

/**
 * Class for the wild units.
 */
public class WildUnit extends EnemyUnit {
  /**
   * Creates a new character.
   *
   * @param name the name of the enemy wild unit.
   * @param hp   the initial (and max) hit points of the character.
   * @param atk  the base damage the character does.
   * @param def  the base defense of the character.
   * @param evd  the base evasion of the character.
   * @param wins the quantity of wins this enemy gives.
   */
  public WildUnit(final String name, final int hp, final int atk,
                  final int def, final int evd, final int wins) {
    super(name, hp, atk, def, evd, wins);
  }

  /**
   * Gets a copy of the enemy character.
   *
   * @return a copy of the enemy character
   */
  @Override
  public EnemyUnit copy() {
    return new WildUnit(this.getName(), this.getMaxHp(), this.getAtk(),
        this.getDef(), this.getEvd(), this.getWins());
  }
}
