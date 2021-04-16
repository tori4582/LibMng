
package com;

import java.util.Calendar;

public class MarketIndex {
    
    public static final int STATUS_PICKING  = 0;
    public static final int STATUS_RETURNED = 1;
    public static final int STATUS_LOST     = 2;
    
    private BookIndex bookIndex;
    private Reader    reader;
    private Calendar  pickDate;
    private Calendar  returnDate;
    private int       indexStatus;
    private MarketIndex nextIndex;
    
    public MarketIndex(BookIndex book, Reader reader) {
        this.bookIndex = book;
        this.reader = reader;
        this.pickDate = Calendar.getInstance();
        this.returnDate = null;
        this.indexStatus = STATUS_PICKING;
    }
    
    public BookIndex   getBookIndex()   { return this.bookIndex; }
    public Reader      getReader()      { return this.reader; }
    public int         getStatus()      { return this.indexStatus; }
    public String      getPickDate()    { return getReadableDate(this.pickDate); }
    public String      getReturnDate()  { return getReadableDate(this.returnDate); } 
    public MarketIndex next()           { return this.nextIndex; }
  
    public void setNext(MarketIndex newNextIndex) {
        this.nextIndex = newNextIndex;
    }
    
    public void returnBook() {
        this.returnDate = Calendar.getInstance();
        this.indexStatus = STATUS_RETURNED;
    }
    
    public void reportLost() {
        this.indexStatus = STATUS_LOST;
    }  
    
    public String getReadableDate(Calendar date) {
        String t = "";
        if (date == null) {
            return t;
        }
        t = t.concat(String.valueOf(date.get(5)) + "/");
        t = t.concat(String.valueOf(date.get(2) + 1) + "/");
        t = t.concat(String.valueOf(date.get(1)));
        return t;
    } 
    

}

