package Hashing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
	
	/*public static int[] twoSum(int[] numbers,int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<numbers.length;i++) {
			if(map.containsKey(target - numbers[i])) {
				map.put(numbers[i], i);
			}
			else {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
		}
		throw new IllegalArgumentException("Two number not found");
	}*/
	public static int[] twosum(int[] arr,int target) {
		Arrays.sort(arr);
		int left=0,right=arr.length-1;
		int[] result = new int[2];
		while(left<right) {
			int sum = arr[left] + arr[right];
			if(sum == target) {
				result[0] = arr[left];
				result[1] = arr[right];
				return result;
			}
			else if(sum<target) {
				left++;
			}
			else {
				right--;
			}
		}
		return new int[0];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {2,11,5,10,8};
		int[] result = twosum(num,13);
		for(int i: result) {
			System.out.println(i);
		}
		

	}
	

}
