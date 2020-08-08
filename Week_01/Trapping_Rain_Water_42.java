package StackQueuePQ;
import java.util.*;
public class Trapping_Rain_Water_42 {
    public int bruteForce(int[] height) {
        int area = 0;
        int n = height.length;

        for (int i = 1; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            for (int j = i; j >= 0; j--)
                leftMax = Math.max(leftMax, height[j]);

            for (int j = i; j < n; j++)
                rightMax = Math.max(rightMax, height[j]);

            int minHeight = Math.min(leftMax, rightMax);
            area += minHeight - height[i];
        }
        return area;
    }
/**
 *      Brute Force, 从 1 -> n-1， 根据当前，找出前面和后面的各个最大值， 然后算出他们其中最小值，因为水不会越过去。
 *      在求出其中最小值与当前的差，就是当前的水的面积， 加入到总面积中
 *
 *      Time: O(N^2)
 *      Space: O(1)
 */

    public int useStack(int[] height) {
        if (height.length <= 2) return 0;
        int n = height.length;

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int i = 0;

        while (i < n) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()])
                stack.push(i++);
            else {
                int prev = stack.pop();

                if (!stack.isEmpty()) {
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    area += (minHeight - height[prev]) * (i - stack.peek() - 1);
                }
            }
        }
        return area;
    }
/**
 *      调用stack, 如果当前stack是空 或者 当前height比前一个小，push到stack中。
 *      否则， 把前一个pop并且记录下来，因为是比较矮的，要计算水的面积
 *      Time: O(N)
 *      Spqce: O(N)
 * */

    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        int area = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    area += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    area += rightMax - height[right];
                right--;
            }
        }
        return area;
    }
/**
 *      Two Pointers， 左右ptr找出当前最高的height，然后比他低的，求出相差高度即可
 *      Time: O(N)
 *      Space: O(1)
 * */

}
