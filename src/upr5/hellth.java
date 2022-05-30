package upr5;

public class hellth extends ability
{
	protected int health;
	public hellth(entity[] obekti,int health) {
		super(obekti);
		this.health=health;
		setTsena(5);
	}

	@Override
	public boolean deistvie() {
		boolean heal=false;
		for(entity e: obekti) 
		{
			if(e.islive()) {
				e.heal(health);
				heal=true;
				}
		}
		return heal;
	}
	

}
