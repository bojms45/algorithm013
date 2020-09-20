package Backtracking;
import java.util.*;
public class Permutations_II_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            list.add(nums[i]);
            backtrack(res, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}

/**
 *      回溯, visited来track当前的是否被访问过， 避免重复
 *      同时，因为会有重复，所以要判断当前的是否和前一个相同，如果是，并且前一个没有被访问到，跳过。
 *      前提条件，要把nums sort一遍
 *
 *      Time: O(N*N!)
 *      Space: O(N)
 * */
