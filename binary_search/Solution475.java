package binary_search;

import java.util.Arrays;

/* 大意：
 * 冬天要来了！今天比赛的第一个任务就是设计加热器温暖房屋。
 * 给定一组排列在水平线上的房屋和加热器，计算最小的加热器半径，使得所有房屋都可以被覆盖。
 * 输入房屋和加热器的坐标，输出期望的加热器半径的最小值。
 * 注意：
 * 1.房屋和加热器的数目均为非负整数，并且不大于25000
 * 2.房屋和加热器的位置是非负整数，并且不超过10^9
 * 3.位于加热器半径范围内的房屋均可被加热
 * 4.加热器的半径都是一样的
 * 
 * 例如：
 * 输入：[1,2,3],[2]
 * 输出：1，解释只在位置2放置了加热器，但是使用半径1就可以加热所有的房屋
 * 
 * 输入：[1,2,3,4],[1,4]
 * 输出：1，解释在位置1和4放置了加热器，使用半径1即可加热所有的房屋
 * */

public class Solution475 {
	
	/* 在每个house的左边和右边找到最近的取暖器，然后在左边和右边的取暖器中找出个最小半径。
	 * 最后再在所有house的最小半径中，找出一个最大值，就可以保证所有house都能取暖了。
	 * 创建两个新数组，表示每个house的左边和右边取暖器的坐标
	 * */
	
	/*public int findRadius(int[] houses, int[] heaters) {
	    Arrays.sort(houses);
	    Arrays.sort(heaters);
	    int left = 0, right = heaters.length - 1;
	    int[] lefts = new int[houses.length];
	    int[] rights = new int[houses.length];
	    for (int i = 0; i < houses.length; i++) {
	        while (left < heaters.length && heaters[left] <= houses[i]) {	//注意这里left的判断条件
	            lefts[i] = left + 1;
	            left++;
	        }
	        left = lefts[i] != 0 ? (lefts[i] - 1) : 0;
	        while (right >= left && heaters[right] >= houses[i]) {	//注意这里right的判断条件
	            rights[i] = right + 1;
	            right--;
	        }
	        right = heaters.length - 1;
	    }	    
	    int res = 0;
	    for (int i = 0; i < houses.length; i++) {
	        int min = Integer.MAX_VALUE;
	        if (lefts[i] != 0) {
	            min = Math.min(houses[i] - heaters[lefts[i] - 1], min);
	        }
	        if (rights[i] != 0) {
	            min = Math.min(heaters[rights[i] - 1] - houses[i], min);
	        }
	        res = Math.max(min, res);
	    }
	    return res;
	}*/
	
	/* 我们可以用二分查找法来快速找到第一个大于等于当前house位置的数，
	 * 如果这个数存在，那么我们可以算出其和house的差值，并且如果这个数不是heater的首数字，我们可以算出house和前面一个数的差值，
	 * 这两个数中取较小的为cover当前house的最小半径，然后我们每次更新结果res即可
	 * */
	
	public int findRadius(int[] houses, int[] heaters) {
	    Arrays.sort(heaters);
	    int res = 0;
	    for (int house : houses) {
	        int index = Arrays.binarySearch(heaters, house);
	        if (index < 0) {
	            index = ~index;
	            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

	            res = Math.max(res, Math.min(dist1, dist2));
	        }
	    }
	    return res;
	}
}
