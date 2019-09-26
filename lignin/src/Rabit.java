
public class Rabit implements Runnable {
	
	private String name;
	
	public Rabit()
	{
		System.out.println("Generic Rabit");
	}
	
	public Rabit(String name)
	{
		this.name = name;
		System.out.println("Rabit constructed"+name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
