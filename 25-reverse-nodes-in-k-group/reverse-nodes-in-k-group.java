class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while (true) {
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) {
                break;
            }
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart.next;
            for (int i = 1; i < k; i++) {
                groupStart.next = curr.next;
                curr.next = prevGroupEnd.next;
                prevGroupEnd.next = curr;
                curr = groupStart.next;
            }
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }
}