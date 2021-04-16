
package com;

public class Book {

    public static final String GENRE_LITERATURE = "Literature";
    public static final String GENRE_ENGLISH = "English";
    public static final String GENRE_TEXTBOOK = "Textbook";
    public static final String GENRE_REFERENCE = "Reference";
    public static final String GENRE_RESEARCH = "Research";
    public static final String GENRE_ARTICLE = "Article";
    public static final String GENRE_REPORT = "Report";
    public static final String GENRE_UNCATALOGIZED = "Other";
    
    private String isbnCode;
    private String bookName;
    private String bookAuthor;
    private String bookGenre;
    
    private int    publishedYear;
    private int    page;
    
    public Book(String isbn, 
                String name, 
                String author, 
                String genre,
                int publishedYear,
                int pageNumber) {
        this.isbnCode = isbn;
        this.bookName = name;
        this.bookGenre = genre;
        this.bookAuthor = author;
        this.publishedYear = publishedYear;
        this.page = pageNumber;
    }
    
    public String getCode() { return this.isbnCode; }
    public String getName() { return this.bookName; }
    public String getAuthor() { return this.bookAuthor; }
    public String getGenre() { return this.bookGenre; }
    public int    getPage() { return this.page; }
    public int    getPublishedYear() { return this.publishedYear; }
    
    public void fixCode(String newCode) { this.isbnCode = newCode; }
    public void fixName(String newName) { this.bookName = newName; }
    public void fixAuthor(String newAuthor) { this.bookAuthor = newAuthor; }
    public void fixGenre(String newGenre) { this.bookGenre = newGenre; }
    public void fixPage(int newPage) { this.page = newPage; }
    public void fixYear(int newYear) { this.publishedYear = newYear; }
    
}
