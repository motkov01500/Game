package upr5;

public class boss extends entity{
	private entity[] mi6eni= {};
	//private double areachans;
	public boss(String name, int helth, double speed, int dmg, double critical, double dodge, int stamina) {
		super(name, helth, speed, dmg, critical, dodge, stamina);
		//this.areachans=areachans;
	}
	public void addtarget(entity e) 
	{
		entity[] tar= new entity[mi6eni.length+1];
		for(int i=0;i<mi6eni.length;i++) 
		{
			tar[i]=mi6eni[i];
		}
		tar[tar.length-1]=e;
		mi6eni=tar;
	}
	private int broitargets() 
	{
		int broi=0;
		for(entity e:mi6eni) 
		{
			if(e.islive())
				broi++;
		}
		return broi;
		/*entity[] tar= new entity[broi];
		for(entity e:mi6eni) 
		{
			if(e.helth>0) 
			{
				broi--;
				tar[broi]=e;
			}
		}
		mi6eni=tar;*/
		
	}
	@Override
	public boolean vurvi() {
		for(entity e:mi6eni) 
		{
			if(e.islive())
				return helth>0;
		}
		return false;
	}

	@Override
	public void ataka() {
		int atakuvan=chans.nextInt(broitargets());
		for(entity e:mi6eni) 
		{
			if(e.islive()) 
			{
				if(atakuvan==0) 
				{
					abil.plTo4ki(e.hit(dmg, critical,name));
					break;
				}
				atakuvan--;
			}
		}
	}
}
