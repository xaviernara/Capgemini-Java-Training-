package day4_25March_111245;
import java.util.*;
/**
 * Assignment 19
 *
 */
public class MatchOutcome {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator());
		System.out.println("Enter number of matches");
		int matchNumber = scan.nextInt();
		Match22BO2 matchBO = new Match22BO2();
		Match22[] matchList = new Match22[matchNumber];
		
		for(int i = 0; i<matchList.length;i++){
			System.out.println("Enter match " + (i+1) +" details:");
			System.out.println("Enter match date");
			String matchDate = scan.next();
			System.out.println("Enter team one");
			String teamOneName = scan.next();
			System.out.println("Enter team two");
			String teamTwoName = scan.next();
			System.out.println("Enter venue");
			String venue = scan.next();
			System.out.println("Enter status");
			String status = scan.next();
			System.out.println("Enter winner Team");
			String winnerTeam = scan.next();
			Outcome outcome = new Outcome(status,winnerTeam);
			matchList[i] = new Match22(matchDate,teamOneName,teamTwoName,venue,outcome);
			
		}
		
		boolean menuContinue = true;
		while (menuContinue) {
			System.out.println("Menu");
			System.out.println("1.View match details");
			System.out.println("2.Filter match details with outcome status"); 
			System.out.println("3.Filter match details with outcome winner team");
			System.out.println("4.Exit");
			
			System.out.println("Enter your choice");
			int menuChoice = scan.nextInt();
			
			System.out.println("Match Details");
			
			switch(menuChoice){
			
			case 1 :
				System.out.println("Date Team1 Team2 Venue Status Winner");
				matchBO.printAllMatch22Details(matchList);
				break;
			
			case 2 :
				System.out.println("Enter outcome status");
				String outcomeStatus = scan.next();
				System.out.println("Date Team1 Team2 Venue Status Winner");
				matchBO.printMatch22DetailsWithOutcomeStatus(matchList, outcomeStatus);
				break;
			case 3 :
				System.out.println("Enter outcome winner team");
				String winnerTeam = scan.next();
				System.out.println("Date Team1 Team2 Venue Status Winner");
				matchBO.printMatch22DetailsWithOutcomeWinnerTeam(matchList, winnerTeam);
				break;
			
			case 4:
				System.out.println("Thank You");
				menuContinue = false;
			}
			
		}
		
		scan.close();
		
	}

}

class Outcome {

	private String status;
	private String winnerTeam;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(String winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	public Outcome(String status, String winnerTeam) {
		super();
		this.status = status;
		this.winnerTeam = winnerTeam;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s", status, winnerTeam);
	}

	
}

class Match22 {

	private String date;
	private String teamOne;
	private String teamTwo;
	private String venue;
	private Outcome outcome;

	public Match22(String date, String teamOne, String teamTwo, String venue, Outcome outcome) {
		super();
		this.date = date;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.venue = venue;
		this.outcome = outcome;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-30s", date, teamOne, teamTwo, venue, outcome);
	}

}

class Match22BO2 {

	// This method is used to print the details of all Match22es
	public void printAllMatch22Details(Match22[] Match2List) {

		for (Match22 Match22 : Match2List) {

			System.out.println(Match22.toString());
		}

	}

	/*
	 * In this method, display all Match22 details of a specific status(from
	 * Outcome). If the status being searched is not found in the list, display
	 * the message “Status not found”. Refer sample output
	 * 
	 */
	public void printMatch22DetailsWithOutcomeStatus(Match22[] Match22List, String outcomeStatus) {

		
		for (Match22 match : Match22List) {

			if (outcomeStatus.equalsIgnoreCase(match.getOutcome().getStatus())) {

				System.out.println(match.toString());
			}

		}

		System.out.println("Status not found");

	}

	/*
	 * In this method, display all Match22 details of a specific winner
	 * team(from Outcome). If the winnerTeam being searched is not found in the
	 * list, display the message “Winner Team not found”. Refer sample output.
	 * 
	 */

	public void printMatch22DetailsWithOutcomeWinnerTeam(Match22[] Match22List, String outcomeWinnerTeam) {

		for (Match22 match : Match22List) {

			if (outcomeWinnerTeam.equalsIgnoreCase(match.getOutcome().getWinnerTeam())) {

				System.out.println(match.toString());
			}

		}

	}

}
