/**
 * 	@author Ihor Tryndey 3105023
 *  @version 2.0
 *  @since 2023
 */
package griffith;

/**
 * @author Ihor Tryndey 3105023
 *
 * Class Healer that describes character that will heal player 
 */
public class Healer extends GameCharacter{

	private int cost;
	private int amount;
	
	/**
	 * Parametrised constructor with four parameters 
	 * @param name of healer
	 * @param gold which belongs to healer
	 * @param cost which player pays to be healed
	 * @param amount that healer can heal
	 */
	public Healer(String name, double gold, int cost, int amount) {
		super(name, gold);
		this.amount = amount;
		this.cost = cost;
	}
	
	@Override
	/**
	 *  Method that get stats of healer
	 *  @return String with information
	 */
	public String getStats() {	
		return "Healer [cost=" + cost + ", amount=" + amount + "]";
	}

	/**
	 * Method that returns cost of heal
	 * @return cost which player need to pay for healing
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Method that sets cost 
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * Method that returns amount health that healer can heal
	 * @return amount of health to heal
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Method that sets amount of health to heal
	 * @param amount that can be healed 
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
