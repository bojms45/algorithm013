package Backtracking;
import java.util.*;
public class Combination_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(res, list, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}

/**
 *      回溯方法。 用start记录当前的数字， 在回溯中start+1， 避免重复
 *      Time:   O(n^min{k,n-k})
 *      Space:
 *
 * */
