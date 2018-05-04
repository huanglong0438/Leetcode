package mergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by donglongcheng01 on 2018/5/4.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * 最基本的解法，就是循环三个list找最小，没想到这么low都过了，如果list数为n，平均长度为k，复杂度大概O(nk)吧
     *
     *   131 / 131 test cases passed.
     *    Status: Accepted
     *    Runtime: 392 ms
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists_base(ListNode[] lists) {
        ListNode mergedList = null;
        ListNode mergedHead = null;
        boolean first = true;
        while (true) {
            int min = Integer.MAX_VALUE;
            int min_i = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list != null && list.val < min) {
                    min = list.val;
                    min_i = i;
                }
            }
            if (min_i == -1) {
                break;
            }
            lists[min_i] = lists[min_i].next;
            if (first) {
                mergedHead = new ListNode(min);
                mergedList = mergedHead;
                first = false;
            } else {
                mergedList.next = new ListNode(min);
                mergedList = mergedList.next;
            }
        }
        return mergedHead;
    }


    /**
     * 分治思想，k个排序可以参考merge2SortedLists，两个两个来归并排序
     *
     *  131 / 131 test cases passed.
     *  Status: Accepted
     *  Runtime: 13 ms
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            return merge(helper(lists, l, m), helper(lists, m + 1, r));
        }
        return lists[l];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        // 打算默认用l1作为归并结果
        merged.next = l1;
        ListNode cur = merged;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // 因为l1默认就接到merged上了，所以只需要l1往后走
                l1 = l1.next;
            } else {
                // 把l2的当前节点插到merged和l1组成的链中
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;

        }

        if (l2 != null) {
            // 因为默认是接l1的，所以l1的情况不用管，如果l2有富余，就把l2剩下的部分都接到链表上
            cur.next = l2;
        }
        return merged.next;

    }

    /**
     * 用了最小堆来实现，学一手，原来JDK的最小堆实现就是优先级队列PriorityQueue啊啊啊啊啊
     *  131 / 131 test cases passed.
     *  Status: Accepted
     *  Runtime: 20 ms
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        // PriorityQueue就是JDK的堆实现啊啊啊啊啊啊，不用自己写啊啊啊啊啊
//      可以简写成 PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode head = null;
        ListNode pre = head;
        while (heap.size() > 0) {
            ListNode cur = heap.poll();
            if (head == null) {
                head = cur;
                pre = head;
            } else {
                pre.next = cur;
            }
            pre = cur;
            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = { list1, list2, list3 };
        ListNode result = solution.mergeKLists2(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
