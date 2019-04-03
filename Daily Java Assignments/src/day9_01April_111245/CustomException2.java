/**
 * 
 */
package day9_01April_111245;

import java.util.Scanner;

/**
 * @author xarichar
 * 
 * Assignment #30
 *
 */
public class CustomException2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter the team name");
		Scanner scan = new Scanner(System.in);
		String teamName = scan.nextLine();
		System.out.println("Enter the number of players suggested");
		int playersNum = scan.nextInt();
		int [] playerId = new int[playersNum];
		playerId[0] = 0;
		String[] playerName = new String[playersNum];
		
		for(int i = 0; i<playerName.length;i++){
			System.out.println("Enter player " + (i + 1) + " details");
			int id = scan.nextInt();
			String name = scan.nextLine();
			playerId[i++]=id;
			playerName[i] = name;
			uniqueIdCheck(playerId);
			
		}
	}
	
	public static void uniqueIdCheck(int[] playerId){
		
		try{
			for(int i = 0; i< playerId.length; i++){
			
			if (playerId[i] == playerId[i++]){
				throw new DuplicateIdException("Player Id must be unique");
			}
			
		}
		}catch(DuplicateIdException e){
			
			System.out.println(e.getClass() + e.getMessage());
		}
		
		
	}
	
	public void printArrays(int[] ids, String[] names){
		
		for(int i = 0; i<names.length;i++){
			System.out.println("Id: " + ids[i++] + "name: "+names[i]);
		}
	}

}

/*
class Team{
	
	private String playerName;
	private int playerId;
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public Team(String playerName) {
		super();
		this.playerName = playerName;
	}
	public Team(int playerId) {
		super();
		this.playerId = playerId;
	}
}
*/

class DuplicateIdException extends Exception{

	public DuplicateIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateIdException(String message) {
		super(message);
		
		
		// TODO Auto-generated constructor stub
	}

	public DuplicateIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
