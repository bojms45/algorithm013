package Array;

public class Remove_Duplicates_from_Sorted_Array_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int sum = 1;
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[idx++] = nums[i];
                sum++;
            }
        }
        return sum;
    }
/**
 *      计算多少个distinct element, 并且通过idx， 把distinct传入到array中
 *      time: O(N)
 *      Space: O(1)
 *
 * */
    public int better(int[] nums) {
        int i = 0;
        for (int n: nums)
            if (i == 0 || nums[i-1] < n)
                nums[i++] = n;
        return i;
    }
/**
 *      用i 记录当前的index， 因为array是sort的，如果i = 0 或者 i的前一个element < n， 那么i的element就等于n，
 *      Time: O(N)
 *      Space: O(1)
 *
 * */
}
