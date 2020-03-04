package com.sourceit.hw.num9;

import java.util.*;

public class Demo{

	public static void main(String[] args) {
		MyList<Object> myList = new DefaultMyList();
		
		myList.add(2);
		myList.add(5);
		myList.add(3);
		MyList<Object> c = new DefaultMyList();
		c.add(5);
		c.add(3);
		c.add(2);
		System.out.println(myList.containsAll(c));
		System.out.println(myList.contains(5));
		System.out.println(myList.contains(7));
		myList.add(5);
		myList.add(5.265);
		myList.add(5);
		myList.add(new int[5]);
		myList.add(new ArrayList<String>());
		System.out.println(myList.size());
		
		myList.clear();
		System.out.println("--------");
		DefaultMyList coll = new DefaultMyList ();
		coll.add(5);
		coll.add(6);
		coll.add(7);
		coll.add(8);
		
		
		for (Object a : coll) {
			System.out.println(a);
		}
		System.out.println("--------");
		    Iterator<Object> it = coll.iterator();
			while (it.hasNext()) {
			System.out.println(it.next());
			}
	}

}