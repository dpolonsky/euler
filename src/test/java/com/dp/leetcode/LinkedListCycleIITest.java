package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.dp.leetcode.list.LinkedListCycleII;
import com.dp.leetcode.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleIITest
{

    @Test
    void detectCycle()
    {
        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
        ListNode head = linkedListCycleII.createList(2, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        ListNode listNode = linkedListCycleII.detectAndRemoveCycle(head);
        assertEquals(3, listNode.val);
    }
}