package com.blackfish.java.suanfa.reversePolishNotation;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolishNotation {

    private Map<String,Integer> operatorMap = new HashMap<>();

    {
        operatorMap.put(")",0);
        operatorMap.put("+",10);
        operatorMap.put("-",10);
        operatorMap.put("/",20);
        operatorMap.put("*",20);
        operatorMap.put("(",20);
    }

    public String getSufix(String str){
        if(StringUtils.isEmpty(str)){
            return "";
        }
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<str.length();i++){
            //如果是操作符
            if(str.charAt(i) <48 || str.charAt(i)> 58){
                if(CollectionUtils.isEmpty(stack)){
                    stack.push(String.valueOf(str.charAt(i)));
                }else{
                    String top = stack.peek();
                    if(operatorMap.get(String.valueOf(str.charAt(i))) > operatorMap.get(top)){
                        stack.push(String.valueOf(str.charAt(i)));
                    }else{
                        stringBuilder.append(stack.pop());
                        stack.push(String.valueOf(str.charAt(i)));
                    }
                }
            }else{
                stringBuilder.append(String.valueOf(str.charAt(i)));
            }

        }
        return stringBuilder.toString().replace("(","").replace(")","");
    }

    public static void main(String[] args) {
        ReversePolishNotation polish = new ReversePolishNotation();
        System.out.println(polish.getSufix("1+(2+5)*2-5*3"));
    }
}
