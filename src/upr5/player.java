package upr5;

import java.util.Random;

public class player extends entity{
	
	private entity mi6ena;
	public entity getMi6ena() {
		return mi6ena;
	}

	public void setMi6ena(entity mi6ena) {
		this.mi6ena = mi6ena;
	}

	public player(String name, int helth, double speed, int dmg, double critical, double dodge, int stamina) {
		super(name, helth, speed,dmg, critical, dodge, stamina);
	}
	@Override
	public boolean vurvi() {
		return helth>0&&mi6ena.islive();
	}

	@Override
	public void ataka() {
		abil.plTo4ki(mi6ena.hit(dmg, critical,name));
	}

}
