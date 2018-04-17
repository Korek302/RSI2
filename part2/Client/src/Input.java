import java.io.Serializable;
import java.util.List;

public class Input implements Serializable
{
	private static final long serialVersionUID = -8916958169168312522L;
	
	public Input(String operation, List<Integer> list)
	{
		this.operation = operation;
		this.list = list;
	}
	
	String operation;
	List<Integer> list;
}
