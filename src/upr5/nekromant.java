package upr5;

public class nekromant extends ability{

	private int sethealth;
	public nekromant(entity[] obekti,int sethealth) {
		super(obekti);
		setTsena(5);
		this.sethealth=sethealth;
	}

	@Override
	public boolean deistvie() {
		for(entity e: obekti) 
		{
			if(!e.islive()) {
				e.heal(sethealth);
				new Thread(e).start();
				System.out.println(e.name+" reseracted");
				return true;
				}
		}
		return false;
	}

}
