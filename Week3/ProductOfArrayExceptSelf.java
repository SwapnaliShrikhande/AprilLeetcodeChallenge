class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        
        int numsLen = nums.length, left = 1, right = 1;
        int[] output = new int[numsLen];
        for (int i = 0; i < numsLen; i++)
            output[i] = 1;
        
        for (int i = 0, j = numsLen - 1; i < numsLen-1; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            output[i+1] *= left;
            output[j-1] *= right;
        }
        
        return output;
    }
}