package _2_add_two_numbers.my;

import _2_add_two_numbers.ListNode;

/**
 * Solution
 *
 * @title Solution
 * @Description
 * @Author donglongcheng01
 * @Date 2019-07-28
 **/
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode l3 = dummyHead;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if(sum >= 10) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            l3.next = new ListNode(sum);
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 != null ? l1 : l2;
        while(remain != null) {
            int sum = remain.val + carry;
            if(sum >= 10) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            l3.next = new ListNode(sum);
            l3 = l3.next;
            remain = remain.next;
        }
        if(carry == 1) {
            l3.next = new ListNode(1);
            l3 = l3.next;
        }
        return dummyHead.next;
    }

}
