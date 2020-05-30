package com.blackfish.java.suanfa;

/**
 * @Auther: shuyiwei
 * @Date: 2020/5/28 20:02
 * @Description:
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringDecoder {

    private Integer sss;

    public StringDecoder(Integer sss) {
        this.sss = sss;
    }

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int p[] = new int [nums.length];
        p[0] = nums[0];
        p[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i< nums.length;i++){
            p[i] = Math.max(p[i-1],p[i-2]+nums[i]);
        }
        return p[p.length-1];
    }

//    public String decodeString(String s) {
//        String result ="";
//        int num =0;
//        for(int i=sss;i<s.length();i++){
//            System.out.println("start"+sss);
//            System.out.println("length "+s.length());
//            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
//                num = num * 10 + s.charAt(sss) - '0';
//            }else if(s.charAt(i)=='['){
//                sss++;
//                System.out.println("[");
//                result = result + multipuly(num,decodeString(s));
//                num =0;
//            }else if(s.charAt(i)==']'){
//                break;
//            }else{
//                result = result + s.substring(i,i+1);
//            }
//            sss++;
//        }
//        System.out.println("result:"+result);
//        return result;
//
//    }

    public String decodeStrings(String s) {
        sss=0;
        return result(s);
    }

    public String result(String s){
        String result ="";
        int num =0;
        while(sss < s.length()){
            if(s.charAt(sss)>='0' && s.charAt(sss)<='9'){
                num = num * 10 + s.charAt(sss) - '0';
            }else if(s.charAt(sss)=='['){
                sss++;
                result = result + multipuly(num,result(s));
                num =0;
            }else if(s.charAt(sss)==']'){
                break;
            }else{
                result = result + s.substring(sss,sss+1);
            }
            sss++;
        }
        return result;
    }

    private String multipuly(int i,String s){
        String str = s;
        for(int j=1;j<i;j++){
            str = str+s;
        }
        return str;
    }

    public static void main(String[] args) {
        String str ="10[a]2[bc]";
//        System.out.println(Integer.valueOf(str.charAt(0)));
//        System.out.println(new StringDecoder().decodeStrings(str));
        StringDecoder stringDecoder = new StringDecoder(0);
        System.out.println(stringDecoder.decodeStrings(str));
        int rob[] = new int[]{2,1,3,10};
        System.out.println(stringDecoder.rob(rob));
    }


}
