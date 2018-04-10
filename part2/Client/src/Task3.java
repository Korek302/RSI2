import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacek blady 228140
 *
 * Task class
 * implements ITask
 * Specifies tasks for workers
 */
public class Task3 implements ITask
{
	public int[] list;
	public List<int[]> listOfLists;
	int numOfDivision = 2;
	
	/**
	 * String operation
	 * Specifies operation of the task
	 */
	public String operation;
	
	/**
	 * Default constructor of the Task class.
	 */
	public Task3()
	{
		list = new int[5];
		operation = null;
		listOfLists = new ArrayList<int[]>();
	}
	
	
	public Task3(int[] list)
	{
		this.list = list;
		listOfLists = new ArrayList<int[]>();
		this.operation = "sort";
	}
	
	public List<int[]> splitEachItemIntoOwnArray2(int[] original) 
	{
	    List<int[]> result = new ArrayList<int[]>();
	    if (original == null) return result;

	    for (int i = 0; i < original.length; i++) 
	    {
	        result.add(Arrays.copyOfRange(original,i,i+1));
	    }

	    return result;
	}
	
	public List<int[]> splitArray(int[] array)
	{
		List<int[]> out = new ArrayList<int[]>();
		int sublistLength = array.length/numOfDivision;
		for(int i = 0; i < numOfDivision; i++)
		{
			int[] sublist = new int[sublistLength];
			System.arraycopy(array, i * sublistLength, sublist, 0, sublist.length);
			listOfLists.add(sublist);
		}
		return out;
	}
	
	/**
	 * Implementation of calculate method from ITask interface.
	 * returns Result type result
	 * throws RemoteException
	 */
	@Override
	public ResultSort calculateSort() throws RemoteException 
	{
		ResultSort out = new ResultSort();
		out.result_description = operation + this.getClass().getName();
		
		List<int[]> listOfLists = new ArrayList<int[]>();
		this.listOfLists = splitArray(list);
		List<MyThread> threads = new ArrayList<MyThread>();
		for(int i = 0; i < listOfLists.size(); i++)
		{
			threads.add(new MyThread(listOfLists.get(i)));
		}
		for(MyThread t : threads)
		{
			t.start();
		}
		for(MyThread t : threads)
		{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(MyThread t : threads)
		{
			listOfLists.add(t.getList());
		}
		UniteThread uniteThread = new UniteThread(listOfLists);
		uniteThread.start();
		try {
			uniteThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		out.result = uniteThread.getUnited();
		
		return out;
	}


	@Override
	public Result calculate() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
