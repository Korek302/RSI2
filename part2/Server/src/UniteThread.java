import java.util.Arrays;
import java.util.List;

public class UniteThread extends Thread
{
	private Thread t;
	private List<int[]> listOfLists;
	int[] united;
	int numOfLists;
	int listSize;
	
	public UniteThread(List<int[]> listOfLists)
	{
		this.listOfLists = listOfLists;
		this.listSize = listOfLists.get(0).length;
		numOfLists = listOfLists.size();
		united = new int[numOfLists*listSize];
	}

	@Override
	public void run() 
	{
		for(int i = 0; i < numOfLists - 1; i++)
		{
			System.arraycopy(listOfLists.get(i), 0, united, i * listSize, listSize);
		}
		Arrays.sort(united);
	}
	
	public void start () 
	{
		  if (t == null) 
		  {
		     t = new Thread (this);
		     t.start ();
		  }
	}
	
	public int[] getUnited()
	{
		return united;
	}
}
