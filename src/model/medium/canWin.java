package model.medium;

import java.util.HashMap;
import java.util.Map;

/*294. Flip Game II
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
you and your friend take turns to flip two consecutive "++" into "--".
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Example:

Input: s = "++++"
Output: true
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
Follow up: Derive your algorithm's runtime complexity.*/
public class canWin {
    // rule 1 2 3 4 5 6 7 8 9 10 ---
    //      X Y Y Y X Y Y Y X Y
    public static String k = "+++++";
    public static Map<String, Boolean> memo = new HashMap();
    public static boolean canWin(String s) {
        // if already in map
        System.out.println("******************");
        if(memo.containsKey(s)) return memo.get(s);
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.startsWith("++", i)) {
                String next = s.substring(0, i) + "--" + s.substring(i + 2);
                System.out.println(next);
                if(!canWin(next)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}
