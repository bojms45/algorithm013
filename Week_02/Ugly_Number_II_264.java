package Heap;
import java.util.*;
public class Ugly_Number_II_264 {
    public int heap_1(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);

        for (int i = 0; i < n-1; i++) {
            Long v = set.pollFirst();
            set.add(v*2);
            set.add(v*3);
            set.add(v*5);
        }

        return set.first().intValue();
    }
/**
 *      Using Heap, 调用TreeSet, 避免重复
 *      Time: O(NlgN)   treeSet.pollFirst() takes lgN time
 *      Space: O(N)
 * */

    public int heap_2(int n) {
        Queue<Long> pq = new PriorityQueue<>();

        pq.offer(1L);
        for (int i = 0; i < n-1; i++) {
            long val = pq.poll();
            while (!pq.isEmpty() && val == pq.peek())
                pq.poll();

            pq.offer(val*2);
            pq.offer(val*3);
            pq.offer(val*5);
        }

        return pq.peek().intValue();
    }
/**
 *      Using heap, 调用 priority queue， 重复的话就直接删掉
 *      Time: O(NlgN)
 *      Space: O(N)
 * */
}
