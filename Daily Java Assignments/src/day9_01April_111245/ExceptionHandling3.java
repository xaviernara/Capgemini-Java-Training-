package day9_01April_111245;

import java.io.*;

//Assignment 28

public class ExceptionHandling3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			System.out.println("Enter the number of players");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int numOfPlayers = Integer.parseInt(br.readLine());
			Player[] players = new Player[numOfPlayers];
			PlayerBO playerBO = new PlayerBO();
			String captainName, captainSkillSet, captainCountry, Name;

			// for (int i = 0; i < players.length; i++) {

			System.out.println("Do you know the details of the captain? Type Yes / No");
			String captionDetails = br.readLine();

			if (captionDetails.equalsIgnoreCase("yes")) {
				System.out.println("Enter name of the captain");
				captainName = br.readLine();

				System.out.println("Enter country of the captain");
				captainCountry = br.readLine();

				System.out.println("Enter skillset of the captain");
				captainSkillSet = br.readLine();

				Player captian = new Player(captainName, captainCountry, captainSkillSet);
				players[0] = captian;

				for (int i = 1; i < players.length; i++) {
					System.out.println("Enter name of player " + (i));
					Name = br.readLine();

					System.out.println("Enter country of player " + (i));
					String Country = br.readLine();

					System.out.println("Enter skillset of the player");
					String SkillSet = br.readLine();

					Player player = new Player(Name, Country, SkillSet);
					players[i] = player;

					System.out.println("Captain Details: ");
					playerBO.displayPlayerDetails(players, captainName);

					System.out.println("Player Details : ");
					playerBO.displayPlayerDetails(players, Name);
				}

			} else {
				for (int i = 0; i < players.length; i++) {
					System.out.println("Enter name of player " + (i + 1));
					Name = br.readLine();

					System.out.println("Enter country of player " + (i + 1));
					String Country = br.readLine();

					System.out.println("Enter skillset of the player");
					String SkillSet = br.readLine();

					Player player = new Player(Name, Country, SkillSet);
					players[i] = player;

					// System.out.println("Captain Details: ");
					// playerBO.displayPlayerDetails(players,captainName);

					System.out.println("Player Details \n");
					playerBO.displayPlayerDetails(players, Name);
				}

			}
			
			/*
			 * System.out.println("Enter name of player " + (i + 1)); Name =
			 * br.readLine();
			 * 
			 * System.out.println("Enter country of player " + (i + 1)); String
			 * Country = br.readLine();
			 * 
			 * System.out.println("Enter skillset of the captain"); String
			 * SkillSet = br.readLine();
			 * 
			 * Player player = new Player(Name, Country, SkillSet); players[i] =
			 * player;
			 * 
			 * //System.out.println("Captain Details \n");
			 * //System.out.println(players[i].getName() +" "+
			 * players[i].getCountry()+" "+players[i].getSkill());
			 * System.out.println("Player Details \n");
			 * playerBO.displayPlayerDetails(players, Name);
			 */

		} catch (Exception e) {
			System.out.println("Captain details not available");
			System.out.println(e.getClass().getName());
		}

	}

}

class Player {
	String name;
	String country;
	String skill;

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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Player(String name, String country, String skill) {
		this.name = name;
		this.country = country;
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", country=" + country + ", skill=" + skill + "]";
	}

}

class PlayerBO {

	void displayPlayerDetails(Player[] players, String name) {
		for (Player p : players) {
			if (p.getName().equalsIgnoreCase(name)) {
				System.out.println(p.toString());
			}

		}
	}
}
