package com.blackfish.java.suanfa.middle;

import com.blackfish.java.util.common.JsonUtil;
import sun.text.normalizer.Trie;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/28 18:55
 * @Description:
 */
public class Middle {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     * 示例: 
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * 进阶:
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==1){
            return nums[0]>=s ? 1 : 0;
        }
        int result =0;
        for(int i=0;i<nums.length;i++){
            int k = i,sum =0;
            while(k<nums.length){
                sum = sum + nums[k];
                if(sum>=s){
                    result = result ==0 ? (k-i+1) : Math.min(result,k-i+1);
                    break;
                }
                k++;
            }

        }
        return result;
    }


    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {




        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * 示例 1:
     * 输入:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出: 3
     * 解释:
     * 长度最长的公共子数组是 [3, 2, 1]。
     * 说明:
     *
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param A
     * @param B
     * @return
     */
    public int findLength1(int[] A, int[] B) {
        if(A.length==0 || B.length==0) return 0;
        int result =0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int k=0;
                while(i+k<A.length && j+k<B.length && A[i+k]==B[j+k]){
                    k++;
                    result = Math.max(k,result);
                }

            }
        }
        return result;
    }

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        int result =0;
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j] =dp[i-1][j-1]+1;
                    result = Math.max(result,dp[i][j]);
                }
            }
        }

        return result;
    }


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     *
     *
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * 说明：m 和 n 的值均不超过 100。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dynamicProgramCount = new int[obstacleGrid[0].length][obstacleGrid.length];
        dynamicProgramCount[0][0]=1;
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[i].length;j++){

            }
        }
        return 0;
    }


    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     *  
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * f[i][j] 标识到位置（i,j）的最小路径
     * f[i][j] = min(f[i-1][j-1],f[i-1][j]) + c[i][j]
     *  
     *
     * 说明：
     *
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] f = new int[triangle.size()][triangle.size()];
        f[0][0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j-1<0){
                    f[i][j] = triangle.get(i).get(j) + f[i-1][j];
                }else if(i==j){
                    f[i][j] = triangle.get(i).get(j) + f[i-1][j-1];
                }else{
                    f[i][j] = triangle.get(i).get(j) + Math.min(f[i-1][j],f[i-1][j-1]);
                }

            }
        }
        int min = f[triangle.size()-1][0];
        for(int i=1;i<f[triangle.size()-1].length;i++){
            min = Math.min(min,f[triangle.size()-1][i]);
        }
        return min;
    }

    /**
     * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：9
     * 示例 2：
     *
     * 输入：grid = [[1,1,0,0]]
     * 输出：1
     *
     *  1 1 1 1
     *  1 0 0 1
     *  1 0 0 1
     *  1 1 1 1
     * 提示：
     *
     * 1 <= grid.length <= 100
     * 1 <= grid[0].length <= 100
     * grid[i][j] 为 0 或 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-1-bordered-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int largest1BorderedSquare(int[][] grid) {
        int maxLength = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int currLength = maxLength;
                    while(i+currLength < grid.length && j+currLength<grid[i].length){
                        boolean leftFlag = true;
                        for(int temp_i=i,temp_j=j;temp_i<i+currLength+1 && temp_j<j+currLength+1;temp_i++,temp_j++){
                            if(grid[temp_i][j]==0 || grid[i][temp_j]==0){
                                leftFlag = false;
                                break;
                            }
                        }
                        if(!leftFlag) break;

                        boolean rightFlag = true;
                        for(int temp_i = i+currLength,temp_j=j+currLength,_i=temp_i,_j=temp_j;temp_i>i && temp_j>j;temp_i--,temp_j--){
                            if(grid[temp_i][_j]==0 || grid[_i][temp_j]==0){
                                currLength++;
                                rightFlag =false;
                                break;
                            }
                        }
                        if(!rightFlag) continue;
                        maxLength = ++currLength;
                    }
                }
            }
        }
        return maxLength * maxLength;
    }



    /**
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
     * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
     * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
     * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     *
     * 示例：
     *
     * 输入：
     * dictionary = ["looked","just","like","her","brother"]
     * sentence = "jesslookedjustliketimherbrother"
     * 输出： 7
     * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     * 提示：
     *
     * 0 <= len(sentence) <= 1000
     * dictionary中总字符数不超过 150000。
     * 你可以认为dictionary和sentence中只包含小写字母
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/re-space-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        return 0;
    }


    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
            for(int j=1;j<grid[i].length;j++){
                if(i-1>=0 & j-1>=0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {

        Middle middle = new Middle();

        int[][] grid = new int[][]{{1}};
        System.out.println(middle.minPathSum(grid));


//        List<Integer> list1 = Arrays.asList(2);
//        List<Integer> list2 = Arrays.asList(3,4);
//        List<Integer> list3 = Arrays.asList(6,5,7);
//        List<Integer> list4 = Arrays.asList(4,1,8,3);
//        List<List<Integer>> numList = Arrays.asList(list1,list2,list3,list4);
//        System.out.println(middle.minimumTotal(numList));



//        int[] nums = new int[]{2,3,1,2,4,3};
//        System.out.println(middle.minSubArrayLen(4,nums));
//        int[] nums1 = new int[]{1,3,5,7,9,2,6};
//        Arrays.sort(nums1);
//        System.out.println(JsonUtil.toJson(nums1));
//        System.out.println(middle.findKthLargest(nums1,3));
//        System.out.println(Arrays.binarySearch(nums1,6));
//        int[] A = new int[]{1,3,3,2,1};
//        int[] B = new int[]{3,2,1,4,7};
//        int[][] s = new int[][]{{1,2,3,4},{1,2,3,5}};
//        System.out.println(s[0].length);
//        System.out.println(s.length);

//        System.out.println(middle.findLength(A,B));

    }
}
