package LinkedList;

public class Merge_Two_Sorted_Lists_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;

        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode prev = null;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                break;
            }
            else if (l2 == null) {
                prev.next = l1;
                break;
            }
            else {
                ListNode l1_next = l1.next;
                ListNode l2_next = l2.next;

                if (l1.val == l2.val) {
                    if (prev != null)
                        prev.next = l1;
                    l1.next = l2;
                    prev = l2;

                } else if (l1.val < l2.val) {
                    if (prev != null)
                        prev.next = l1;

                    while (l1.next != null && l1.next.val < l2.val) {
                        l1 = l1.next;
                    }
                    l1_next = l1.next;

                    l1.next = l2;
                    prev = l2;

                } else {    // l2.val < l1.val
                    if (prev != null)
                        prev.next = l2;

                    while (l2.next != null && l2.next.val < l1.val) {
                        l2 = l2.next;
                    }
                    l2_next = l2.next;

                    l2.next = l1;
                    prev = l1;

                }
                l1 = l1_next;
                l2 = l2_next;
            }
        }


        return head;
    }
/**
 *      Iterative， 两个list同时运行。
 *      如果相等，随便一个指向另一个
 *      如果一个小于另一个，iterate小的，直到当前node不再小于另一个并且==null， 最终连在一起
 *      Time：O(N + M)
 *      Space: O(1)
 * */


    public ListNode recursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = recursive(l1.next, l2);
            return l1;
        } else {
            l2.next = recursive(l1, l2.next);
            return l2;
        }
    }
/**
 *      Recursive
 *      每一个node都指向下一个的recursive，重构
 *      Time: O(N+M)
 *      Space: O(N)
 * */


}
