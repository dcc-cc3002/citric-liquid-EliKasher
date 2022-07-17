package cl.uchile.dcc.citricliquid.model;

/**
 * Creates a Card Object.
 */
public class Card {
  /** The name of the card. */
  private final String name;

  /**
   * Creates a card with a name.
   *
   * @param n The name of the card
   */
  public Card(final String n) {
    this.name = n;
  }

  /**
   * Gets the name of the card.
   *
   * @return a string with a name
   */
  public String getName() {
    return name;
  }
}
