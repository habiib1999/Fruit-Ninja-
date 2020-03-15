package CommandPattern;

public class RemoteContoller {
	private Command command ;
	
	public RemoteContoller() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
 
	public void pressButton ()
	{
		command.excute();
	}

	

}
