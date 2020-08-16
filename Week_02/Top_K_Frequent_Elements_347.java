package Heap;
import java.util.*;
public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < k) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            heap.add(entry);

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            output[i] = entry.getKey();
        }

        return output;
    }
/**
 *      使用heap方法，调用优先队列，把元素出现频率从大到小排列出来， 最终通过heap, 得到最大K的元素
 *      Time: O(NlgN)
 *      Space: O(N)
 *
 * */


    public int[] better(int[] nums, int k) {
        if (nums.length < k) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer>[] bucket = new List[nums.length+1];

        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> lst = new ArrayList<>();

        for (int i = bucket.length-1; i >= 0; i--)
            if (bucket[i] != null)
                lst.addAll(bucket[i]);

        int[] output = new int[k];
        for (int i = 0; i < k; i++)
            output[i] = lst.get(i);

        return output;
    }
/**
 *      用到了bucket sort方法，建立array，其freq对应array的index， 从最后面向前求出k个元素
 *      Time: O(N)
 *      Space: O(N)
 * */
}
