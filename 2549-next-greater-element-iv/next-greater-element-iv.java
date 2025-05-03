class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        
        Arrays.fill(nextGreater,-1);
        Stack<Integer> s1 = new Stack<>(),s2 = new Stack<>(),temp = new Stack<>();
        for(int i=0; i<n ;i++){
            while(!s2.isEmpty() && nums[s2.peek()] < nums[i]){
                nextGreater[s2.pop()] = nums[i];
            }
            while(!s1.isEmpty() && nums[s1.peek()] < nums[i]){
                temp.push(s1.pop());
            }
            while(!temp.isEmpty()){
                s2.push(temp.pop());
            }
            s1.push(i);   
        }
        return nextGreater;
    }
}