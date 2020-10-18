class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        if (nums == null || nums.length == 0)
            return count;
        
        HashMap<Integer, Integer> prefixSumMap = new HashMap<Integer, Integer>();
        int currentSum = 0, numsLen = nums.length;
        
        for (int i = 0; i < numsLen; i++) {
            // step 1 : calculate prefix sum
            currentSum += nums[i];
            
            // step 2 : current sum matches k
            if (currentSum == k)
                count++;
            
            // step 3 : not a perfect match but previous sum in map found
            if (prefixSumMap.containsKey(currentSum - k))
                count += prefixSumMap.get(currentSum - k);
            
            // nothing then : add in map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0)+1);
        }
        
        return count;
    }
}