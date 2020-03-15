package CommandPattern;

public class SavemaxCommand implements Command {
    private Receiver receiver;
	public SavemaxCommand(Receiver receiver) {
		this.receiver=receiver;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute() {
		((File) receiver).saveMax();
	}

}
