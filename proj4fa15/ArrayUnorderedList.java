package proj4fa15;

/**
 * <p>Title: ArrayUnorderedList.java</p> 
 * <p>Description: Represents an array implementation of an unordered list.</p>
 *
 * @author Saad Ahmad
 */
public class ArrayUnorderedList<E> extends ArrayList<E> implements UnorderedListADT<E>
{
	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayUnorderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 * 
	 * @param initialCapacity the initial size of the list as specified by the
	 *            user
	 */
	public ArrayUnorderedList(int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * addToFront -- Adds the specified item to the front of this list,
	 * expanding the capacity of this list if necessary.
	 * 
	 * @param item a reference to the item to be added
	 */
	public void addToFront(E item)
	{
		if (count == contents.length)
			expandCapacity();

		@SuppressWarnings("unchecked")
		E[] temp = (E[]) (new Object[contents.length]);
		temp[0] = item;
		for (int i = 0; i < count; i++)
		{
			temp[i + 1] = contents[i];
		}
		count++;
		contents = temp;
	}

	/**
	 * addToRear -- Adds the specified item to the rear of this list, expanding
	 * the capacity of this list if necessary.
	 * 
	 * @param item a reference to the item to be added
	 */
	public void addToRear(E item)
	{
		if (count == contents.length)
			expandCapacity();
		contents[count] = item;
		count++;
	}

	/**
	 * addAfter -- Adds the specified item after the specified target, expanding
	 * the capacity of this list if necessary. The original ordering of the
	 * items in the list will be maintained.
	 * 
	 * @param item a reference to the new item to be added
	 * @param target a reference to the target
	 * @throws an ElementNotFoundException if the target is not found
	 */
	public void addAfter(E item, E target)
	{
		if (count == contents.length)
			expandCapacity();

		int location = find(target);
		if (location == -1)
			throw new ElementNotFoundException("list");

		for (int i = count; i > location + 1; i--)
		{
			contents[i] = contents[i - 1];
		}
		contents[location + 1] = item;
		count++;
	}

	/**
	 * indexOf -- Uses the find method to locate the target.
	 * 
	 * @param target a reference to the target
	 * @return the index of the specified target if it is found; -1 if it is not
	 *         found
	 */
	public int indexOf(E target)
	{

		return find(target);
	}

	/**
	 * get -- Returns the item at the specified index. Index is validated to
	 * ensure that it is in the proper range (0 - (count-1)).
	 * 
	 * @param index the index of the item to be returned
	 * @return the item located at the specified index if it is found
	 * @throws an ArrayIndexOutOfBoundsException if the index is invalid or the
	 *             list is empty
	 */
	public E get(int index)
	{
		if ((index < 0) || (index > count - 1))
			throw new ArrayIndexOutOfBoundsException("get method: index is invalid");

		return (contents[index]);
	}

	/**
	 * set -- Stores newItem at the specified index, replacing the item
	 * currently stored there. Index is validated to ensure that it is in the
	 * proper range, (0 - (count-1)).
	 * 
	 * @param index the location where the new item is to be stored
	 * @param newItem a reference to the item to be stored
	 * @throws an ArrayIndexOutOfBoundsException if the index is invalid or the
	 *             list is empty
	 */
	public void set(int index, E newItem)
	{
		if ((index < 0) || (index > count - 1))
			throw new ArrayIndexOutOfBoundsException("set method: index is invalid");

		contents[index] = newItem;
	}

}
