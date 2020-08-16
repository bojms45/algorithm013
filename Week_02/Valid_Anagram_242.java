package Hash;
import java.util.*;
public class Valid_Anagram_242 {
    public boolean useMap(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }

        for (char c: t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c)-1);
            else
                return false;
        }

        for (char c: map.keySet())
            if (map.get(c) != 0) return false;

        return true;
    }
/**
 *      调用hashmap， 在s中，把char和出现次数传进去； 在t中，每出现一次，把对应的出现次数-1
 *      最后返回是否所有value都为0
 *
 *      Time: O(N)
 *      Space: O(N)
 * */

    public boolean useAlpha(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }

        for (int n: alpha)
            if (n != 0) return false;

        return true;
    }
/**
 *      调用array，26个字母。 在s中，每出现一个字母，对应idx+1， 在t中，每出现一个字母，对应idx-1
 *      返回array中所有值是否为0
 *      Time: O(N)
 *      Space: O(1)
 * */

}
