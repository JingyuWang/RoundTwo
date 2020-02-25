package model.common;

import com.sun.source.tree.Tree;

public class Trie {
/*Implement a trie with insert, search, and startsWith methods.
Trie trie = new Trie();

trie.insert("apple");
trie.insert("apply");

trie.search("apple");   // returns true
trie.search("apply");   // returns true

trie.startsWith("app"); // returns true
trie.search("app");     // returns false

*/
    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null)
                temp.children[ch - 'a'] = new TrieNode();
            temp = temp.children[ch - 'a'];
        }
        temp.wordEnd = 1;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        TrieNode cur =   searchHelper(word, 0, temp);
        return cur!=null && cur.wordEnd ==1;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        TrieNode cur =  searchHelper(prefix, 0, temp);
        return cur!=null;
    }

    public TrieNode searchHelper(String word, int index, TrieNode curr){
        if (index>= word.length()){
            return curr;
        }
        if (curr.children[word.charAt(index) - 'a'] == null )
            return null;
        return searchHelper(word, index+1, curr.children[word.charAt(index) - 'a']);
    }
}
