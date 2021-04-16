
package com;

public class Reader {
    
    private String  readerCode;
    private String  firstName;
    private String  lastName;
    private boolean isMale;
    private boolean isActivated;
    private int     comparableCode;
    
    public Reader (String firstName,
                   String lastName,
                   boolean isMale,
                   boolean isActivated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMale = isMale;
        this.isActivated = isActivated;
        this.readerCode = Randomer.getReaderCode();
        String[] t = readerCode.split("-");
        this.comparableCode = Integer.parseInt(t[0]) - Integer.parseInt(t[1]);
                               
    }
    
    public String getCode() { return this.readerCode; }
    public int    getComparableCode() { return this.comparableCode; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getFullName() { return (this.firstName + " " + this.lastName); }
    public boolean isMale() { return this.isMale; }
    public boolean getCardStatus() { return this.isActivated; }
    
    public void fixFirstName(String newFirstName) { this.firstName = newFirstName; }
    public void fixLastName(String newLastName) { this.lastName = newLastName; }
    public void fixSex(boolean isMale) { this.isMale = isMale; }
    public void activate() { this.isActivated = true; }
    public void deactivate() { this.isActivated = false; }
    
}
