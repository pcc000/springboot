package com.blackfish.java.suanfa;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/10 17:19
 * @Description:
 */
public class Palindrome {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String str = String.valueOf(x);
        int start =0,end = str.length()-1;
        while(end > start){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if(x<0) return false;
        int reverse =0;
        int nums = x;
        while(nums != 0){
            reverse = reverse * 10 + nums % 10;
            nums = nums/10;
        }
        return reverse==x;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome1(121));

        int nums =120;
        int reverse =0;
        while(nums != 0){
            reverse = reverse*10 + nums%10;
            nums = nums/10;
        }
        System.out.println(reverse);
    }
}
