package Hash;
import java.util.*;

public class Group_Anagrams_49 {
    public List<List<String>> best(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] ca = new char[26];

            for (char c: str.toCharArray()) ca[c - 'a']++;
            String key = String.valueOf(ca);

            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
/**
 *      调用HashMap， 把整合后的string当成key存入， 对应的list存入到value中。
 *      Time: O(NK), N is length of array of String, K is length of each string
 *      Space: O(NK)
 * */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
/**
 *      调用HashMap, 并且把每个string都sort一遍，存入到map中。
 *      Time： O(NKlgK), N is length of array of string, K is length of each string
 *      Space: O(NK)
 * */
}
