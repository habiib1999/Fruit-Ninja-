package filesXML;

import java.io.IOException;

import javax.swing.text.GapContent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import logic.GameActions;
import logic.GameController;

import org.w3c.dom.Element;

public class MyDomLoader {
	int scoreNum ;
	int maxScore;
	int remainingLives;
	public  void LoadMax () {
		try {
			GameController gameController=GameController.getInstance();;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
			Document doc =builder.parse("inputFile2.xml");

			//working in maxScore
			Element maxScoreElement = (Element) doc.getElementsByTagName("maxScore").item(0);		
			gameController.setMaxScore(Integer.valueOf(maxScoreElement.getAttribute("maxScore")));
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public  void Load () {
		try {
			GameController gameController=GameController.getInstance();;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
			Document doc =builder.parse("inputFile1.xml");
			
			
			
			//working in score
			Element scoreElement = (Element) doc.getElementsByTagName("score").item(0);		
			gameController.setScoreNum(Integer.valueOf(scoreElement.getAttribute("score")));
			
			//working in maxScore
			Element maxScoreElement = (Element) doc.getElementsByTagName("maxScore").item(0);		
			gameController.setMaxScore(Integer.valueOf(maxScoreElement.getAttribute("maxScore")));
			
			//working in remainingLives
			Element remainingLivesElement = (Element) doc.getElementsByTagName("remainingLives").item(0);		
			gameController.setRemainingLives(Integer.valueOf(remainingLivesElement.getAttribute("remainingLives")));
			
			//working in remainingTime
			Element remainingTimeElement = (Element) doc.getElementsByTagName("remainingTime").item(0);		
			gameController.setRemainingTime((Integer.valueOf(remainingTimeElement.getAttribute("remainingTime"))));
			
			//working in remainingTime
			Element gameTypeElement = (Element) doc.getElementsByTagName("gameType").item(0);		
			gameController.setGameType(gameTypeElement.getAttribute("gameType"));
			
			System.out.println("scoreNum"+gameController.getScoreNum());
			System.out.println("maxScore"+gameController.getMaxScore());
			System.out.println("remainingLives"+gameController.getRemainingLives());
			System.out.println("remainingTime"+gameController.getRemainingTime());
			System.out.println("gametype"+gameController.getGameType());

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
