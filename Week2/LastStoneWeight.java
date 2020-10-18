import java.util.Arrays;

class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        
        
        PriorityQueue<Integer> lastStoneWeight = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int stone : stones)
            lastStoneWeight.add(stone);
        
        //Iterator<Integer> queueIter = lastStoneWeight.iterator(); 
        while (lastStoneWeight.size() > 1) {
            int first = lastStoneWeight.poll();
            int second = lastStoneWeight.poll();
            
            if (first != second) {
                lastStoneWeight.add(first - second);
            } 
        }
        
        return (lastStoneWeight.size() == 0 ? 0 : lastStoneWeight.peek());
    }
}