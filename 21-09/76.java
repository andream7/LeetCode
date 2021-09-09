/**
算法要点：双指针
1. cnt维护的是字符串 s 的[j, i]区间中满足t子字符串中元素的个数
2. hs哈希表维护的是[j, i]区间中各个字符出现多少次，ht哈希表维护的是t字符串中各个字符出现的次数
3. 枚举过程中，将s[i]加入到hs中，同时观察s[j]是否多余，多余则移出
4. 同时，将s[i]加入到hs中时，若hs[i] <= ht[i], 表示多了一个满足条件的元素，cnt++
5. 若当前双指针维护的窗口满足个数要求，则更新答案
 */

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }

        String res = "";
        // 统计符合条件的个数
        int cnt = 0;
        for (int i = 0, j = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0) + 1);
            // 如果t中也存在并且个数小于s中的个数
            if (ht.containsKey(c) && hs.get(c) <= ht.get(c)) {
                cnt++;
            }
            // 移动双指针
            // 两个条件
            // 1. ht中不存在j指向的元素
            // 2. hs中j对应的元素个数
            while(j <= i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j ++;
            }
            
            if(cnt == t.length() && (res.length() < 1 || (i - j + 1) < res.length()) ){
                res = s.substring(j, i+1);
            }
        }
        return res;
    }
}