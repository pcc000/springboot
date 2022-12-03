package com.blackfish.java.suanfa.reversePolishNotation;

import com.blackfish.java.util.common.JsonUtil;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

public class ReversePolishNotation {

    private Map<String,Integer> operatorMap = new HashMap<>();

    {
        operatorMap.put("+",10);
        operatorMap.put("-",10);
        operatorMap.put("/",20);
        operatorMap.put("*",20);
    }

    public List<String> getSufix(String str){
        List<String> result = new ArrayList<>();
        if(StringUtils.isEmpty(str)){
            return result;
        }
        Stack<String> stack = new Stack<>();
        //处理多位数
        StringBuilder multiNum = new StringBuilder();
        for(int i=0;i<str.length();i++){
            System.out.println("current str:"+String.valueOf(str.charAt(i)));
            System.out.println("result str:"+JsonUtil.toJson(result));
            System.out.println("stack :"+ JsonUtil.toJson(stack));
            System.out.println("============================================");

            //如果是操作符
            if(str.charAt(i) <48 || str.charAt(i)> 57){
                if(CollectionUtils.isEmpty(stack)){
                    stack.push(String.valueOf(str.charAt(i)));
                }else{
                    String top = stack.peek();
                    if("(".equals(String.valueOf(str.charAt(i))) || top.equals("(")){
                        stack.push(String.valueOf(str.charAt(i)));
                        continue;
                    }
                    if(")".equals(String.valueOf(str.charAt(i)))){
                        while (!top.equals("(")){
                            result.add(stack.pop());
                            top = stack.peek();
                        }
                        stack.pop();
                        continue;
                    }
                    if(operatorMap.get(String.valueOf(str.charAt(i))) > operatorMap.get(top)){
                        stack.push(String.valueOf(str.charAt(i)));
                    }else{
                        while (!stack.isEmpty() && !(operatorMap.get(String.valueOf(str.charAt(i))) > operatorMap.get(top))){
                            top = stack.pop();
                            result.add(top);
                        }
                        stack.push(String.valueOf(str.charAt(i)));
                    }
                }
            }else{
                multiNum.setLength(0);
                while (i < str.length() && str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    multiNum.append(str.charAt(i));
                    i++;
                }
                // 注意：这里要进行 i-- 操作退回上一个索引，不然外层for循环还会进行 i++ 的操作，这样会跳过表达式字符
                i--;
                result.add(multiNum.toString());
            }
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        ReversePolishNotation polish = new ReversePolishNotation();
        System.out.println(polish.getSufix("8+(6-1)*2+10/2"));
    }
}
