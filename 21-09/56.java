class Solution {
    public int[][] merge(int[][] a) {
        if(a == null || a.length < 2) return a;

        // 排序, lambda 表达式写法
        Arrays.sort(a, (v1,v2)->(v1[0] - v2[0]));

        List<int[]> result = new ArrayList();
        int l = a[0][0], r = a[0][1];
        for(int i = 1; i < a.length; i ++){
            int[] tmp = new int[2];
            if(r >= a[i][0]){
                // r是当前重合部分的最右边
                r = Math.max(r, a[i][1]);
            } else {
                // 下一个区间不再重合
                tmp[0] = l;
                tmp[1] = r;
                result.add(tmp);
                // 更新边界值
                l = a[i][0];
                r = a[i][1];
            }
        }

        //保存最后一个区间
        result.add(new int[]{l, r});

        //转换成结果需要的二维数组形式
        int n = result.size();
        int[][] res = new int[n][2];
        for(int i = 0; i < n; i++){
            res[i] = result.get(i);
        }
        return res;
    }
}