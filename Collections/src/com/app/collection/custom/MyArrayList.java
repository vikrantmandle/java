package com.app.collection.custom;

import java.util.List;

public class MyArrayList {
	
	private Object[]data;
	private int size;
	private int DEFAULT_CAPACITY=10;
	
	public MyArrayList() {
		data=new Object[DEFAULT_CAPACITY];
	}
	
	public void add(Object element) {
		ensureCapicity();
		data[size++]=element;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
        return  data[index];
    }

	private void ensureCapicity() {
		if(size==data.length) {
			int newCapacity=data.length*2;
			Object [] newObj= new Object[newCapacity];
			System.arraycopy(data, 0, newObj, 0, data.length);
			data=newObj;
		}
	}
	
	public void remove(int index) {
		  if (index < 0 || index >= size)
	            throw new IndexOutOfBoundsException("Index: " + index);
		  for (int i = index; i < size - 1; i++) {
	            data[i] = data[i + 1];
	        }
		  data[--size] = null;
	}
	  @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("[");
	        for (int i = 0; i < size; i++) {
	            sb.append(data[i]);
	            if (i < size - 1) sb.append(", ");
	        }
	        sb.append("]");
	        return sb.toString();
	    }
}
