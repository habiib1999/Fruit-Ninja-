package CommandPattern;

public class LoadCommand implements Command {
    private Receiver receiver;
	public LoadCommand(Receiver receiver) {
		this.receiver=receiver;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute() {
		((File) receiver).load() ;		
	}

}
