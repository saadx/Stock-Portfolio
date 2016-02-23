package proj4fa15;

/**
 * ListADT.java       
 * Defines the interface to a general list collection. Specific
 * types of lists will extend this interface to complete the
 * set of necessary operations.
 * 
 * @author Saad Ahmad
 */
public interface ListADT<E>
{
	/**  Removes and returns the first item from this list. */
	public E removeFirst ();

	/**  Removes and returns the last item from this list. */
	public E removeLast ();

	/**  Removes and returns the specified item from this list. */
	public E remove (E item);

	/**  Returns a reference to the first item in this list. */
	public E first ();

	/**  Returns a reference to the last item in this list. */
	public E last ();

	/**  Returns true if this list contains the specified target element. */
	public boolean contains (E target);

	/**  Returns true if this list is empty. */
	public boolean isEmpty();

	/**  Returns the number of items in this list. */
	public int size();

	/**  Returns a string representation of this list. */
	public String toString();
}
