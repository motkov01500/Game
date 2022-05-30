package upr5;

public class areahit extends ability{
	private int mindamage,maxdamage;
	public areahit(entity[] obekti,int mindamage,int maxdamage) {
		super(obekti);
		setTsena(3);
		this.mindamage=mindamage;
		this.maxdamage=maxdamage;
	}

	@Override
	public boolean deistvie() {
		for(entity e:obekti)
		{
			if(e.islive()) 
			{
				int damage=(int)(mindamage+Math.random()*(maxdamage-mindamage));
				e.dealDamage(damage);
				System.out.println("area hit   "+e.getname()+"   HP-"+damage+"   HP "+e.helth);
			}
		}
		return false;
	}

}
