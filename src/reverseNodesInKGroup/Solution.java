package reverseNodesInKGroup;

/**
 * 一开始以为可以遍历链表一次就完成翻转，后来发现不显示，主要是因为要预判后面剩余的节点数来判断是否要翻转，所以不得不遍历两次
 * 链表翻转注意常用的【头插法】，注意在大小循环中的【推进】
 * 如果发生死循环主要有两个可能：
 *  1. 链表成环了，看看各个next的连接
 *  2. 遍历的时候没有推进，看看cur指针是否推进了（大小循环都要看）
 *
 * Created by donglongcheng01 on 2018/5/6.
 */
public class Solution {
    /**
     *
     * 81 / 81 test cases passed.
     *  Status: Accepted
     *  Runtime: 8 ms
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;

        ListNode after = null;
        ListNode originHead = null;

        // 需要先走一遍计数，方便后面统计是否需要翻转
        int cnt = 0;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;

        if (k <= 1) {
            return head;
        }

        while (cnt >= k) {
            cur = head.next;
            originHead = head;
            for (int i = 0; i < k - 1; i++) {
                // 记录after，为了后面头插完的衔接和推进
                after = cur.next;
                // 头插法，翻转链表经常用的方法
                ListNode curHead = dummy.next;
                dummy.next = cur;
                cur.next = curHead;
                originHead.next = after;
                // 千万不要忘了推进，如果死循环了就想想，有可能是形成环了，还有可能有是没有推进
                cur = after;
            }
            // 上面是小循环中的推进，这里是大循环的中的推进，重新设置头节点
            dummy = originHead;
            head = after;
            cnt -= k;
        }

        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            ListNode cur = this;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.val);
                if (cur.next != null) {
                    sb.append(" -> ");
                }
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(list, 2);
        System.out.println(res);
    }
}
