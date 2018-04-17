import java.io.Serializable;
import java.util.List;

/**
 * @author jacek blady 228140
 *
 * Input class used to create object containing input informations
 * Implements Serializable
 */
public class Input implements Serializable
{
	/**
	 * Constant value that specifies the serialization version (long)
	 */
	private static final long serialVersionUID = -8916958169168312522L;
	
	/*
	 * Parametrized constructor of the Input class
	 * @param - operation - String - text value specifying the operation of a task
	 * @param - list - List<Integer> - list of input values
	 */
	public Input(String operation, List<Integer> list)
	{
		this.operation = operation;
		this.list = list;
	}
	
	/*
	 * Text value specifying the operation of a task (String)
	 */
	String operation;
	
	/*
	 * List of values used for the task (List<Integer>)
	 */
	List<Integer> list;
}
