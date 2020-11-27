package com.dp.leetcode.list;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 */
public class LinkedListCycleII
{
    public ListNode detectAndRemoveCycle(ListNode head)
    {
        if (head == null) { return null; }

        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) { return removeLoop(head, slow); }
        }

        return null;
    }

    private ListNode removeLoop(ListNode head, ListNode loop)
    {
        ListNode ptr1 = loop;
        ListNode ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

          /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        ListNode result = ptr2.next;
        ptr2.next = null;
        return result;
    }

    public ListNode createList(int loopindex, int... x)
    {
        ListNode head = null;
        ListNode last = null;
        for (int i = 0; i < x.length; i++) {
            if (i == 0) {
                last = head = new ListNode(x[i]);
            }
            else {
                last.next = new ListNode(x[i]);
                last = last.next;
            }
        }

        ListNode loopNode = head;
        for (int i = 0; i < loopindex; i++) {
            loopNode = loopNode.next;
        }
        last.next = loopNode;
        return head;
    }
}
