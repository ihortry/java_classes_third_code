/**
 * 	@author Ihor Tryndey 3105023
 *  @version 2.0
 *  @since 2023
 */
package griffith;

//enemy should be a sub class of gameCharacter
//enemy should implement the battle interface

/**
 * 
 * @author Ihor Tryndey 3105023
 *
 * Class Enemy that will fight with player
 */
public class Enemy extends GameCharacter implements Battle{

	private int atk;
	private int exp;
	
	/**
	 * Parametrised constructor
	 * @param atk value with which enemy attack
	 * @param exp of enemy
	 * @param name of enemy
	 * @param gold which belongs to enemy
	 */
	public Enemy(int atk, int exp, String name, double gold) {
		super(name,gold); 
		this.exp = exp;
		this.atk = atk;
	}	 

	@Override
	/**
	 *  Method that returns string with stats of enemy
	 */
	public String getStats() {
		return "Enemy [atk=" + atk + ", exp=" + exp + "]";
		
	}

	@Override
	/**
	 *  Method that returns experience of enemy
	 *  @return String 
	 */
	public int getExp() {
		return exp;
	}

	@Override
	/**
	 * Method that returns attack with which enemy attack player
	 * @return atk;
	 */
	public int getAtk() {
		return atk;
	}

	@Override
	/**
	 * Method that returns damage to enemy
	 */
	public void takeDamage(int attack) {}

	@Override
	/**
	 *  Method that increase experience 
	 *  @param amount on which it increases
	 */
	public void increaseExp(int amount) {
		exp += amount;		
	}

	@Override
	/**
	 *  Method that heal enemy
	 *  @param amount on which it increases
	 */
	public void heal(int amount) {}

	@Override
	/**
	 *  Method that add gold 
	 *  @param gold amount on which amount increases
	 */
	public void addGold(double gold) {
		setGold(getGold() + gold);		
	}

	@Override
	/**
	 *  Method that subtract gold 
	 *  @param gold amount on which amount decreases 
	 */
	public void loseGold(double gold) {
		this.setGold(getGold() - gold);
		
	}
}
