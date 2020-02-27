//import model.*;
import model.common.*;
import model.easy.*;
import model.hard.*;
import model.medium.*;

import java.util.*;

public class Playgrond {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        //System.out.println(trie.startsWith("ap"));
        System.out.println(trie.search("ap"));
        //Test username
    }
    public static boolean isSquareful(int a, int b){
        double res = Math.ceil(Math.sqrt(a+b));
        return (a+b)==res*res;
    }
    /* build the sample tree like this:
     *           10
     *          /  \
     *         5    15
     *        / \   / \
     *       3  7  13  18
     * */
    public static TreeNode sample(){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        return root;
    }
    /* build the sample tree like this:
     *            1
     *          / | \
     *         2  3  4
     *             / | \
     *            5  6  7
     * */
    public static nTreeNode sampleNTree(){

        nTreeNode root = new nTreeNode(1);
        root.children = new ArrayList<>();
        root.children.add(new nTreeNode(2));
        root.children.add(new nTreeNode(3));
        root.children.add(new nTreeNode(4));

        nTreeNode temp = root.children.get(2);
        temp.children = new ArrayList<>();
        temp.children.add(new nTreeNode(5));
        temp.children.add(new nTreeNode(6));
        temp.children.add(new nTreeNode(7));
        return root;
    }
}
