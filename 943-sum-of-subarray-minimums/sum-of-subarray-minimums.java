class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        int ple[] = new int[n]; // previous less element
        int nle[] = new int[n]; // next less element

        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        
        for (int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for (int i = 0 ; i < n ; i++) {
            long left = (i - ple[i]);
            long right = (nle[i] - i);
            result = (result + (arr[i] * left * right)) % mod;
        }

        return (int)(result);
    }
}