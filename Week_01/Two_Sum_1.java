package Array;
import java.util.*;
public class Two_Sum_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
/**
 *      用HashMap依次把num和idx存入进去，同时判断在map中是否存在target - nums[i]的差
 *      Time: O(N)
 *      Space: O(N)
 * */
}
