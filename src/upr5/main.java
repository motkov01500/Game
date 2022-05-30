package upr5;

public class main {

	public static void main(String[] args) {
		player t1= new player("p1",50,4,3,10,30,10);
		player t3= new player("p2",50,4,3,10,30,10);
		boss t2= new boss("boss",100,2,10,10,30,10);
		t1.setMi6ena(t2);
		t3.setMi6ena(t2);
		t2.addtarget(t1);
		t2.addtarget(t3);
		entity[] e= {t1,t3};
		t1.setAbility(new hellth(e,10) );
		t3.setAbility(new nekromant(e,20) );
		t2.setAbility(new areahit(e,5,20));
		t1.start();
		t2.start();
		t3.start();

	}

}
