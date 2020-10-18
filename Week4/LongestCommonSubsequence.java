class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int memo[] = new int[n + 1];
        char[] text1Char = text1.toCharArray(), text2Char = text2.toCharArray();
        
		for (int i = 1; i <= m; i++) {
			int prev = 0;
			for (int j = 1; j <= n; j++) {
				int temp = memo[j];
				if (text1Char[i - 1] == text2Char[j - 1]) {
					memo[j] = prev + 1;
				} else {
					memo[j] = Math.max(memo[j], memo[j - 1]);
				}
				prev = temp;
			}

		}
        
		return memo[n];
    }
}