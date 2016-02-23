package proj4fa15;

/**
 * <p>Title: InvalidSaleException Class</p>
 *
 * <p>Description: Exception Class for use by all Container Classes</p>
 * 
 * <p>Author: Saad Ahmad</p>
 */

@SuppressWarnings("serial")
public class InvalidSaleException extends RuntimeException
{
	/**
	 * Initializes an InvalidSaleException storing an appropriate message
	 * along with the type of the sale (as specified by the user).
	 */
	public InvalidSaleException(String sale)
	{
		super (sale);
	}
}
