package Array;

public class Move_Zeroes_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int ptr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[ptr];
                nums[ptr++] = nums[i];
                nums[i] = temp;
            }
        }
    }
/**
 *      用ptr一直记录最前段的0, 然后loop array, 一旦对应的slot != 0, swap
 *      Time: O(N)
 *      Space: O(1)
 * */

    public void appendAllZeros(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[idx++] = nums[i];

        for (; idx < nums.length; idx++)
            nums[idx] = 0;
    }
/**
 *      把非0的数字都放到前面，通过idx， 然后idx到结尾都为0
 *      Time: O(N)
 *      Space: O(1)
 * */
}
