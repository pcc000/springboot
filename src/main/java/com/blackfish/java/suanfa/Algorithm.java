package com.blackfish.java.suanfa;

import com.blackfish.java.util.common.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2019/12/4 14:12
 * @Description:
 */
public class Algorithm {

    private static HashMap<String,String> map;

    static{
        map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        letterCombinationsBackTracking(digits,"",resultList);
        System.out.println(JsonUtil.toJson(resultList));
        System.out.println("num:"+resultList.size());
        return resultList;
    }

    public List<String> letterCombinationsBackTracking(String digits,String numberToLetter,List<String> resultList){
        if(null ==digits || digits.length()==0){
            resultList.add(numberToLetter);
            return resultList;
        }
        String number = map.get(digits.substring(0,1));
        if(null == number){
            return resultList;
        }
        for(int i=0;i<number.length();i++){
            letterCombinationsBackTracking(digits.substring(1),numberToLetter+number.charAt(i),resultList);
        }
        return resultList;
    }

    public List<String> generateParenthesis(int n) {
        long start = System.currentTimeMillis();
        List<String> resultList = new ArrayList<>();
        generateParenthesisBackTracking(resultList,"",0,0,n);
        System.out.println("cost time:"+(System.currentTimeMillis()-start)+"ms");
        System.out.println(JsonUtil.toJson(resultList));
        return resultList;
    }

    public void generateParenthesisBackTracking(List<String> resultList,String cur,int left,int right,int max){
        if(cur.length()==2*max){
            resultList.add(cur);
            return ;
        }
        if(left<max){
            generateParenthesisBackTracking(resultList,cur+"(",left+1,right,max);
        }
        if(right<left){
            generateParenthesisBackTracking(resultList,cur+")",left,right+1,max);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
//        Arrays.sort(candidates);
        combinationSumBackTracking(resultList,new ArrayList<>(),0,candidates,target);
        System.out.println(JsonUtil.toJson(resultList));
        return resultList;
    }

    public void combinationSumBackTracking(List<List<Integer>> resultList,List<Integer> list,int temp,int[] candidates,int target){
        if(target<0) return;
        if(0==target){
            resultList.add(new ArrayList<>(list));
            return ;
        }
        for(int i=temp;i<candidates.length;i++){
            if(candidates[i]<=target){
                list.add(candidates[i]);
                combinationSumBackTracking(resultList,list,i,candidates,target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        new Algorithm().letterCombinations("212");
        new Algorithm().generateParenthesis(4);
        int[]  ints= {6,7,2,3};
        new Algorithm().combinationSum(ints,7);
    }
}
