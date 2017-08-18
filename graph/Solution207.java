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
 * 一共有2门备选课程。要选择课程1，必须先完成课程0。因此这是可能的。
 * 2, [[1,0],[0,1]]
 * 一共有2门备选课程。要选择课程1，必须先完成课程0，而要修课程0，必须修完课程1。因此这是不可能的。
 * 提示：
 * 1.此问题等价于判断有向图中是否有环。如果存在环路，无法完成拓扑排序，也就不可能修完所有的课程。
 * 2.表示图的方法有几种。例如，输入中的先修课程就是用一组边的方式表示图。这种图的表示方法合适吗？
 * 3.通过DFS实现的拓扑排序—Cousera的一段21分钟的视频教程很好的解释了拓扑排序的基本概念。拓扑排序也可以通过BFS完成。
 * */

public class Solution207 {
	
	/* 根据提示来完成就好了，利用无向图DFS实现拓扑排序
	 * 从课程图中的每个节点开始，遍历随后可以访问的所有课程。 如果遇到已经访问过的课程，那我们知道这里出现了一个循环。 
	 * 请注意，在dfs中，随着递归展开，所有访问状态都设置为false。 因此，每当DFS在canFinish函数中启动时，visited数组都将保证全部为false。 
	 * 这就是为什么这种方法有效。
	 * */
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];	// 根据numCourses设定无向图的顶点数
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {	// 充分利用ArrayList的特性
        	graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
        	if (!dfs(graph, visited, i)) 
        		return false;
        }
        return true;
    }
    
    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
    	if (visited[course]) return false;
    	else visited[course] = true;
    	for (int i = 0; i < graph[course].size(); i++) {
    		if (!dfs(graph, visited, (int)graph[course].get(i))) 
    			return false;
    	}
    	// 上述不成立，还原访问标志
    	visited[course] = false;
    	return true;
    }
    
    /* 利用无向图BFS实现拓扑排序
     * BFS利用节点的度。首先我们尝试寻找一个度为0的节点，如果不存在这样的节点则图中一定有环，直接发挥false。
     * 我们将所有度为0的节点加入Queue，并记录其个数。在bfs中尝试寻找0度节点所有的邻居，并将其所有邻居的度减少1。
     * 一旦出现度为0的邻居将其也加入Queue。
     * 最后判断结果是count和numCourses的关系。
     * */
    
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
            
        for (int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < numCourses; i++){
            if (degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        while (queue.size() != 0) {
            int course = (int)queue.poll();
            for (int i = 0; i < graph[course].size(); i++){
                int neighbor = (int)graph[course].get(i);
                degree[neighbor]--;
                if (degree[neighbor] == 0){
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        return count == numCourses ? true : false;
    }
}
