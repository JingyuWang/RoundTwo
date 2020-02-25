package model.easy;
import model.common.*;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth {
    public static int maxdepth(nTreeNode root){
        if (root==null)
            return 0;
        if (root.children==null)
            return 1;
        int max = 0;
        for(int i=0; i<root.children.size(); i++){
            int temp = maxdepth(root.children.get(i));
            if (temp>max)
                max = temp;
        }
        return max+1;
    }
    public static int maxdepth_DFS(nTreeNode root){
        if (root==null) return 0;
        Queue<nTreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(q.size()!=0){
            int size = q.size();
            for(int i=0; i<size; i++){
                nTreeNode temp = q.poll();
                for (nTreeNode k : temp.children) {
                    q.add(k);
                }
            }
            depth++;
        }
        return depth;
    }
    public static int maxdepth_NON(nTreeNode root){
        if (root == null) return 0;
        Queue<nTreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                nTreeNode cur = q.poll();
                for (nTreeNode n : cur.children) {
                    q.add(n);
                }
            }
            if (q.size() != 0)
                level++;
        }

        return level;
    }
    public static void Print(Queue<nTreeNode> q){
        for(var k: q){
            System.out.print(k.val);
        }
    }
}
