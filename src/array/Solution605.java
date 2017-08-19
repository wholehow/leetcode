package array;

/* 大意：
 * 给定数组flowerbed表示一个花床，0表示位置为空，1表示位置非空。
 * 花不能相邻种植，即不能出现相邻的1。
 * 给定想要种植的花朵数目n，判断是否可以满足要求。
 * */

public class Solution605 {
	
	/* 如果有3个连续的零，000，能放几盆花呢？
	 * 其实是要取决约左右的位置的，如果是10001，那么只能放1盆；如果左右是边界的花，那么就能放两盆101。
	 * 所以如果我们想通过计算连续0的个数，然后直接算出能放花的个数，就必须要对边界进行处理。
	 * 那么我们使用上述思路，一次处理三个相邻位置。
	 * 用pre和next特殊处理边界。
	 * */
	
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n <= 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 0) {
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (pre + next == 0) {
                    flowerbed[i] = 1;
                    --n;
                }
            }
        }
        return n <= 0;
    }
}
