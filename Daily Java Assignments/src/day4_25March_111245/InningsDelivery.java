import java.util.Scanner;

public class InningsDelivery {
    public static void main(String args[]) {
       
       Scanner scan = new Scanner(System.in)..useDelimiter(System.lineSeparator());
       System.out.println("Enter the number of innings");
       int inningsNumber = scan.nextInt();
       
       Innings[] inningsList = new Innings[inningsNumber];
       InningsBO inningsBO = new InningsBO();
       for(int i = 0; i< inningsList.length;i++ ){
    	   System.out.println("Enter innings "+(i+1) + "details");
    	   String inningsDetails = scan.next();
    	   inningsList[i] = inningsBO.createInnings(inningsDetails);
    			
       }
       
       System.out.println("Enter the number of deliveries");
       int deliveriesNumber = scan.nextInt();
       DeliveryBO deliveryBO = new DeliveryBO();
       Delivery[] deliveriesList = new  Delivery[deliveriesNumber];
       
       for(int i = 0; i< deliveriesList.length;i++ ){
    	   System.out.println("Enter innings "+(i+1) + "details");
    	   String deliveriesDetails = scan.next();
    	   deliveriesList[i] = deliveryBO.createDelivery(deliveriesDetails, inningsList)
       }
       
       
    	 
    	   
    }
}

class Innings {
    
   private Long inningsNumber;
   private String battingTeam;
    
    public String getBattingTeam(){
        return battingTeam;
    }
    public void setBattingTeam(String aBattingTeam){
       aBattingTeam = this.battingTeam; 
    }
    
    public Long getInningsNumber(){
        return inningsNumber;
    }
    
    public void setInningsNumber(Long aInningsNumber){
        aInningsNumber = this.inningsNumber;
    }
    public Innings (Long aInningsNumber, String aBattingTeam){
       this.inningsNumber = aInningsNumber;
       this.battingTeam = aBattingTeam ;
    }
    
}

class InningsBO{
    
    public Innings createInnings (String data){
        
        String[] inningsArray = data.split(",");
        String battingTeam = inningsArray[1];
        Long inningsNumber = new Long (Long.parseLong(inningsArray[0]));
        Innings innings = new Innings (inningsNumber,battingTeam);
        return innings;
    }
 
}

class Delivery{
    
    private Long deliveryNumber;
    private String batsman;
    private String bowler;
    private Long runs;
    private Long inningsNumber;
    private Innings innings;
    
    public Long getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(Long deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public String getBatsman() {
		return batsman;
	}

	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	public String getBowler() {
		return bowler;
	}

	public void setBowler(String bowler) {
		this.bowler = bowler;
	}

	public Long getRuns() {
		return runs;
	}

	public void setRuns(Long runs) {
		this.runs = runs;
	}

	public Long getInningsNumber() {
		return inningsNumber;
	}

	public void setInningsNumber(Long inningsNumber) {
		this.inningsNumber = inningsNumber;
	}

	public Innings getInnings() {
		return innings;
	}

	public void setInnings(Innings innings) {
		this.innings = innings;
	}

	
    
    public Delivery(Long aDeliveryNumber, String aBatsman,String aBowler,Long aRuns, Long aInningsNumber, Innings aInnings ){
        this.deliveryNumber = aDeliveryNumber;
        this.batsman= aBatsman;
        this.bowler = aBowler;
        this.runs = aRuns;
        this.inningsNumber = aInningsNumber;
        this.innings = aInnings;
    }
    
}


class DeliveryBO{
    
    /*
        In this method, parse the string data using split method
        defined in the String class and and construct a innings object.
    */
    
    public Delivery createDelivery(String data, Innings [] inningsList){
        String [] deliveryArray = data.split(",");
        Long deliveryNumber = new Long(Long.parseLong(deliveryArray[0]));
        String batsman = deliveryArray[1];
        String bowler = deliveryArray[2];
        Long runs = new Long(Long.parseLong(deliveryArray[3]));
        Long inningsNumber = new Long(Long.parseLong(deliveryArray[4]));
        
        for (Innings inning : inningsList){
            
            if(inning.getInningsNumber().equals(inningsNumber)){
                
                Delivery delivery = new Delivery(deliveryNumber,batsman,bowler,runs,inningsNumber,inning);
                return delivery;
            }
        }
    }
    
    /*
    
        In this method, find the innings to which a particular delivery belongs to.
    
    
    
    */
    
    public String findInningsNumber(Innings [] inningsList, long deliveryNumber){
        
        for (Innings inning : inningsList){
            
            if(inning.getInningsNumber().equals(deliveryNumber)){
                
                return inning.getInningsNumber().toString();
            }
        }
        
        return "Inning not found";
        
    }
}