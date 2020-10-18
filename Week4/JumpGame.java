class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
       
        int lastValidIndex = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--)
            if (i + nums[i] >= lastValidIndex)
                lastValidIndex = i;
       
        return lastValidIndex == 0;
    }
}