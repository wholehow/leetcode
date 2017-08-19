package binary_search;

/* 大意：
 * 你是一名产品经理，正在领导团队开发一个新产品。不幸的是，产品的最新版本没有通过质量检测。
 * 由于每一个版本都是基于上一个版本开发的，某一个损坏的版本之后的所有版本全都是坏的。
 * 假设有n个版本[1, 2, ..., n]，你想要找出第一个损坏的版本，它导致所有后面的版本都坏掉了。
 * 给你一个API bool isBadVersion(version)，返回某一个版本是否损坏。实现一个函数找出第一个损坏的版本。
 * 你应该最小化调用API的次数。
 * */

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class Solution278 {
	
	/* 由于版本号是从1开始，一直到n，属于增序排列，因此可以采用二分查找的策略，减少比较次数。
	 * 需要注意的是，在取二分查找的中间值时，不要使用左右相加后再除以2的方式，这样可能会在计算时产生溢出。
	 * */
	
    public int firstBadVersion(int n) {        
        if (n <= 0) {
            return 0;
        }
        if (isBadVersion(1)) {
            return 1;
        } else if (!isBadVersion(n)) {
            return Integer.MAX_VALUE;
        }
        int left = 1;
        int right = n;
        int mid;
        while (true) {
            mid = left + (right - left) / 2;	//注意 left + right 有可能超过了整数的最大值
            if (mid == left) {
                return right;
            }
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}
