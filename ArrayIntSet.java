package homework;

import stdlib.StdOut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class ArrayIntSet {
	private int[] data;
	private int size;

	public ArrayIntSet(int capacity) {
		this.data = new int[capacity];//capacity is max amount of elements
		this.size = 0;//number of elements in array
		//this.contains(0);//test
	}

	public int size() {
		return size;
	}

	public boolean contains(int i) {
		for (int index = 0; index < size; index++) {
			if (data[index] == i)
				return true;
		}
		return false;
	}

	// Ignore this equals method. Used for testing.
	public boolean equals(Object otherObject) {
		ArrayIntSet other = (ArrayIntSet) otherObject;
		return this.equals(other);
	}

	/***************************** NEW METHODS ************************************/

	/**
	 * Adds <code>element</code> to this set if it is not already present and
	 * returns <code>true</code>. If <code>element</code> is already present, the
	 * set is unchanged and <code>false</code> is returned.
	 * 
	 * @param element the element to be added
	 * @return <code>true</code> if the element was added and <code>false</code>
	 *         otherwise.
	 */
	public boolean addElement(int element) {
		// Replace the line below with your answer
		if (contains(element)) {// if element is present return false
			return false;
		}else {
		data[size++] = element;// increase size if array does not contain element

		return true;
		}
	}

	/**
	 * Removes an element from the set.
	 * 
	 * @param element the element to be removed
	 * @return <code>true</code> if the element was removed and <code>false</code>
	 *         otherwise.
	 */
	public boolean removeElement(int element) {
		// Replace the line below with your answer

		for (int i = 0; i < size; i++) {// for each element in the array data
			if (data[i] == element) {// if element is found
				data[i] = data[size - 1];// replace the element with last element
				size--;//decrease size by 1
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if <code>this</code> and <code>other</code> have the same
	 * elements and false otherwise.
	 * 
	 * @param other the set to compare against for equality
	 * @return true if <code>this</code> and <code>other</code> have the same
	 *         elements and false otherwise.
	 */
	public boolean equals(ArrayIntSet other) {
		// Replace the line below with your answer
		if (size != other.size) {// if if the sizes dont match return false
			return false;
		}
		for (int i = 0; i < size; i++) {//for each element in data
			if (other.contains(data[i])) {//if the element is also in other, return true
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes the set so that it is equal the union of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to union with
	 */
	public void union(ArrayIntSet other) {// or
		// Replace the line below with your answer
		for (int i = 0; i < other.size; i++) {// for all elements in other
			addElement(other.data[i]);// add the element to data
		}
	}

	/**
	 * Changes the set so that is equal the intersection of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to intersect with
	 */
	public void intersect(ArrayIntSet other) {// and
		// Replace the line below with your answer
		for (int i = size; i >= 0; i--) {//for each element in data
			if (!other.contains(data[i])) {// if the current element in the array is not in the other array
				removeElement(data[i]);// remove it
			}
		}
	}

	public static void main(String[] args) {
		
	}
}
