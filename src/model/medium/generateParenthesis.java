package model.medium;

import org.w3c.dom.ls.LSException;

import java.util.*;
/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
public class generateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        DFSHelp(res, n, 0, 0, "");
        return res;
    }
    public static void DFSHelp(List<String> res, int n, int left, int right, String temp){
        if(right==n){
            res.add(temp);
            return;
        }
        if (left<n)
            DFSHelp(res, n, left+1, right, temp + "(");
        if (left>right)
            DFSHelp(res, n, left, right+1, temp + ")");
    }
}
