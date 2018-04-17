import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * @author jacek blady 228140
 * Result class
 * Used for saving the results of tasks performed by workers
 * implements Serializable
 */
public class Result implements Serializable
{
	/*
	 * Constant value that specifies the serialization version (long)
	 */
	private static final long serialVersionUID = 102L;
	
	/*
	 * String value describing the result, usually specifies the operation giving the result (String)
	 */
	String result_description;
	
	/*
	 * Values of the result of an operation (List<Integer>)
	 */
	public List<Integer> result;
	
	/**
	 * Default constructor of the Task class.
	 */
	public Result()
	{
		result_description = "brak";
		result = new ArrayList<Integer>();
	}
}
