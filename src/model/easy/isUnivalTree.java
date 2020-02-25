package model.easy;
import model.common.*;
public class isUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root==null)
            return true;
        int top = root.val;
        return sub(root,top);
    }
    public static boolean sub(TreeNode root, int top){
        if (root==null)
            return true;
        if (root.val!=top)
            return false;
        else
            return sub(root.left, top) && sub(root.right, top);
    }
}
