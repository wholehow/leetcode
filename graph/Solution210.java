package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 大意：
 * 一共有n门需要选择的课程，标号为0到n-1。
 * 有些课程可能会有先修课程，例如想要选择课程0，必须首先选过课程1，可以表述为配对：[0,1]
 * 给定课程总数和一组先修课程配对，判断是否可以修完所有的课程。
 * 例如：
 * 2, [[1,0]]
 * 一共有2门备选课程。要选择课程1，必须先完成课程0。因此正确的课程顺序是[0,1]。
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * 一共有4门备选课程。要选择课程3，必须先完成课程1和2。而课程1和2都需要先修完课程0才能选。因此一种正确的课程顺序是[0,1,2,3]。另一个正确的顺序是[0,2,1,3]。
 * 提示：
 * 1.此问题等价于判断有向图中是否有环。如果存在环路，无法完成拓扑排序，也就不可能修完所有的课程。
 * 2.表示图的方法有几种。例如，输入中的先修课程就是用一组边的方式表示图。这种图的表示方法合适吗？
 * 3.通过DFS实现的拓扑排序—Cousera的一段21分钟的视频教程很好的解释了拓扑排序的基本概念。拓扑排序也可以通过BFS完成。
 */

public class Solution210 {
	
	/* 首先参照207BFS。
	 * */
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], order = new int[numCourses];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        // 将图形关系转换为临边列表关系
        for (int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++){
        	// 将课程添加到order和queue中，因为它没有先决条件
            if (inDegree[i] == 0){
            	order[idx++] = i;
                queue.offer(i);
            }
        }
        // 计算有多少门课程不需要先决条件
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();	// 已经完成了这个必修课程
            for (int i = 0; i < prerequisites.length; i++){
            	if (prerequisites[i][1] == prerequisite) {
            		inDegree[prerequisites[i][0]]--;	// 因为已经完成，每次入度减少1
            		if (inDegree[prerequisites[i][0]] == 0){
            			order[idx++] = prerequisites[i][0];
            			queue.offer(prerequisites[i][0]);
            		}
            	}
            }
        }
        return idx == numCourses ? order : new int[0];
    }
}
