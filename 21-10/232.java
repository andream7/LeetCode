/**
使用一个栈作为cache，得到stack中元素的倒序。
 */

class MyQueue {

    Stack<Integer> stack = new Stack<>(), cache = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        // 队头元素也就是栈底元素
        // 把数据移动到cache
        copy(stack, cache);
        int res = cache.pop();
        // 把cache中的元素再移回stack
        copy(cache, stack);
        return res;

    }
    
    public int peek() {
        copy(stack, cache);
        // 只获取不移除
        int res = cache.peek();
        // 把cache中的元素再移回stack
        copy(cache, stack);
        return res;

    }
    
    public boolean empty() {
        return stack.isEmpty();
    }

    private void copy(Stack<Integer> a, Stack<Integer> b) {
        while (a.size() != 0) {
            b.push(a.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */