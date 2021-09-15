class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        // t用来保存进位
        int t = 0;
        while (n >= 0 || m >= 0) {
            int sum = t;
            if (n >= 0) {
                sum += num1.charAt(n -- ) - '0';
            }
            if (m >= 0) {
                sum += num2.charAt(m -- ) - '0';
            }
            // apped的只有个位数
            res.append(sum % 10);
            // t保存上一位的进位
            t = sum / 10;
        }
        while (t > 0) {
            res.append(t % 10);
            t /= 10;
        }
        return res.reverse().toString();
    }
}