/*
 * Author: Kartik Gola
 * Date: 6/12/20 11:21 AM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.linkedlist.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        ListNode[] ans = new ListNode[k];
        // find list length
        int listLen = 0;
        while (curr != null) {
            listLen++;
            curr = curr.next;
        }
        int partsLen = listLen / k;
        int mod = listLen % k;
        int j = 0;

        curr = head;
        while (j < ans.length) {
            // If mod > 0, we can only take out 1 from it
            int currLen = partsLen + (mod-- > 0 ? 1 : 0);
            ans[j] = curr;
            while (--currLen > 0)
                curr = curr.next;
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
            j++;
        }

        return ans;
    }
}
