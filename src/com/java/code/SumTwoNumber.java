package src.com.java.code;

import java.util.Arrays;

public class SumTwoNumber {
    public static int[] twoSum(int[] nums, int target) {
        int[] numsOutput = new int[2];
       outerLoop:
        for(int i=0;i<nums.length;i++){
            for(int j = i+1; j<nums.length; j++){

            if(nums[i]+nums[j]==target){
                numsOutput[0]=i;
                numsOutput[1]=j;
                break outerLoop;
            }
            }
        }
        return numsOutput;
    }



public static void main(String[] args) {
   // Input: nums = [2,7,11,15], target = 9
   // int target = 9;
    int target = 10;
   // int[] numsOne = new int[]{2, 7, 11, 15};
    int[] numsSecond = new int[]{2,5,5,11};
    int arr[]=twoSum(numsSecond,target);
    System.out.println(Arrays.toString(arr));
    }
}
