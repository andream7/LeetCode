算法关键：栈

从前往后枚举每个字符
1、当遇到左括号，则将元素压进栈中
2、当遇到右括号时
- 如果栈为空，return false
- 如果栈顶元素是对应的左括号，说明这是匹配的符号，将栈顶元素pop出即可，
- 否则，表示不匹配，return false
3、最后，若栈是空栈，表示所有字符都已经匹配好了，若不是空栈，表示还存在未能匹配好的子符
注意：由于 '{' 和 '}' 以及 '(' 和 ')' 他们的字符数值只相差1，而 '[' 和 ']' 的字符数值只相差2，因此还可以通过这个特性简化代码，


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0;i < s.length();i ++)
        {
            char t = s.charAt(i);
            if(t == '(' || t == '{' || t == '[' ) stk.add(t);
            else
            {
                if(stk.isEmpty()) return false;
                if (stk.peek() == '(' && t == ')') stk.pop();
                else if (stk.peek() == '[' && t == ']') stk.pop();
                else if (stk.peek() == '{' && t == '}') stk.pop();
                else return false;
            }
        }
        return stk.isEmpty();
    }
}

// 简化版
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0;i < s.length();i ++)
        {
            char t = s.charAt(i);
            if(t == '(' || t == '{' || t == '[') stk.add(t);
            else
            {
                if(!stk.isEmpty() && Math.abs(stk.peek() - t) <= 2) stk.pop();
                else return false;
            }
        }
        return stk.isEmpty();
    }
}