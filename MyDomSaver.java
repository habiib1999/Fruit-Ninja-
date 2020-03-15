package filesXML;
import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import logic.GameController;
public class MyDomSaver
{
	
	public static Element creatElement (Document doc ,String elementTagName)
    {
   	 //creat child element 
   	 try {
   		 Element element = doc.createElement(elementTagName);
      	 return element;
      	 }
   	 catch (Exception e) 
   	 {
   		 return null;
   	 }
   	}
	public static Attr addAttribute (Document doc ,String AttributeTag, String AttributeValue)
	{

   	// setting attribute to element
    try {    	Attr attr = doc.createAttribute(AttributeTag);
            attr.setValue(AttributeValue);
            return attr;  	 

    }catch (Exception e) {
		// TODO: handle exception
    	return null;
	}	
	
    }
	public static DOMSource writeInXML (Document doc,String fileName )
	{
		
		try {
			// write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File(fileName));
	         transformer.transform(source, result);
		}
		catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public static void SaveMax()
	{
		try {
			//new File
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
	        Document doc = builder.newDocument();
			GameController gameController=GameController.getInstance();

	        //parent (root)
			Element Game = doc.createElement("game");
	        doc.appendChild(Game);
	        
	       
		         
		       //highest score
		         Element maxScoreElement = doc.createElement("maxScore");
		         maxScoreElement.setAttribute("maxScore", String.valueOf(gameController.getMaxScore()));
		         Game.appendChild(maxScoreElement);
		         
		     
	 		   MyDomSaver.writeInXML(doc,"inputFile2.xml");	         
 		}
		catch (Exception e) {}
	}
	public static void Save()
	{
		try {
			//new File
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
	        Document doc = builder.newDocument();
			GameController gameController=GameController.getInstance();

	        //parent (root)
			Element Game = doc.createElement("game");
	        doc.appendChild(Game);
	        
	        //adding childs
		  
		       //score
		         Element scoreElement = doc.createElement("score");
		         scoreElement.setAttribute("score", String.valueOf(gameController.getScoreNum()));
		         Game.appendChild(scoreElement);
		         
		       //highest score
		         Element maxScoreElement = doc.createElement("maxScore");
		         maxScoreElement.setAttribute("maxScore", String.valueOf(gameController.getMaxScore()));
		         Game.appendChild(maxScoreElement);
		         
		      //remainingLives
	            Element remainingLivesElement = doc.createElement("remainingLives");
	            remainingLivesElement.setAttribute("remainingLives", String.valueOf(gameController.getRemainingLives()));
	            Game.appendChild(remainingLivesElement);
	        
	            //remainingTime
	            Element remainingTimeElement = doc.createElement("remainingTime");
	            remainingTimeElement.setAttribute("remainingTime", String.valueOf(gameController.getRemainingTime()));
	            Game.appendChild(remainingTimeElement);
	        
	          //game type
		         Element gameTypeElement = doc.createElement("gameType");
		         gameTypeElement.setAttribute("gameType", gameController.getGameType());
		         Game.appendChild(gameTypeElement);
	 		   MyDomSaver.writeInXML(doc,"inputFile1.xml");	         
 		}
		catch (Exception e) {}
	}
	
}
