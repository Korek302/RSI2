import java.io.Serializable;

/*
 * @author jacek blady 228140
 * Result class
 * Used for saving the results of tasks performed by workers
 * implements Serializable
 */
public class ResultSort implements Serializable
{
	
	/*
	 * String value describing the result, usually specifies the operation giving the result
	 */
	String result_description;
	
	/*
	 * Double value of the result of an operation
	 */
	public int[] result;
}
