package leetcode;

public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null )
            return head;

        ListNode prev = null, newHead = null;
        ListNode fst = head, snd = head.next;

        while ( fst != null && snd != null ) {
            if ( newHead == null ) {
                newHead = snd;
            }
            ListNode temp = snd.next;
            snd.next = fst;
            fst.next = temp;
            if ( prev != null ) {
                prev.next = snd;
            }
            prev = fst;
            fst = fst.next;
            snd = fst != null ? fst.next : null;
        }

        return newHead;
    }
}
