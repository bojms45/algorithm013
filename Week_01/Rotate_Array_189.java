package Array;

import sun.reflect.generics.tree.VoidDescriptor;

public class Rotate_Array_189 {
    public void BruteForce(int[] nums, int k) {
        if (nums.length == 0) return;
        k %= nums.length;

        for (int i = 0; i < k; i++) {
            int num = nums[nums.length-1];
            for (int j = nums.length-1; j >= 1; j--)
                nums[j] = nums[j-1];
            nums[0] = num;
        }
    }
/**
 *      Brute Force in-place. 把最后一位保留出来，然后每一个element往后移一位
 *      k %= nums.length 是为了如果k超出num.length， 取最小可替换的值
 *      Time: O(Nk)
 *      Space: O(1)
 * */

    public void ExtraArray(int[] nums, int k) {
        if (nums.length == 0) return;

        k %= nums.length;
        int idx = nums.length-1;
        int[] res = new int[nums.length];

        for (int i = nums.length-1; i >= 0; i--) {
            if (k > 0)
                res[--k] = nums[i];
            else
                res[idx--] = nums[i];
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
/**
 *      Create extra Array。 对应的rotate传入到新的array中，然后copy到原来的array
 *      Time: O(N)
 *      Space: O(N)
 * */


    public void in_place_reverse(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
/**
 *      调用reverse， 整体reverse，把0 -> k-1 reverse, 把k -> nums.length-1 reverse即可
 *      time: O(N)
 *      Space: O(1)
 * */

}
