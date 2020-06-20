package com.blackfish.java.suanfa;

import com.blackfish.java.util.common.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/11 11:50
 * @Description:
 */
public class DailyExise {

    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            for(int j=i+1;j<T.length;j++){
                if (T[j]>T[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     *
     *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个
     *  整数，并返回他们的数组下标。
     *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *  示例:
     *  给定 nums = [2, 7, 11, 15], target = 9
     *  因为 nums[0] + nums[1] = 2 + 7 = 9
     *  所以返回 [0, 1]
     *  https://leetcode-cn.com/problems/two-sum/
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return  new int[]{};
    }

    public static void main(String[] args) {
        DailyExise dailyExise = new DailyExise();
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(JsonUtil.toJson(dailyExise.dailyTemperatures(nums)));
        int[] num = new int[]{2, 7, 11, 15};
        System.out.println(JsonUtil.toJson(dailyExise.twoSum(num,9)));
    }
}
