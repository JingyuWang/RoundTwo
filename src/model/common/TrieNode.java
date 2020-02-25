package model.common;

public class TrieNode {
    public int wordEnd = 0;
    public TrieNode[] children;
    //by default, not set, no children.
    public TrieNode(){
        wordEnd = 0;
        children = new TrieNode[26];
    }
    public String toString(){
        return String.valueOf(wordEnd);
    }
}
