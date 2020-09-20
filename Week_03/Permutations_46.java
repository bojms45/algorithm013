package Backtracking;
import java.util.*;
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(res, list, nums, visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}

/**
 *      回溯，用visited来track当前的num是否被使用了， 如果是，跳到下一个, 避免重复
 *      Time: O(N*N!)
 * */
