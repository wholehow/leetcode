package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * һ����n����Ҫѡ��Ŀγ̣����Ϊ0��n-1��
 * ��Щ�γ̿��ܻ������޿γ̣�������Ҫѡ��γ�0����������ѡ���γ�1�����Ա���Ϊ��ԣ�[0,1]
 * �����γ�������һ�����޿γ���ԣ��ж��Ƿ�����������еĿγ̡�
 * ���磺
 * 2, [[1,0]]
 * һ����2�ű�ѡ�γ̡�Ҫѡ��γ�1����������ɿγ�0��������ǿ��ܵġ�
 * 2, [[1,0],[0,1]]
 * һ����2�ű�ѡ�γ̡�Ҫѡ��γ�1����������ɿγ�0����Ҫ�޿γ�0����������γ�1��������ǲ����ܵġ�
 * ��ʾ��
 * 1.������ȼ����ж�����ͼ���Ƿ��л���������ڻ�·���޷������������Ҳ�Ͳ������������еĿγ̡�
 * 2.��ʾͼ�ķ����м��֡����磬�����е����޿γ̾�����һ��ߵķ�ʽ��ʾͼ������ͼ�ı�ʾ����������
 * 3.ͨ��DFSʵ�ֵ���������Cousera��һ��21���ӵ���Ƶ�̳̺ܺõĽ�������������Ļ��������������Ҳ����ͨ��BFS��ɡ�
 * */

public class Solution207 {
	
	/* ������ʾ����ɾͺ��ˣ���������ͼDFSʵ����������
	 * �ӿγ�ͼ�е�ÿ���ڵ㿪ʼ�����������Է��ʵ����пγ̡� ��������Ѿ����ʹ��Ŀγ̣�������֪�����������һ��ѭ���� 
	 * ��ע�⣬��dfs�У����ŵݹ�չ�������з���״̬������Ϊfalse�� ��ˣ�ÿ��DFS��canFinish����������ʱ��visited���鶼����֤ȫ��Ϊfalse�� 
	 * �����Ϊʲô���ַ�����Ч��
	 * */
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];	// ����numCourses�趨����ͼ�Ķ�����
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {	// �������ArrayList������
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
    	// ��������������ԭ���ʱ�־
    	visited[course] = false;
    	return true;
    }
    
    /* ��������ͼBFSʵ����������
     * BFS���ýڵ�Ķȡ��������ǳ���Ѱ��һ����Ϊ0�Ľڵ㣬��������������Ľڵ���ͼ��һ���л���ֱ�ӷ���false��
     * ���ǽ����ж�Ϊ0�Ľڵ����Queue������¼���������bfs�г���Ѱ��0�Ƚڵ����е��ھӣ������������ھӵĶȼ���1��
     * һ�����ֶ�Ϊ0���ھӽ���Ҳ����Queue��
     * ����жϽ����count��numCourses�Ĺ�ϵ��
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
