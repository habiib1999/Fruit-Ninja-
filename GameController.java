package logic;

import java.util.ArrayList;

import CommandPattern.*;
import factoryPattern.*;

public class GameController implements GameActions {
	RemoteContoller contoller ;
	Receiver receiver ;
	Command saveCommand ;
	Command loadCommand;
	Command loadMaxCommand;



	Command saveMaxCommand;
	String gameType;
	Factory factory1 ;
	Factory factory2 ;
    ArrayList<GameObject> orangeList;
    ArrayList<GameObject> melonList;
    ArrayList<GameObject> appleList;
    ArrayList<GameObject> fatalList ;
    ArrayList<GameObject> dangerousList ;
    ArrayList<GameObject> bananaList;
    ArrayList<GameObject> greenAppleList;

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
    public ArrayList<GameObject> getAppleList() {
		return appleList;
	}

	public void setAppleList(ArrayList<GameObject> appleList) {
		this.appleList = appleList;
	}

	public ArrayList<GameObject> getFatalList() {
		return fatalList;
	}

	public void setFatalList(ArrayList<GameObject> fatalList) {
		this.fatalList = fatalList;
	}

	public ArrayList<GameObject> getDangerousList() {
		return dangerousList;
	}

	public void setDangerousList(ArrayList<GameObject> dangerousList) {
		this.dangerousList = dangerousList;
	}


	int scoreNum ;
	int maxScore;
	public int remainingLives;
	public int remainingTime;

	public int getScoreNum()
	{
		return scoreNum;
	}

    public void setScoreNum(int scoreNum) 
	{
		this.scoreNum = scoreNum;
	}


	public int getMaxScore() 
	{
		return maxScore;
	}


	public void setMaxScore(int maxScore)
	{
		this.maxScore = maxScore;
	}


	public int getRemainingLives() {
		return remainingLives;
	}


	public void setRemainingLives(int remainingLives) {
		this.remainingLives = remainingLives;
	}


	public int getRemainingTime() {
		return remainingTime;
	}


	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}


	private GameController() {
		this.contoller = new RemoteContoller();
        this.receiver= new File();
		this.loadCommand=new LoadCommand(receiver);
		this.saveCommand=new SaveCommand(receiver);
		this.loadMaxCommand=new LoadmaxCommand(receiver);
		this.saveMaxCommand=new SavemaxCommand(receiver);

		this.factory1= new FruitFactory();
		this.factory2=new BombFactory();
		this.melonList= new ArrayList<GameObject>();
		this.orangeList= new ArrayList<GameObject>();
		this.fatalList= new ArrayList<GameObject>();
		this.dangerousList= new ArrayList<GameObject>();
		this.appleList= new ArrayList<GameObject>();
		this.bananaList= new ArrayList<GameObject>();
		this.greenAppleList= new ArrayList<GameObject>();

		this.remainingLives=3;
		

		// TODO Auto-generated constructor stub
	}

	
	public ArrayList<GameObject> getBananaList() {
		return bananaList;
	}

	public void setBananaList(ArrayList<GameObject> bananaList) {
		this.bananaList = bananaList;
	}

	public ArrayList<GameObject> getGreenAppleList() {
		return greenAppleList;
	}

	public void setGreenAppleList(ArrayList<GameObject> greenAppleList) {
		this.greenAppleList = greenAppleList;
	}

	@Override
	public void ResetGame() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void saveGame() {
    contoller.setCommand(saveCommand);	
    contoller.pressButton();
	}

	@Override
	public void loadGame() {
	 contoller.setCommand(loadCommand);	
	 contoller.pressButton();
	}
	public void loadmaxGame() {
		 contoller.setCommand(loadMaxCommand);	
		 contoller.pressButton();
		}
	public void savemaxGame() {
		 contoller.setCommand(saveMaxCommand);	
		 contoller.pressButton();
		}

	/** Singletone !! **/
	 private static GameController instance1 = null;
	 public synchronized static GameController getInstance() 
	 {
		 
	        if (instance1 == null) {
	            instance1 = new GameController();
	        }
	        return instance1;
	  }



	@Override
	public GameObject createGameObject(String ObjectType,String factoryType) {
		
		if (factoryType==null) 		return (GameObject) ((BombFactory)factory2).getProduct(ObjectType);

		if(factoryType.equalsIgnoreCase("fruit"))
		
		return (GameObject) ((FruitFactory)factory1).getProduct(ObjectType);
		
		 return null;
    }


	public ArrayList<GameObject> getOrangeList() {
		return orangeList;
	}


	public void setOrangeList(ArrayList<GameObject> orangeList) {
		this.orangeList = orangeList;
	}


	public ArrayList<GameObject> getMelonList() {
		return melonList;
	}


	public void setMelonList(ArrayList<GameObject> melonList) {
		this.melonList = melonList;
	}
	 @Override
	    public void sliceObjects(GameObject gameObject) {
	    if( !gameObject.isSliced() )
	    {  gameObject.slice();
	    switch (gameObject.getObjectType()) {
	    
		case "Orange":
		case "Apple":
		case "Mellon":
		    scoreNum++;
		    if ( this.scoreNum >this.maxScore)
			{
				this.maxScore=this.scoreNum;
				this.savemaxGame();
			}
			break;

		case "GreenApple":
		case "Banana":
		    scoreNum=scoreNum+3;
		    if ( this.scoreNum >this.maxScore)
			{
				this.maxScore=this.scoreNum;
				this.savemaxGame();
			}
			break;
			
		case "Dangerous":
			this.remainingLives--;
			break;
			
		case "Fatal":
			this.remainingLives=0;

			System.out.println("END OF GAME FATAL BOMB CLICKED !!");
			break;

		default:
			break;
		}
	       
	    }
	    
    else throw new UnsupportedOperationException("sliced"); //To change body of generated methods, choose Tools | Templates.
	 }
	

}
