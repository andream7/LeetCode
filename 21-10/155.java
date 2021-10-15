/**
用两个栈实现
 */
class MinStack {

    Stack<Integer> stack = new Stack<>(), min = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        stack.push(val);
        // 对比与最小栈栈顶元素的大小
        // 查看是否更新栈顶元素
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }
    
    public void pop() {
        // 先检查是否要弹出栈顶元素
        if (min.peek() >= stack.peek()) {
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        // 返回stack的栈顶
        return stack.peek();
    }
    
    public int getMin() {
        // 返回min栈的栈顶元素
        return min.peek();
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