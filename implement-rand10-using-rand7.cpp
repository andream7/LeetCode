// The rand7() API is already defined for you.
// int rand7();
// @return a random integer in the range 1 to 7

class Solution {
public:
    int rand10() {
  
            int a = rand7(), b = rand7();
            while (a > 4 && b < 4 ) {

                a = rand7(), b = rand7();
                
            }
            return (a + b) % 10 + 1;

    }
};

// 枚举如下：
// 	a	1	2	3	4	5	6	7
// b								
// 1		2	3	4	5	6	7	8
// 2		3	4	5	6	7	8	9
// 3		4	5	6	7	8	9	0
// 4		5	6	7	8	9	0	1
// 5		6	7	8	9	0	1	2
// 6		7	8	9	0	1	2	3
// 7		8	9	0	1	2	3	4
// 去掉右上角的  
// 6	7	8
// 7	8	9
// 8	9	0      后

// 每个数字的出现次数为4次，0-9的概率相同
