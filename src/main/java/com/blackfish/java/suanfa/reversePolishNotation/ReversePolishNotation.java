package com.blackfish.java.suanfa.reversePolishNotation;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class ReversePolishNotation {

    private Map<String,Integer> operatorMap = new HashMap<>();

    {
        operatorMap.put("+",10);
        operatorMap.put("-",10);
        operatorMap.put("/",20);
        operatorMap.put("*",20);
    }

    /**
     * 中缀表达式转后缀表达式
     * @param str
     * @return
     */
    public Queue<String> getSufix(String str){
        Queue<String> resultQueue = new ArrayDeque<>();
        if(StringUtils.isEmpty(str)){
            return resultQueue;
        }
        Stack<String> stack = new Stack<>();
        //处理多位数
        StringBuilder multiNum = new StringBuilder();
        for(int i=0;i<str.length();i++){
            //如果是操作符
            if(str.charAt(i) <48 || str.charAt(i) > 57){
                if(CollectionUtils.isEmpty(stack)){
                    stack.push(String.valueOf(str.charAt(i)));
                }else{
                    String top = stack.peek();
                    //暂定或当前是( 直接入栈
                    if("(".equals(String.valueOf(str.charAt(i))) || top.equals("(")){
                        stack.push(String.valueOf(str.charAt(i)));
                        continue;
                    }
                    //碰到)  直接出栈 到最近一个(
                    if(")".equals(String.valueOf(str.charAt(i)))){
                        while (!top.equals("(")){
                            resultQueue.add(stack.pop());
                            top = stack.peek();
                        }
                        stack.pop();
                        continue;
                    }
                    if(operatorMap.get(String.valueOf(str.charAt(i))) > operatorMap.get(top)){
                        stack.push(String.valueOf(str.charAt(i)));
                    }else{
                        //当前数字 优先级不大于栈顶  一直出栈 直到大于为止
                        while (!stack.isEmpty() && !(operatorMap.get(String.valueOf(str.charAt(i))) > operatorMap.get(top))){
                            top = stack.pop();
                            resultQueue.add(top);
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
                resultQueue.add(multiNum.toString());
            }
        }
        while (!stack.isEmpty()){
            resultQueue.add(stack.pop());
        }
        return resultQueue;
    }


    public Integer caculate(Queue<String> suffixExpre){
        if(CollectionUtils.isEmpty(suffixExpre)){
            return 0;
        }
        Stack<String> numStack = new Stack<>();
        while(!suffixExpre.isEmpty()){
            String str = suffixExpre.poll();
            if(operatorMap.keySet().contains(str)){
                Integer num1 = Integer.valueOf(numStack.pop());
                Integer num2 = Integer.valueOf(numStack.pop());
                Integer res = 0;
                switch (str){
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                }
                numStack.push(res.toString());
            }else{
                numStack.push(str);
            }
        }
        return Integer.valueOf(numStack.pop());
    }

    public static void main(String[] args) {
        ReversePolishNotation polish = new ReversePolishNotation();
        System.out.println(polish.getSufix("8+(6-1)*2+10/2"));
        System.out.println(polish.caculate(polish.getSufix("8+(6-1)*2+10/2")));
    }
}
