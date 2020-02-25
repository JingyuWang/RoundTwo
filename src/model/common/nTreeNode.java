package model.common;

import java.util.ArrayList;
import java.util.List;

public class nTreeNode {
    public int val;
    public List<nTreeNode> children;
    public nTreeNode() {}
    public nTreeNode(int _val) {
        val = _val;
        children = new ArrayList<>();
    }
    public nTreeNode(int _val, List<nTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
