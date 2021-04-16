package com;

public class ReaderNode {

    public static final int COMP_LEFT = -1;
    public static final int COMP_RIGHT = 1;
    public static final int COMP_FAILED = 0;
    public static final int SIGNAL_FULL = -1;
    
    private Reader      reader;
    private ReaderNode  nextLeft = null;
    private ReaderNode  nextRight = null;
    
    public ReaderNode(Reader reader) {
        this.reader = reader;
    }
    
    public Reader getReader() { return this.reader; }
    public ReaderNode left() { return this.nextLeft; }
    public ReaderNode right() { return this.nextRight; }
    
    public boolean isFreeNode() {
        return (this.reader == null);
    }
    public boolean isSemiNode() {
        return (this.nextLeft == null ^ this.nextRight == null);
    }
    public boolean isFullNode() {
        return (this.nextLeft != null && this.nextRight != null);
    }
    public boolean isEmptyNode() {
        return (this.nextLeft == null && this.nextRight == null);
    } 
    public boolean isFreeLeft() {
        return (this.nextLeft == null);
    }
    public boolean isFreeRight() {
        return (this.nextRight == null);
    }
    
    public int compare(ReaderNode node) {
        int code1 = this.reader.getComparableCode();
        int code2 = node.getReader().getComparableCode();
        if (code1 > code2) { 
            return ReaderNode.COMP_LEFT;
        }  else if (code1 == code2) {
            return ReaderNode.COMP_FAILED;
        } else {
            return ReaderNode.COMP_RIGHT;
        }
    }
    
    public void setReader(Reader reader) { this.reader = reader; }
    public void setLeft(ReaderNode leftNode) { this.nextLeft = leftNode; }
    public void setRight(ReaderNode rightNode) { this.nextRight = rightNode; }
    
}
