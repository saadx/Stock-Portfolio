package proj4fa15;

/**
 * <p>Title: ElementNotFoundException Class</p>
 *
 * <p>Description: Exception Class for use by all Container Classes</p>
 * 
 * <p>Author: Saad Ahmad</p>
 */

@SuppressWarnings("serial")
public class ElementNotFoundException extends RuntimeException
{
	/**
	 * Initializes an ElementNotFoundException storing an appropriate message
	 * along with the type of the collection (as specified by the user).
	 */
	public ElementNotFoundException(String collection)
	{
		super("The target element is not in this " + collection);
	}
}
