package com.blackfish.java.suanfa;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/9 09:27
 * @Description:
 */
public class TranslateNum {

    private String numStr;

    /**
     * 给定一个数字，
     * 我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public int translateNum(int num) {
        numStr = Integer.valueOf(num).toString();
        return count(0,numStr.length());
    }

    private int count(int start,int end){
        if(end - start <= 1){
            return 1;
        }
        int count =0;
        count = count + count(start+1,end);
        if(Integer.valueOf(numStr.substring(start,start+2))<=25 && numStr.charAt(start)!='0'){
            count = count + count(start+2,end);
        }
        return count;
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(12258));
    }

}
