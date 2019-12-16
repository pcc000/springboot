package com.blackfish.java.suanfa;

import com.blackfish.java.util.common.JsonUtil;

import java.util.*;

/**
 *
 * 回溯算法
 * @Auther: shuyiwei
 * @Date: 2019/12/4 14:12
 * @Description:
 */
public class BackTracking {

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

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * @param digits
     * @return
     */
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

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为
     * @param n
     * @return
     */
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

    /**
     *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
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

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     * 说明：
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2NewBackTracking(resultList,new ArrayList<>(),0,candidates,target);
        System.out.println(JsonUtil.toJson(resultList));
        return resultList;
    }

    public void combinationSum2NewBackTracking(List<List<Integer>> resultList,List<Integer> list,int temp,int[] candidates,int target){
        if(target<0) return;
        if(0==target){
            if(!resultList.contains(list)){
                resultList.add(new ArrayList<>(list));
            }
            return ;
        }
        for(int i=temp;i<candidates.length;i++){
            if(candidates[i]<=target){
                list.add(candidates[i]);
                int[] newCandidates = new int[candidates.length-1];
                for(int j=0;j<newCandidates.length;j++){
                    newCandidates[j]=candidates[j+1];
                }
                combinationSum2NewBackTracking(resultList,list,i,newCandidates,target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    public void combinationSum2BackTracking(List<List<Integer>> resultList,List<Integer> list,int temp,int[] candidates,int target){
        if(target<0) return;
        if(0==target){
            if(resultList.size()==0){
                List<Integer> listTemp = new ArrayList<>(list);
                listTemp.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                resultList.add(new ArrayList<>(listTemp));
                return ;
            }
            boolean notSameflag = false;
            for(List<Integer> lists : resultList){
                if(lists.size()==list.size()){
                    List<Integer> listTemp = new ArrayList<>(list);
                    listTemp.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1-o2;
                        }
                    });
                    boolean f = true;
                    for(int j=0;j<list.size();j++){
                        if(listTemp.get(j)!=lists.get(j)){
                            f = false;
                            break;
                        }
                    }
                    if(!f){
                        notSameflag= false;
                    }else{
                        notSameflag = true;
                        break;
                    }
                }
            }
            if(!notSameflag){
                List<Integer> listTemp = new ArrayList<>(list);
                listTemp.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                resultList.add(new ArrayList<>(listTemp));
                return ;
            }
            return;
        }
        for(int i=temp;i<candidates.length;i++){
            if(candidates[i]<=target){
                list.add(candidates[i]);
                int[] newCandidates = new int[candidates.length-1];
                for(int j=0;j<newCandidates.length;j++){
                    newCandidates[j]=candidates[j+1];
                }
                combinationSum2BackTracking(resultList,list,i,newCandidates,target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        permuteBackTracking(resultList,new ArrayList<Integer>(),list);
        System.out.println(JsonUtil.toJson(resultList));
        return resultList;
    }

    private void permuteBackTracking(List<List<Integer>> resultList,List<Integer> list,List<Integer> nums){
        if(nums.size()==0){
            resultList.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.size();i++){
            list.add(nums.get(i));
            List<Integer> newNums = new ArrayList<>(nums);
            newNums.remove(Integer.valueOf(nums.get(i)));
            permuteBackTracking(resultList,list,newNums);
            list.remove(list.size()-1);
        }
    }

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        long start = System.currentTimeMillis();
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        permuteUniqueBackTracking(resultList,new ArrayList<Integer>(),list);
        System.out.println(JsonUtil.toJson(resultList));
        System.out.println("permuteUnique cost:"+(System.currentTimeMillis()-start)+"ms");
        return resultList;
    }

    private void permuteUniqueBackTracking(List<List<Integer>> resultList,List<Integer> list,List<Integer> nums){
        if(nums.size()==0){
            if(!resultList.contains(list)){
                resultList.add(new ArrayList<>(list));
            }
            return ;
        }

        for(int i=0;i<nums.size();i++){
            list.add(nums.get(i));
            List<Integer> newNums = new ArrayList<>(nums);
            newNums.remove(Integer.valueOf(nums.get(i)));
            permuteUniqueBackTracking(resultList,list,newNums);
            list.remove(list.size()-1);
        }
    }


    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        char[][] input = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                input[i][j] ='.';
            }
        }
        solveNQueensBackTracking(resultList,0,n,input);
        System.out.println(JsonUtil.toJson(resultList));
        return  resultList;
    }

    private void solveNQueensBackTracking(List<List<String>> resultList,int x,int n,char[][] input){
        if(x==n){
            resultList.add(solveNQueensChar2List(input));
            return;
        }
        for(int j=0;j<n;j++){
            if(isValid(input,x,j)){
                input[x][j] = 'Q';
                solveNQueensBackTracking(resultList,x+1,n,input);
                input[x][j] = '.';
            }
        }

    }

    private List<String> solveNQueensChar2List(char[][] input){
        List<String> result = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            result.add(new String(input[i]));
        }
        return result;
    }

    private boolean isValid(char[][] input,int x,int y){
        for(int i=0;i<x;i++){
            for(int j=0;j<input[i].length;j++){
                if(input[i][j]=='Q' &&(Math.abs(x-i)==Math.abs(y-j) || j==y)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * @param n
     * @return 多少种解法
     */
    public int totalNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        char[][] input = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                input[i][j] ='.';
            }
        }
        solveNQueensBackTracking(resultList,0,n,input);
        return  resultList.size();
    }

    public static void main(String[] args) {
        new BackTracking().letterCombinations("212");
        new BackTracking().generateParenthesis(4);
        int[]  ints= {6,7,2,3};
        new BackTracking().combinationSum(ints,7);
        int[] ss = {3,1,3,5,1,1};
        new BackTracking().combinationSum2(ss,8);

        int[] tt = {1,2,3};
        new BackTracking().permute(tt);

        int[] yy ={1,1,2};
        new BackTracking().permuteUnique(yy);

        new BackTracking().solveNQueens(4);
    }
}
