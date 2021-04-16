
package com;

import java.util.ArrayList;

public class Market {
    
    MarketIndex firstIndex = null;
    
    private static final Market marketInstance = new Market();
    
    private Market() { }
    
    public static Market getMarket() {
        return marketInstance;
    }
    
    public boolean isEmpty() { return firstIndex == null; }
    
    public void append(MarketIndex nextIndex) {
        if (isEmpty()) {
            this.firstIndex = nextIndex;
        } else {
            this.lastIndex().setNext(nextIndex);
        }
    } 
    
    public void insert(MarketIndex nextIndex) {
        if (isEmpty()) {
            this.firstIndex = nextIndex;
        } else {
            nextIndex.setNext(this.firstIndex);
            this.firstIndex = nextIndex;
        }
    }
    
    public MarketIndex get(int position) {
        int counter = 0;
        MarketIndex t = firstIndex;
        while (counter != position) {
            t = t.next();
            counter += 1;
        } 
        return t;
    }
    
    public int indexOf(BookIndex bookIndex, Reader reader) {
        int counter = 0;
        for (MarketIndex index = firstIndex; index != null; index = index.next()) {
            if (index.getBookIndex().getIndex().equalsIgnoreCase(bookIndex.getIndex()) && 
                (index.getReader().getComparableCode() == reader.getComparableCode())) {
                break;
            }
            counter += 1;
        }
        return counter;
    }
    
    public MarketIndex lastIndex() {
        MarketIndex index;
        for (index = firstIndex; index.next() != null; index = index.next()) {
            //travelling
        }
        return index;
    }
    
    public void delete(int position) {
        MarketIndex prevIndex;
        MarketIndex currentIndex = get(position);
        
        if (currentIndex.equals(this.firstIndex)) {
            firstIndex = firstIndex.next();
            return;
        }
        for (prevIndex = firstIndex; prevIndex.next() != currentIndex; prevIndex = prevIndex.next()) {
            //travelling
        }
        prevIndex.setNext(currentIndex.next());
        currentIndex.setNext(null);     //garbage collector will do it well
    }
    
    public void insert(MarketIndex index, int position) {
        int counter = 0;
        MarketIndex current = firstIndex;
        MarketIndex next = current.next();
        if (position >= getSize()) {
            insert(index);
        } else {
            current = get(position);
            next = current.next();
            index.setNext(next);
            current.setNext(index);
        }
    }
    
    public int getSize() {
        int counter = 0;
        for (MarketIndex index = firstIndex; index != null; index = index.next()) {
            counter += 1;
        }
        return counter;
    }
    
    public ArrayList<MarketIndex> toArrayList() {
        final int arraySize = getSize();
        ArrayList<MarketIndex> list = new ArrayList();
        for (int i = 0; i < arraySize; i++) {
            list.add(get(i));
        }
        return list;
    }
    
    public ArrayList<MarketIndex> findByReader(Reader reader) {
        ArrayList<MarketIndex> list = new ArrayList();
        ArrayList<MarketIndex> marketList = toArrayList();
        for (MarketIndex index : marketList) {
            if (index.getReader().getComparableCode() == reader.getComparableCode()) {
                list.add(index);
            }
        }
        return list;
    }
    public ArrayList<MarketIndex> findByBook(Book book) {
        ArrayList<MarketIndex> list = new ArrayList();
        ArrayList<MarketIndex> marketList = toArrayList();
        for (MarketIndex index : marketList) {
            if (index.getBookIndex().getBookInstance().getCode().equals(book.getCode())) {
                list.add(index);
            }
        }
        return list;
    }
    
    public int countBookOfReader(Reader reader) {
        int counter = 0;
        ArrayList<MarketIndex> list = toArrayList();
        for (MarketIndex index : list) {
            if (index.getReader().getComparableCode() == reader.getComparableCode()) {
                counter += 1;
            }
        }
        return counter;
    }
    
    public int countReaderOfBook(Book book) {
        int counter = 0;
        ArrayList<MarketIndex> list = toArrayList();
        for (MarketIndex index : list) {
            if (index.getBookIndex().getBookInstance().getName().equals(
                        book.getName()
                    )) {
                counter += 1;
            }
        }
        return counter;
    }
    
    private boolean isConflict(ArrayList<Book> bookList, Book book) {
        for (Book item : bookList) {
            if (item.getName().equals(book.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Book> getListOfBook() {
        ArrayList<MarketIndex> market = toArrayList();
        ArrayList<Book> bookList = new ArrayList();
        
        for (MarketIndex trade : market) {
            if (!isConflict(bookList, trade.getBookIndex().getBookInstance())) {
                bookList.add(trade.getBookIndex().getBookInstance());
            }
        }
        return bookList;
    }
        
    
}
