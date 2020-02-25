package model.hard;
import java.util.*;
/*Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]*/
public class removeInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        int n = s.length();
        int L = 0, R = 0;
        for(int i=0; i<n; i++){
            char temp = s.charAt(i);
            if (temp=='(') L++;
            if (temp==')'){
                if (L==0) R++;
                else L--;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        //System.out.println("L is "+ L + "  R is " + R);
        //System.out.println("SB is "  + sb);
        DFSHelper(0, L,R,sb,res);
        return res;
    }
    //DFS main method
    public static void DFSHelper(int pos, int L, int R, StringBuilder s, List<String> res){
        if (L==0 && R==0 ){
            if (checkValid(s.toString())){
                //System.out.println("ans is " + s);
                res.add(s.toString());
            }
            return;
        }
        for(int i=pos; i<s.length(); i++){
            if(i>pos && s.charAt(i)==s.charAt(i-1)) continue;
            //System.out.println(s);
            char tempChar = s.charAt(i);
            if (tempChar=='(' || s.charAt(i)==')'){
                s.deleteCharAt(i);
                //String cur = s.substring(0,i) + s.substring(i+1);
                if(R>0) DFSHelper(i,L,R-1,s,res);
                else if(L>0) DFSHelper(i,L-1,R,s,res);
                s.insert(i,tempChar);
            }
        }
    }


    public static boolean checkValid(String s){
        int l = 0;
        int r = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            if (s.charAt(i)=='(') l++;
            if (s.charAt(i)==')') r++;
            if (i<n-1){
                if (l<r)
                    return false;
            }
        }
        return l==r;
    }
}
