package CommandPattern;

import filesXML.MyDomLoader;
import filesXML.MyDomSaver;

public class File implements Receiver {

	public File() {
		// TODO Auto-generated constructor stub
	}
	
	public void save() 
	{
		//IMP OF SAVING 
		MyDomSaver saver = new MyDomSaver();
		saver.Save();
		//IMP OF SAVING 
		//System.out.println("SAVING FILE Here NOW !!");
	}
	public void saveMax() 
	{
		MyDomSaver saver = new MyDomSaver();
		saver.SaveMax();

		//IMP OF SAVING max
		//System.out.println("LOADING FILE Here NOW !!");
	}
	public void load() 
	{
		MyDomLoader loader = new MyDomLoader();
		loader.Load();

		//IMP OF loading  
		//System.out.println("LOADING FILE Here NOW !!");
	}
	public void loadMax() 
	{
		MyDomLoader loader = new MyDomLoader();
		loader.LoadMax();

		//IMP OF loading max 
		//System.out.println("LOADING FILE Here NOW !!");
	}
	 
	 
}
