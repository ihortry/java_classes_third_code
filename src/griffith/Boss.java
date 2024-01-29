/**
 * 	@author Ihor Tryndey 3105023
 *  @version 2.0
 *  @since 2023
 */
package griffith;

import java.util.Random;

public class Boss extends Enemy{
	
	public Boss(int atk, int exp, String name, double gold) {
		super(atk, exp, name, gold);
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * Method that set block for boss
	 * if r == 1 block is on
	 * if else r == 2 block is off
	 * @return boolean block
	 */
	public boolean getBlock() {
		Random rand = new Random();
		int r = rand.nextInt(1,3);
		if(r == 1) {
			return true;
		}else {
			return false;
		}		
	}
}
