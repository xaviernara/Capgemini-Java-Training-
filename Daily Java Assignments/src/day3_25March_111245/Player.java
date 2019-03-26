
package day3_25March_111245;

import java.util.*;

/**
 * Assignmnet 16
 *
 */
public class Player {
	private String name;
	private String country;
	private String skill;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Player(String name, String country, String skill) {
		this.name = name;
		this.country = country;
		this.skill = skill;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s", name, country, skill.toString());
	}

	// ----------------------------------------------------------------

	// ----------------------------------------------------------------

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlayerBO playBO = null;
		Scanner scan = new Scanner(System.in);

		Player player = null;

		System.out.println("Enter number of Players");
		int numOfPlayers = scan.nextInt();
		Player[] playerArray = new Player[numOfPlayers];

		for (int i = 0; i < playerArray.length; i++) {

			System.out.println("Enter player " + (i + 1) + " details:");
			System.out.println("Enter player name");

			String playerName = scan.next();

			player.setName(playerName);

			System.out.println("Enter country name ");
			
			String playerCountry = scan.next();

			player.setCountry(playerCountry);

			System.out.println("Enter skill ");
			String playerSkill = scan.next();

			player.setSkill(new Skill(playerSkill));
			//Player player = new Player(playerName, playerCountry, new Skill(playerSkill));

			playerArray[i] = player;

		}

		boolean menuShowing = true;
		while (menuShowing) {
			System.out.println("Menu");
			System.out.println("1.View details");
			System.out.println("2.Filter players with skill");
			System.out.println("3.Exit");

			int menuNum = scan.nextInt();

			if (menuNum == 1) {
				System.out.println("Player    Country     Skill");
				playBO.viewDetails(playerArray);
			} else if (menuNum == 2) {

				System.out.println("Enter Skill ");
				String filterSkill = scan.nextLine();
				playBO.printPlayerDetailsWithSkill(playerArray, filterSkill);
			} else {
				System.out.println("Thank you");
				menuShowing = false;

			}

		}

	}
}

class Skill {

	private String skillName;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {

		return String.format("%-15s", skillName);
	}

	public Skill(String skillName) {
		this.skillName = skillName;
	}

}

class PlayerBO {

	public void viewDetails(Player[] playerList) {

		for (int i = 0; i < playerList.length; i++) {

			System.out.println(playerList[i]);
		}

	}

	public void printPlayerDetailsWithSkill(Player[] playerList, String skill) {

		for (Player p : playerList) {

			if (skill == p.getSkill().toString()) {

				System.out.println(p);
			} else {
				System.out.println("Skill not found");

			}
		}

	}

}
