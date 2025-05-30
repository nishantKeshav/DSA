class MyStack {

    private Queue<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    // using 2 Queues
    // public void push(int x) {
    //     if (stack.isEmpty()) {
    //         stack.offer(x);
    //         return;
    //     }
    //     Queue<Integer> temp = new LinkedList<>();
    //     temp.offer(x); 
    //     while (!stack.isEmpty()) {
    //         temp.offer(stack.poll());
    //     }
    //     stack = temp; 
    // }

    // using 1 queue
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.offer(x);
            return;
        }
        stack.offer(x);
        for (int i = 1 ; i < stack.size() ; i++) {
            stack.offer(stack.poll());
        }
    }
    
    public int pop() {
        return stack.poll();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */