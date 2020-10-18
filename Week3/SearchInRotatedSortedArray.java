class Solution {
    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        int left = 0, right = numsLen - 1;

        // first find the rotation point
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        
        int ro = left;
        left = 0; 
        right = numsLen - 1;
        // now perform binary search taking into consideration rotation point
        while (left <= right) {
            int mid = (left + right) / 2;
            int realMid = (mid + ro) % numsLen;
            
            if (target == nums[realMid])
                return realMid;
            else if (target > nums[realMid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return -1;
    }
}