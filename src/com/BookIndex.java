
package com;

public class BookIndex {
    
    public static final int STATUS_READY = 0;
    public static final int STATUS_PICKED = 1;
    public static final int STATUS_SOLD = 2;
    
    private String bookIndex;
    private Book   book;
    private int    status;
    private String location;
    private BookIndex nextIndex;
    
    public BookIndex (Book book, int status, BookIndex nextIndex) {
        this.book = book;
        this.status = status;
        this.bookIndex = Randomer.getBookCode();
        this.location = Randomer.getRandomLocation();
        this.nextIndex = nextIndex;
    }
    
    public String getIndex() { return this.bookIndex; }
    public Book getBookInstance() { return this.book; }
    public int getStatus() { return this.status; }
    public String getLocation() { return this.location; }
    public BookIndex next() { return this.nextIndex; }
    
    public void fixBook(Book newBookInformation) { this.book = newBookInformation; }
    public void updateStatus(int newStatus) { this.status = newStatus; }
    public void setNext(BookIndex nextIndex) { this.nextIndex = nextIndex; }
}
