package com.sourceit.hw.num9;

import java.util.Iterator;

public class DefaultMyList<O> implements MyList {
	private int capacity = 5;
	private Object [] arr = new Object[capacity];
	private int count = 0;
	
	@Override
	public void add(Object e) {
		// TODO Auto-generated method stub
		arr[count] = e;
		if(count == capacity - 1) {
			capacity *= 2;
			Object [] newArr = new Object[capacity];
			System.arraycopy(arr, 0, newArr, 0, count);
			arr = newArr;
		}
		count++;
	}

	@Override
	public void clear() {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = null;
		}
		capacity = 5;
		count = 0;
	}

	@Override
	public boolean remove(Object o) {
		for(int i = count; i > 0; i--) {
			if(arr[i].equals(o)) {
				arr[i] = null;
				for(int j = i + 1; j < count; i++) {
					arr[i] = arr[j];
				}
				arr[count] = null;
				count--;
				if((count*2 <= capacity) && (count > 0)) {
					capacity /= 2;
					Object [] newArr = new Object[capacity];
					System.arraycopy(arr, 0, newArr, 0, count);
					arr = newArr;
				}
				return true;
			}
		}
		return false;
		
	}

	@Override
	public Object[] toArray() {
		return arr;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean contains(Object o) {
		for(int i = 0; i < count; i++) {
			if(arr[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	
	@Override
	public boolean containsAll(MyList c) {
		int k = 0;
		for(int i = 0; i < count; i++) {
			if(c.contains(arr[i])) {
				k++;
			}else
				return false;
		}
		if(k == count) {
			return true;
		}else
		    return false;
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("{");
		String res = "";
		for(int i = 0; i < count; i++) {
			str.append('[').append(arr[i]).append("], ");
		}
		res += str.toString();
		return res; 
	}
	public Iterator<Object> iterator() {
		return new IteratorImpl();
		}

	private class IteratorImpl implements Iterator<Object> {
		int k = 1;
		int iter = 0;
		@Override
		public boolean hasNext() {
			return iter != count;
		}

		@Override
		public Object next() {
			k = 0;
		    return arr[iter++];
		}
		
		public void remove() { 
			if(k == 1) {
				 throw new IllegalStateException();
			}
			for(int j = iter; j < count; j++) {
				arr[j] = arr[j++];
			}
			arr[count] = null;
			count--;
			k = 1;
		}


	}
}
