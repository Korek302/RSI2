import java.util.Arrays;

public class MyThread extends Thread
{
	private Thread t;
	private int[] list;
	
	public MyThread(int[] list) 
	{
		this.list = list;
	}
	
	@Override
	public void run() 
	{
		Arrays.sort(list);
	}
	
	public void start () 
	{
		  if (t == null) 
		  {
		     t = new Thread (this);
		     t.start ();
		  }
	}
	
	public int[] getList()
	{
		return list;
	}
}
