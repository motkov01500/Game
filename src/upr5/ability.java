package upr5;

public abstract class ability 
{
	protected int tsena;
	private int to4ki;
	public int getTsena() {
		return tsena;
	}
	public void setTsena(int tsena) {
		this.tsena = tsena;
	}
	protected entity[] obekti;
	public ability(entity[] obekti)
	{
		this.obekti=obekti;
	}
	public boolean napravi() 
	{
		if(to4ki>=tsena&&deistvie()) 
		{
			to4ki=to4ki-tsena;
			return true;
		}
		return false;
	}
	public void plTo4ki(int to4ki) 
	{
		this.to4ki=this.to4ki+to4ki;
	}
	public abstract boolean deistvie();

}
