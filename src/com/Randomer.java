package com;

import java.util.Random;

public class Randomer {

    private static Random generator = new Random();
    private static final String SPLITER = "-";

    private static String getSingularCode() {
        return String.valueOf(generator.nextInt(9));
    }
    
    /**
     * Return a randomized book index code pattern.
     * The code pattern would be displayed as: XXXX-XXXXXXXX-XX
     * Which is only used for indexing book only
     * 
     * @return code_pattern
     */
    public static String getBookCode() {
        String t = "";
        for (int i = 0; i < 4; i++) {
            t += getSingularCode();
        }
        t += SPLITER;
        for (int i = 0; i < 8; i++) {
            t += getSingularCode();
        }
        t += SPLITER;
        t += (getSingularCode() + getSingularCode());
        return t;
    }
    
    /**
     * Return a randomized reader index code pattern.
     * The code pattern would be displayed as: XXXXXX-XXXX
     * Which is only used for indexing reader only
     * 
     * @return code_pattern
     */
    public static String getReaderCode() {
        String t = "";
        for (int i = 0; i < 6; i++) {
            t += getSingularCode();
        }
        t += SPLITER;
        for (int i = 0; i < 4; i++) {
            t += getSingularCode();
        }
        return t;
    }
    
    /**
     * Return a randomized location of the book on the shelves.
     * The location would be marked as XY:YY
     * With X represents for the Letter of the shelf.
     *      Y represents for the Number of the shelf level.
     * and the last Y represents for the location of the book on the level.
     * 
     * In this circumstance, we assumed that our library only has 6 shelves which marked
     * as A, B, C, D, E, F. And a single bookshelf has 10 levels, which can contains 100
     * books as a same time.
     * 
     * @return book_location
     */
    public static String getRandomLocation() {
        String shelfIndex[] = {"A", "B", "C", "D", "E", "F"};
        String t = "";
        t += shelfIndex[generator.nextInt(shelfIndex.length - 1)];
        t += getReaderCode();
        t += SPLITER;
        return (t + getSingularCode() + getSingularCode()); 
    }
    
}
