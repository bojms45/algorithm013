package Array;

public class Plus_One_66 {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int n = digits.length;

        int i = 0;
        for (; i < n; i++)
            if (digits[i] != 9) break;

        if (i == n) {
            int[] res = new int[n+1];
            res[0] = 1;
            return res;
        }

        i = n-1;
        int last = i;

        while (i >= 0) {
            if (last == i) {
                if (digits[i] >= 9) {
                    digits[i] = 0;
                    digits[i-1]++;

                    if (digits[i-1] == 10)
                        last = i-1;
                } else {
                    digits[i]++;
                    break;
                }
            }
            i--;
        }
        return digits;
    }
/**
 *      先判断array中是否都是9， 如果是，直接返回+1的最终值
 *      否则：
 *          判断最后一位是否是9，如果不是，直接+1。
 *          如果是，用指针判断每一次前一个的element是否为9，直到loop完毕
 *
 *      Time: O(N)
 *      Space: O(N+1)
 * */
}
