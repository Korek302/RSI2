import java.io.Serializable;
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
	 * Final long value that specifies the serialization version
	 */
	private static final long serialVersionUID = 102L;
	
	/*
	 * String value describing the result, usually specifies the operation giving the result
	 */
	String result_description;
	
	/*
	 * Double value of the result of an operation
	 */
	public List<Integer> result;
}
