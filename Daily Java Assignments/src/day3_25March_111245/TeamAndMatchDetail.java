/**
 * 
 */
package day3_25March_111245;

/**
 * Assignment 17
 *
 */
public class TeamAndMatchDetail {

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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	public TeamAndMatchDetail(String name, String country, String skill) {
		this.name = name;
		this.country = country;
		this.skill = skill;
	}
	




}

class PlayerBO{
	
	public Player createPlayer (String data){
		
		String[] dataArray = data.split(",",5);
		String name = dataArray[0];
		String country = dataArray[1];
		String skill = dataArray[2];
		
		Player player = new Player(name,country,skill);
		return player;
		
	}
	
}

class Team{
	private String name;
	private Player player;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Team(String name, Player player) {
		super();
		this.name = name;
		this.player = player;
	}

	
}

class TeamBO{
	public Team createTeam(String data, Player[] PlayerList){
		String[] dataArray = data.split(",",5);
		String name = dataArray[0];
		
		
		Team team = new Team ();
		
		for (){
			
		}
	}
	
	
}
