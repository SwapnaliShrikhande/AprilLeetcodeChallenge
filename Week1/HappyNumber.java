class Solution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        
        Set<Integer> duplicates = new HashSet<Integer>();
        
        int squaredSum = 0, digit = 0;
        while (duplicates.add(n)) {
            while (n > 0) {
                digit = n % 10;
                n = n / 10;
                squaredSum += digit*digit;
            }
            if (squaredSum == 1)
                return true;
                 
            n = squaredSum;
            squaredSum = 0;
        }
     
        return false;    
    }
}