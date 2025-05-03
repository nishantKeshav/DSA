class StockSpanner {

    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<Pair>();
    }
    
    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new Pair(price , 1));
            return 1;
        }
        int ans = 1;
        while(!stack.isEmpty() && price >= stack.peek().num1) {
            ans += stack.pop().num2;
        }
        stack.push(new Pair(price , ans));
        return ans;
    }
}

class Pair {
    int num1;
    int num2;
    Pair(int num1 , int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// Brute Force Solution
// class StockSpanner {
//     Stack<Integer> stack;
//     Stack<Integer> temp; 
//     public StockSpanner() {
//         stack = new Stack<>();
//     }    
//     public int next(int price) {
//         // System.out.println(stack);
//         if (stack.isEmpty()) {
//             stack.push(price);
//             return 1;
//         }
//         int ans = 1;
//         temp = new Stack<>();
//         while(!stack.isEmpty() && price >= stack.peek()) {
//             ans++;
//             temp.push(stack.pop());
//         }
//         while(!temp.isEmpty()) {
//             stack.push(temp.pop());
//         }
//         stack.push(price);
//         return ans;
//     }
// }
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */