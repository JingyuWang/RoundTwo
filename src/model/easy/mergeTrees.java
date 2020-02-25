package model.easy;
import model.common.TreeNode;
public class mergeTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null && t2 ==null){
            return null;
        }else if (t1!=null && t2==null){
            return t1;
        }else if (t1==null && t2!=null){
            return t2;
        }else{
            TreeNode curr = new TreeNode(t1.val+t2.val);
            curr.left = mergeTrees(t1.left, t2.left);
            curr.right = mergeTrees(t1.right, t2.right);
            return curr;
        }
    }
}
