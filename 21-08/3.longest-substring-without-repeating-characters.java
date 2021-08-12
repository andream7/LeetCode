/**

解法：滑动窗口
- 没有重复的字符就不断向右移动
- 有重复是计算左边索引的位置，再移动右指针
 注意，左边指针的移动不能直接找重复字符的下一个位置（因为可能已经被移出滑动窗口了）
- 在移动过程中记录符合要求字符串的长度
 */


/**
    HashMap的做法

 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
/**
    “s 由英文字母、数字、符号和空格组成”，索引考虑用int[]代替HashMap
    时间由5ms->2ms
    
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        // 设置默认值
        Arrays.fill(map, -1);

        int left = 0, right = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            left = Math.max(left, map[c] + 1);
            map[c] = right;
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}