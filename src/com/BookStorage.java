
package com;

import java.util.ArrayList;

public class BookStorage {

    /**
     * BookStorage is a representation of a single linked list whose element is 
     * a instance of BookIndex class.
     */
    
    private BookIndex firstIndex = null;
    
    /**
     * In this library model, we allows only one storage to storing all existing books,
     * that means the storage is unique and sole. No other classes are allowed to create
     * any instance of the storage. This is a example of Singleton design pattern.
     */
    private static final BookStorage storageInstance = new BookStorage();
    
    private BookStorage() { }
    
    public static BookStorage getStorage() {
        return storageInstance;
    }
    
    public boolean isEmpty() { return firstIndex == null; }
    
    public void append(BookIndex nextIndex) {
        if (isEmpty()) {
            this.firstIndex = nextIndex;
        } else {
            this.lastIndex().setNext(nextIndex);
        }
    }
    
    public void insert(BookIndex nextIndex) {
        if (isEmpty()) {
            this.firstIndex = nextIndex;
        } else {
            nextIndex.setNext(this.firstIndex);
            this.firstIndex = nextIndex;
        }
    }
    
    public BookIndex get(int position) {
        int counter = 0;
        BookIndex t = firstIndex;
        while (counter != position) {
            t = t.next();
            counter += 1;
        } 
        return t;
    }
    
    public void insert(BookIndex index, int position) {
        int counter = 0;
        BookIndex current;
        BookIndex next;
        if (position >= getSize()) {
            insert(index);
        } else {
            append(index);
        }
    }
    
    public int getSize() {
        int counter = 0;
        for (BookIndex index = firstIndex; index != null; index = index.next()) {
            counter += 1;
        }
        return counter;
    }
    
    public BookIndex lastIndex() {
        BookIndex index;
        for (index = firstIndex; index.next() != null; index = index.next()) {
            //travelling
        }
        return index;
    }
    
    public void delete(int position) {
        BookIndex prevIndex;
        BookIndex currentIndex = get(position);
        for (prevIndex = firstIndex; prevIndex.next() != currentIndex; prevIndex = prevIndex.next()) {
            //travelling
        }
        prevIndex.setNext(currentIndex.next());
        currentIndex.setNext(null);     //garbage collector will do it well
    }
    
    public void deleteAll() {
        this.firstIndex = null;
    }
    
    public int findBook(String name) {
        int result = -1;
        int counter = 0;
        for (BookIndex index = firstIndex; index != null; index = index.next()) {
            if (index.getBookInstance().getName().equals(name)) 
                result = counter;
            counter += 1;
        }
        return result;
    }
    
    public ArrayList<BookIndex> toArrayList() {
        final int arraySize = getSize();
        ArrayList<BookIndex> list = new ArrayList();
        for (int i = 0; i < arraySize; i++) {
            list.add(get(i));
        }
        list.sort(
            (BookIndex current, BookIndex compIndex) -> {
                String name = current.getBookInstance().getName();
                String compName = compIndex.getBookInstance().getName();
                return name.compareTo(compName);
            }  
        );
        return list;
    }
    
}
