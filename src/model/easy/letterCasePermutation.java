package model.easy;

import java.util.*;

/*Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.*/
public class letterCasePermutation {
    public static String input = "a1b2";
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        res.add(S);
        for(int i = 0 ; i<S.length(); i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                String tempS = res.get(j);
                inser(res,i,tempS);
            }
        }
        return res;
    }
    public static void inser(List<String> res, int i, String S){
        char temp = S.charAt(i);
        if (temp>=65 && temp<=90 ){
            res.add(S.substring(0,i) + Character.toLowerCase(temp) + S.substring(i+1));
        } else if (temp>=97 && temp<= 122){
            res.add(S.substring(0,i) + Character.toUpperCase(temp) + S.substring(i+1));
        }
    }
}
