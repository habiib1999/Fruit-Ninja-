package CommandPattern;

public class LoadmaxCommand implements Command {
    private Receiver receiver;
	public LoadmaxCommand(Receiver receiver) {
		this.receiver=receiver;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute() {
		((File) receiver).loadMax();		
	}

}
