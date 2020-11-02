package com.blackfish.java.suanfa.simple;

import java.util.*;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/8 16:19
 * @Description:
 */
public class Simple {
    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为
     * shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     * 示例：
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     * <p>
     * 1 1
     * 1 2
     * 2 2
     * <p>
     * 1 1 1
     * 1 1 2
     * 1 2 2
     * 2 2 2
     * <p>
     * 1 1 1 1
     * 1 1 1 2
     * 1 1 2 2
     * 1 2 2 2
     * 2 2 2 2
     * <p>
     * 1 1 1 1 1
     * 1 1 1 1 2
     * 1 1 1 2 2
     * 1 1 2 2 2
     * 1 2 2 2 2
     * 2 2 2 2 2
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diving-board-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = i * longer + (k - i) * shorter;
        }
        return result;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        return depDFS(root, sum, 0);
    }

    private boolean depDFS(TreeNode root, int sum, int countSum) {
        if (null == root.left && root.right == null) {
            if (sum == root.val + countSum) {
                return true;
            } else {
                return false;
            }
        }
        countSum = countSum + root.val;
        if (null != root.left && depDFS(root.left, sum, countSum)) return true;
        if (null != root.right && depDFS(root.right, sum, countSum)) return true;
        return false;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     * <p>
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (null == countMap.get(nums1[i])) {
                countMap.put(nums1[i], 1);
            } else {
                countMap.put(nums1[i], countMap.get(nums1[i]) + 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (null != countMap.get(nums2[i]) && countMap.get(nums2[i]) > 0) {
                resultList.add(nums2[i]);
                countMap.put(nums2[i], countMap.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && target > nums[i] && target < nums[i + 1]) return i + 1;
            if (nums[i] == target) return i;
        }
        return 0;
    }


    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (null != map.get(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return new int[]{};
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：[2,2,2,0,1]
     * 输出：0
     * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];

//        for(int i=0;i<numbers.length;i++){
//            if(numbers[i]<numbers[0]){
//                return numbers[i];
//            }
//        }
//        return numbers[0];
    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * <p>
     * 示例 1:
     * <p>
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * <p>
     * [1,2,3],   [1,2,3]
     * <p>
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:      1          1
     * /           \
     * 2             2
     * <p>
     * [1,2],     [1,null,2]
     * <p>
     * 输出: false
     * 示例 3:
     * <p>
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * <p>
     * [1,2,1],   [1,1,2]
     * <p>
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/same-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && q == null) return true;
        if ((null != p && q == null) || (null != q && p == null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     * <p>
     * 示例 1：
     * 输入：2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * <p>
     * 示例 2：
     * 输入：3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     * <p>
     * 提示：
     * 1 <= N <= 1000
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return false;
    }


    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * 返回 true.
     * <p>
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * 返回 false.
     * <p>
     * 后续挑战 :
     * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isSame = false;
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                    isSame = true;
                    break;
                }
                j++;
            }
            if (!isSame) return false;
        }
        return true;
    }

    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     *
     * 重复出现的子串要计算它们出现的次数。
     *
     * 示例 1 :
     *
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     *
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     *
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * 示例 2 :
     *
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     * 注意：
     *
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int length = s.length();
        int i=0;
        List<Integer> countList = new ArrayList<>();
        while(i<length){
            char c =s.charAt(i);
            int count=0;
            while(i<length && c==s.charAt(i)){
                i++;
                count++;
            }
            countList.add(count);
        }
        int result =0;
        for(int j=1;j<countList.size();j++){
            result = result + Math.min(countList.get(j),countList.get(j-1));
        }
        return result;
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *  
     *
     * 说明：
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet<>();
        for(int j=0;j<nums2.length;j++){
            if(set.contains(nums2[j]) && !resultSet.contains(nums2[j])){
                resultSet.add(nums2[j]);
            }
        }
        int[] result = new int[resultSet.size()];
        int i=0;
        for(Integer s : resultSet){
            result[i++] = s;
        }
        return result;
    }

    public static String printArray(int[] temp){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<temp.length;i++){
            stringBuffer.append(temp[i]).append(",");
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        Simple simple = new Simple();

//        System.out.println(simple.countBinarySubstrings("001101"));
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(printArray(Simple.intersection(nums1,nums2)));

//        int[] num1 = new int[]{2,2,3,5,6};
//
//        System.out.println(simple.minArray(num1));

//        int[] result = simple.twoSum(num1,4);
//
//        for(int i=0;i<result.length;i++){
//            System.out.println(result[i]);
//        }

//        System.out.println(simple.searchInsert(num1,5));
//        int[] num2 = new int[]{9,4,9,8,4};
//
//        int[] reslt = simple.intersect(num1,num2);
//        for(int i=0;i<reslt.length;i++){
//            System.out.print(reslt[i]+" ");
//        }


//        int[] nums = simple.divingBoard(2,2,3);
//        for(int i=0;i<nums.length;i++){
//            System.out.print(nums[i]+" ");
//        }
//        TreeNode root = new TreeNode(5);
//        TreeNode left = new TreeNode(4);
//        root.left = left;
//        TreeNode left1 = new TreeNode(11);
//        TreeNode left1left = new TreeNode(7);
//        TreeNode left1right = new TreeNode(2);
//        left1.left = left1left;
//        left1.right = left1right;
//        left.left = left1;
//
//
//        TreeNode right = new TreeNode(8);
//        root.right = right;
//
//        TreeNode rightleft = new TreeNode(13);
//        TreeNode right2 = new TreeNode(4);
//        right.left=rightleft;
//        right.right= right2;
//
//        TreeNode right3 = new TreeNode(1);
//
//        right2.right = right3;
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;


        System.out.println(simple.isSameTree(root, root));


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}