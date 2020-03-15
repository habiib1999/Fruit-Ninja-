package CommandPattern;

public class SaveCommand implements Command {
    private Receiver receiver;
	public SaveCommand(Receiver receiver) {
		this.receiver=receiver;

		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute() {
       ((File) receiver).save() ;		
	}

}
