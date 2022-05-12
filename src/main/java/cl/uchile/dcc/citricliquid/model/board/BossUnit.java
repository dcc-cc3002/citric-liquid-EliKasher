package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.board.abstracts.EnemyUnit;

/**
 * Class boss unit for the bosses of the game.
 */
public class BossUnit extends EnemyUnit {
  /**
   * Creates a new character.
   *
   * @param name the name of the enemy boss unit.
   * @param hp   the initial (and max) hit points of the character.
   * @param atk  the base damage the character does.
   * @param def  the base defense of the character.
   * @param evd  the base evasion of the character.
   * @param wins the quantity of wins this enemy gives.
   */
  public BossUnit(final String name, final int hp, final int atk,
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
    return new BossUnit(this.getName(), this.getMaxHp(), this.getAtk(),
        this.getDef(), this.getEvd(), this.getWins());
  }
}
