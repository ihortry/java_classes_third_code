/**
 * 	@author Ihor Tryndey 3105023
 *  @version 2.0
 *  @since 2023
 */
package griffith;

public abstract class GameCharacter {

	private String name;
	private double gold;

	/**
	 * Parametrised with two constructors
	 * @param name Character
	 * @param gold 
	 */
	public GameCharacter(String name, double gold) {
		this.name = name;
		this.gold = gold;
	}

	/**
	 * Method that return name
	 * @return name of the GameCharacter
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method that sets name of GameCharacter
	 * @param name that sets GameCharacter name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that returns gold
	 * @return gold 
	 */
	public double getGold() {
		return gold;
	}
	
	/**
	 * Method that sets gold for GameCharacter
	 * @param gold
	 */
	public void setGold(double gold) {
		this.gold =  gold;
	}
	
	public abstract String getStats();

}
