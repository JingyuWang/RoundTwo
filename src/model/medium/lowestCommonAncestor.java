package model.medium;

import model.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class lowestCommonAncestor {
    public static TreeNode lCA(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        if (left != null)
            return left;
        else return right;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> Plist = new ArrayList<>();
        List<TreeNode> Qlist = new ArrayList<>();
        boolean help = findPath(root, p.val, Plist);
        help = findPath(root, q.val, Qlist);


        for(var a: Plist){
            System.out.print(a.val + " ");
        }
        System.out.println();
        for(var a: Qlist){
            System.out.print(a.val + " ");
        }

        int i =0;
        for(i=0; i<Plist.size() && i< Qlist.size(); i++){
            if (Plist.get(i).val!=Qlist.get(i).val){
                return Plist.get(i-1);
            }
        }
        return Plist.get(i-1);
    }
    public static boolean findPath(TreeNode root, int target, List<TreeNode> list){
        if(root==null) {
            return false;
        }
        list.add(root);
        if(root.val== target){
            //list.add(root.val);
            return true;
        }
        if (findPath(root.left, target, list)){
            //list.add(root.val);
            return true;
        }
        if (findPath(root.right, target, list)){
            //list.add(root.val);
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}
