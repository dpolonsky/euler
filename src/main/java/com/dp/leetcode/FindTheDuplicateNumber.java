package com.dp.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber
{
    public int findDuplicateOnlyOneDuplicate(int[] nums)
    {

        if (nums.length == 0) { return -1; }

        long sum = 0;
        for (int num : nums){
            sum += num;
        }

        long expected = (nums.length * (nums.length- 1)) / 2;
        return (int) (sum - expected);
    }

    public int findDuplicate(int[] nums){
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int find = 0;

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
    public int findDuplicateExtraSpace(int[] nums)
    {

        if (nums.length == 0) { return -1; }

        List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());

        int last = -1;
        for (Integer num : list) {
            if (num.equals(last)) {
                return num;
            }
            last = num;
        }

        return -1;
    }
}
