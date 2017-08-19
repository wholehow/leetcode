package hash_table;

import java.util.HashSet;

/* 大意：
 * 给定一个具有偶数长度的整数数组，该数组中的不同数字表示不同种类的糖果。每个数字表示相应类型的一个糖果。
 * 你需要将这些糖果数量分配给姐姐和哥哥。返回姐姐可以获得的最多种类的糖果。
 * 例如：
 * 输入：candies = [1,1,2,2,3,3]
 * 输出：3，有三种不同种类的糖果（1,2和3），每种糖果两个。 最佳分配：姐姐有糖果[1,2,3]，哥哥也有糖果[1,2,3]。 姐姐有三种不同的糖果。
 * 输入：candies = [1,1,2,3]，
 * 输出：2，姐姐有糖果[2,3]，兄弟有糖果[1,1]。 姐姐有两种不同的糖果，哥哥只有一种糖果。
 * */

public class Solution575 {
	
	/* 使用HashSet来处理。姐姐要获得种类最多的糖果，也就是要set的大小至少应该是当前数组长度的一半。
	 * 题目给定数组长度还是偶数，这就很好处理了。我们将数组中的元素分别添加进set，由于set的size可能大于数组长度的一半，
	 * 如果大于一半，返回一半；否则返回整个size。
	 * */
	
    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
        	return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
        	set.add(candy);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }
}
