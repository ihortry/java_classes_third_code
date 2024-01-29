/**
 * 	@author Ihor Tryndey 3105023
 *  @version 2.0
 *  @since 2023
 */
package griffith;

//player should implement the battle interface
/**
 * 
 * @author Ihor Tryndey 3105023
 * Class for Player
 */
public class Player extends GameCharacter implements Battle{

	private int health;
	private int exp;
	private int atk;
	
	/**
	 * Parametrised constructor with one parameter 
	 * @param name for player(user)
	 */
	public Player(String name) {
		super(name,60);
		health = 100;
		exp = 0;
		atk = 10 ;
	}
	
	/**
	 * Method that returns health of player
	 * @return health of player
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Method that sets health of player
	 * @param health of player
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	@Override
	/**
	 * Override method with stats
	 * @return statats of player 
	 */	
	public String getStats() {
			return "Stats:\tGold "+ getGold()+
				"\n\tHealth:"+ health+
				"\n\tAtk:"+ atk+
				"\n\tExp:"+ exp;
	}

	@Override
	/**
	 *  Method that returns experience of a player
	 *  @return experience of a user
	 */
	public int getExp() {
		return exp;
	}

	@Override
	/**
	 *  Method that returns atk
	 *  @return atk of player
	 */
	public int getAtk() {
		return atk;
	}

	@Override
    /**
     *  Method that will subtract an attack from health 
     *  @param attack form enemy
     */
	public void takeDamage(int attack) {
		health -= attack;
	}

	@Override
	/**
	 *  Method that will increase experience after winning
	 *  @param amount that will be added to player's experience 
	 */
	public void increaseExp(int amount) {
		 exp += amount;
	}

	@Override
	/**
	 *  Method that heal player 
	 *  @param amout of health that will be healed for player
	 */
	public void heal(int amount) {
		health += amount;		
	}

	@Override
	/**
	 *  Method that add gold to player
	 *  @gold that will be added to player's gold
	 */
	public void addGold(double gold) {
		setGold(getGold() + gold);
	}
	
	/**
	*  Method that lose gold 
	*  @param gold which will be subtracted from total player gold
	*/
	@Override	
	public void loseGold(double gold) {
		setGold(getGold() - gold);		
	}

}


