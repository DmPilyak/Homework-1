package com.sourceit.hw.num9;

public interface MyList<Object> extends Iterable<Object> {
	void add(Object e); 
	void clear(); 
	boolean remove(Object o); 
	Object[] toArray(); 
	int size(); 
	boolean contains(Object o); 
	boolean containsAll(MyList c); 
	

}
