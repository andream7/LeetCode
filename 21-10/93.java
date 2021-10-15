class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        // 1表示是ip地址的第一段
        // 最后一个是符合条件的ip地址
        search(s, 1, "");
        return result;
        
    }
    // ipAdder保存一个符合条件的ip地址
    // 最后会将ipAddr加入到result结果集中
    public void search(String s, int n, String ipAddr) {
        // 已经遍历过前四段并且字符串的长度为 0
         if (n == 5 && s.length()== 0) {
             // q去掉末尾的.
             result.add(ipAddr.substring(0, ipAddr.length() - 1));
             return;
         }
         if (n >= 5) {
             return;
         }
         // 剩余ip段的个数
         int remain = 5 - n;
         // 剩余的数字个数小于需要的段个数
         // 或者剩余的段个数*3小于剩余的数字个数
         // 都是不满足条件的情况
         if (s.length() < remain || s.length() > 3 * remain){
             return;
         }
         // 前一段定下之后。针对这个段有三种情况可以讨论
         for (int i = 1; i <= 3; i ++) {
             // 边界情况，剩余的个数已经不足要讨论情况需要的个数
             if (s.length() < i) {
                 return;
             }
             // 截取子字符串
             String part = s.substring(0, i);
             // 把字符串转换为int，判断数字的大小是否在255范围内
             int num = Integer.valueOf(part);

            // 判断part是否有前置0
             if (part.length() != String.valueOf(num).length()) {
                 return;
             }
             if (num > 255) {
                 return;
             }
            // 递归从i开始的子字符串
            search(s.substring(i), n + 1, ipAddr + part + ".");
         }
    }
}