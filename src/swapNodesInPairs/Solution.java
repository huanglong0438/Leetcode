package swapNodesInPairs;

/**
 * Created by donglongcheng01 on 2018/5/5.
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode cur = head;
        ListNode temp;
        ListNode newHead = head;
        /**
         * 面对这种链表问题，一定要记得pre啊，别后面都交换完了，把前面的给忘了！！！
         */
        ListNode pre = null;
        boolean first = true;

        while (cur != null && cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            if (pre != null) {
                // pre一定要注意！！！
                pre.next = temp;
            }
            if (first) {
                newHead = temp;
                first = false;
            }
            // 一定要往前推进，不然会死循环
            pre = cur;
            cur = cur.next;
        }

        return newHead;
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

        Solution solution = new Solution();
        ListNode res = solution.swapPairs(list);
        System.out.println(res);
    }
}
