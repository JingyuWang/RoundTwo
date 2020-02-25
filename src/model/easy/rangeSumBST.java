package model.easy;
import model.common.TreeNode;
public class rangeSumBST {
    public static int sum = 0;
    public static int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return sum;
    }
    public static void helper(TreeNode root, int L, int R){
        if (root==null){
            return;
        }
        if (root.val >=L && root.val<=R){
            System.out.println(root.val);
            sum += root.val;
            helper(root.right, L, R);
            helper(root.left, L, R);
        }else if(root.val<L){
            helper(root.right, L, R);
        }else{
            helper(root.left, L, R);
        }
    }
}
