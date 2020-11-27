package com.dp.leetcode;

import java.util.PriorityQueue;

public class FirstMissingPositive
{
    public int firstMissingPositiveMinHeap(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for ( int num : nums){
            heap.add(num);
        }


        int result = 1;
        Integer polled;
        while((polled = heap.poll()) != null){
            if (polled <= 0)
                continue;

            if (polled > result){
                return result;
            }else if (polled == result) {
                result++;
            }else{
                // nothing
            }
        }
        return result;
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            while(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
