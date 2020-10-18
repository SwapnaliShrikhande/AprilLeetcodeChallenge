class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int temp = nums[0], maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i] + (temp > 0 ? temp : 0);
            maxSum = Math.max(maxSum, temp);
        }
        
        return maxSum;
    }
}