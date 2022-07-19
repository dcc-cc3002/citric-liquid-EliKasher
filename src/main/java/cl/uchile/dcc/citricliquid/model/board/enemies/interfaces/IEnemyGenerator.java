package cl.uchile.dcc.citricliquid.model.board.enemies.interfaces;

import cl.uchile.dcc.citricliquid.model.board.enemies.BossUnit;
import cl.uchile.dcc.citricliquid.model.board.enemies.WildUnit;

/**
 * The interface for the Enemy Factory-
 */
public interface IEnemyGenerator {
    /**
     * Returns a uniformly distributed random value in [1, 3].
     *
     * @param seed A number that helps random throw the same result
     * @return a random number between 1 and 3
     */
    int pickEnemyS(final long seed);

    /**
     * Puts a seed into a random object.
     *
     * @param seed A number that helps random throw the same result
     */
    void setEnemySeed(final long seed);

    /**
     * Generates a random boss unit.
     *
     * @param random It's a random number
     * @return a random boss unit
     */
    BossUnit bossGen(final long random);

    /**
     * Generates a random wild unit.
     *
     * @param random It's a random object
     * @return a random wild unit
     */
    WildUnit wildGen(final long random);
}
