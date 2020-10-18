class Solution {
    public boolean checkValidString(String s) {
        if (s == null)
            return false;
        
        if (s.length() == 0)
            return true;
        
        Stack<Integer> openingPara = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(')
                openingPara.push(i);
            else if (ch == '*')
                star.push(i);
            else {
                if (openingPara.empty() && star.empty())
                    return false;
                if (!openingPara.empty())
                    openingPara.pop();
                else 
                    star.pop();
            }
        }
        
        while (!openingPara.empty() && !star.empty()) {
            if (openingPara.pop() > star.pop()) 
                return false;
        }
        
        return openingPara.empty();
    }
}