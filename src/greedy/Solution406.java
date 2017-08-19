package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* 大意：
 * 假设你有一个随机的人员排队队列。 每个人由一对整数（h，k）描述，其中h是人的高度，k是具有高度大于或等于h的这个人面前的人数。 
 * 编写一个重构队列的算法。
 * 例如：
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * */

public class Solution406 {
	
	/* MSD算法。
	 * 根据高度对数组进行降序排列（如果高度相同，对K进行升序排列）。
	 * 先选出最高的。（以后每一次也是先选出最高的）
	 * 当插入下一位高个子时，只需要插入他的第k位
	 * 重复，直到所有人都插入列表
	 * */
	
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];	// h降序，k升序
           }
        });
        List<int[]> res = new ArrayList<int[]>();
        for (int[] cur : people){
            res.add(cur[1], cur);       
        }
        return res.toArray(new int[people.length][]);
    }
}
