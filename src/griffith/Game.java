package griffith;
/**
 * 	@author Ihor Tryndey 3105023
 *  @version 2.0
 *  @since 2023
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {

	final static int MAX_GOLD =999;
	public static void main(String args[]) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		
		Random rand = new Random();	
		
		System.out.println("Welcome, Enter the players name");
		String name = scanner.nextLine();
		
		Player player = new Player(name);
		System.out.println("Try to get " +MAX_GOLD + " gold " + player.getName());
		
		//list of all characters a player can encounter
		ArrayList<GameCharacter> encounters = new ArrayList<GameCharacter>();
		
		//add instances of enemies to encounters
		Enemy enemyOne = new Enemy(5, 10, "Usyk", 135.5);
		encounters.add(enemyOne);
		
		Enemy enemyTwo = new Enemy(80, 30, "Lomachenko", 170.9);
		encounters.add(enemyTwo);
		
		Enemy enemyThree = new Enemy(10, 80, "Berinchik", 150.0);
		encounters.add(enemyThree);
		
		//add one or more Bosses to encounters
		Boss boss = new Boss(9, 30, "Tyson", 400);
		encounters.add(boss);
		
		//add a healer to encounters
		Healer healer = new Healer("Kotigoroshko",0, 40, 25);
		encounters.add(healer);
		
		Collections.shuffle(encounters);
		while(player.getHealth() > 0 && player.getGold() < MAX_GOLD)
		{
			ArrayList<GameCharacter> bossToRemove = new ArrayList<>();
		
			for(GameCharacter character : encounters)
			{
				System.out.println(player.getStats());
				
				System.out.println("You have encountered "+ character.getName());
				
				//check if character is an enemy
				if(character instanceof Enemy) {
					Enemy characterEnemy = (Enemy) character;
					// Display the enemy health and atk stat
					System.out.println("Enemy ATK: " + characterEnemy.getAtk());
				
					// ask if the user wants to battle or run
					System.out.println("Do you want run or fight?");
					// if they choose battle 
					String userAnswer  = scanner.next();
					if(userAnswer.equals("fight")) {
						//compare atk power,
							//if enemies atk is higher
						if(characterEnemy.getAtk() > player.getAtk()) {
							System.out.println("You lost");
								// take away health from player
							player.takeDamage(characterEnemy.getAtk());
								// take away gold from player
							player.loseGold(20);
								// increase enemies exp
							characterEnemy.increaseExp(10);
								// increase enemies gold
							characterEnemy.addGold(20);
								// continue to next encounter
						}else if(characterEnemy.getAtk() < player.getAtk()) {	
							System.out.println("You won");
							//if player atk is higher
								
							// if it is a Boss 
							//add double exp and gold
							//remove boss from encounters
							//continue to next encounter
						
							
						if(characterEnemy instanceof Boss) {
							//if block is off
							if(((Boss) characterEnemy).getBlock() == false) {
							System.out.println("Block is off");
							// add enemy exp to player	
							player.increaseExp(2 * characterEnemy.getExp());
							// add enemy gold to player	
							player.addGold(2 * characterEnemy.getGold());

							bossToRemove.add(character);
							//if block is on
							}else if(((Boss) characterEnemy).getBlock() == true){
								System.out.println("Block is on");
							}
							
						}else{
							// add enemy exp to player	
							player.increaseExp(characterEnemy.getExp());
							// add enemy gold to player	
							player.addGold(characterEnemy.getGold());
							}
						}else if(characterEnemy.getAtk() == player.getAtk()) {	
							//if attack is the same randomly choose a winner
							int j = rand.nextInt(1,3);
							System.out.println(j);
							/**
							 *  1 - stands for win 
							 *  2 - stands for loss
							 */
							 if(j ==  1) {
								 System.out.println("You won");
								 
								 if(characterEnemy instanceof Boss) {
										
									 //if block is off
										if(((Boss) characterEnemy).getBlock() == false) {
										System.out.println("Block is off");
										// add enemy exp to player	
										player.increaseExp(2 * characterEnemy.getExp());
										// add enemy gold to player	
										player.addGold(2 * characterEnemy.getGold());

										bossToRemove.add(character);
										//if block is on
										}else if(((Boss) characterEnemy).getBlock() == true){
											System.out.println("Block is on");
										}
										
										}else {
										player.increaseExp(characterEnemy.getExp());
										
										player.addGold(characterEnemy.getGold());
										}
								 
							 }else if(j == 2) {
								 System.out.println("You lost");
									// take away health from player
								player.takeDamage(characterEnemy.getAtk());
									// take away gold from player
								player.loseGold(20);
									// increase enemies exp
								characterEnemy.increaseExp(10);
									// increase enemies gold
								characterEnemy.addGold(20);
									// continue to next encounter
							 }
							
						// if they choose run then continue to next encounter
							
						}
					}
					
					
				//check if character is a Healer
				}else if(character instanceof Healer){
					Healer characterHealer = (Healer) character;
					System.out.println("Cost: "+ characterHealer.getCost() + "\nHealing: "  + characterHealer.getAmount() +  "\nDo you want to heal? y/n");
					//Check if a user wants healing 
					String userHeal = scanner.next();
					if(userHeal.equals("y")) {
						//check if they have enough gold
						if(player.getGold() >= characterHealer.getCost()) {
						//if they say yes 
						//increase their health
						
							player.heal(characterHealer.getAmount());
				    		//decrease their gold
							player.loseGold(characterHealer.getCost());
						}else {
							System.out.println("You have not enough gold");
						}
					} 				
				}
				 
			}
			encounters.removeAll(bossToRemove);
		}
		if(player.getHealth() <0)
			System.out.println("You died "+ player.getName());
		else
			System.out.println("You won "+ player.getName());
		}

}