package upr5;

import java.util.Random;

public abstract class entity extends Thread{
	protected String name;
	protected int helth,maxhelth;
	protected double speed;
	protected int dmg;
	protected double critical;
	protected double dodge;
	protected int stamina;
	protected Random chans=new Random();
	protected ability abil;
	private boolean islive;
	public abstract boolean vurvi();
	public abstract void ataka();
	
	public entity(String name, int helth, double speed, int dmg, double critical, double dodge, int stamina) {
		islive=true;
		this.name = name;
		this.helth = helth;
		maxhelth=helth;
		this.speed = speed;
		this.dmg = dmg;
		this.critical = critical;
		this.dodge = dodge;
		this.stamina = stamina;
	}
	public int hit(int dmg,double critical,String attak) 
	{
		if(chans.nextInt(101)>dodge) 
		{
			if(chans.nextInt(101)<critical) 
			{
				dealDamage(dmg*2);
				System.out.println(attak+"  attak  "+name+"  critical  HP-"+dmg*2+"    HP="+helth);
				return 2;
			} else 
			{
				dealDamage(dmg);
				System.out.println(attak+"  attak  "+name+"    HP-"+dmg+"    HP="+helth);
				return 1;
			}
		}
		System.out.println(attak+"  attak  "+name+"    dodge"+"    HP="+helth);
		stamina++;
		return 0;
	}
	public boolean islive() {
		return islive;
	}
	@Override
	public void run() {
		islive=true;
		while(vurvi()) 
		{
			if(abil!=null) 
			{
				abil.napravi();
			}
			if(stamina>0) 
			{
				stamina--;
				ataka();
			}else 
			{
				System.out.println(name+"   po4iva");
				stamina++;
			}
			try {
				Thread.sleep((long)(1000/speed));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		islive=false;
		if(helth>0) {
			System.out.println(name +":YOU STUPPID LOOOOSER HAHAHAHA!!!");
		}else
		{
			System.out.println(name +":YOU CIIITAR NOOB!!!");
		}
	}
	public void setAbility(ability abil) {
		this.abil = abil;
	}
	public void dealDamage(int i) 
	{
		helth=Math.max(helth-i,0);
	}
	public String getname() {
		return name;
		}
	public void heal(int i) 
	{
		helth=Math.min(helth+i, maxhelth);
		System.out.println(name+" HP+"+i+"    HP="+helth);
	}

}
