class MinStack {

    class Node {
        int min;
        int val;
        Node next;
        Node(int val , int min) {
            this.val = val;
            this.min = min;
            next = null;
        }
    }

    Node head;

    public MinStack() {

    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val , val);
            return;
        }
        Node node = new Node(val , Math.min(val , head.min));
        node.next = head;
        head = node;
        return;
    }
    
    public void pop() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        return;
    }
    
    public int top() {
        if (head == null) {
            return -1;
        } 
        return head.val;
    }
    
    public int getMin() {
        if (head == null) {
            return -1;
        }
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */