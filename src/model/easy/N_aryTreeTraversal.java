package model.easy;

import model.common.nTreeNode;

import java.util.LinkedList;
import java.util.List;

/*
* Post order
* Pre order
* */
public class N_aryTreeTraversal {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> preorder(nTreeNode root) {
        List<Integer> res = new LinkedList<>();
        helperPreOrder(root, res);
        return res;
    }
    public List<Integer> postorder(nTreeNode root){
        //List<Integer> ans = new LinkedList<>();
        if(root==null)
            return ans;
        for(nTreeNode k: root.children){
            postorder(k);
        }
        ans.add(root.val);
        return ans;
    }
    public static void helperPreOrder(nTreeNode root, List<Integer> ans){
        if (root!=null){
            ans.add(root.val);
            for(nTreeNode k: root.children){
                helperPreOrder(k,ans);
            }
        }
    }

}
