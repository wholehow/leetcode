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
 * һ����2�ű�ѡ�γ̡�Ҫѡ��γ�1����������ɿγ�0�������ȷ�Ŀγ�˳����[0,1]��
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * һ����4�ű�ѡ�γ̡�Ҫѡ��γ�3����������ɿγ�1��2�����γ�1��2����Ҫ������γ�0����ѡ�����һ����ȷ�Ŀγ�˳����[0,1,2,3]����һ����ȷ��˳����[0,2,1,3]��
 * ��ʾ��
 * 1.������ȼ����ж�����ͼ���Ƿ��л���������ڻ�·���޷������������Ҳ�Ͳ������������еĿγ̡�
 * 2.��ʾͼ�ķ����м��֡����磬�����е����޿γ̾�����һ��ߵķ�ʽ��ʾͼ������ͼ�ı�ʾ����������
 * 3.ͨ��DFSʵ�ֵ���������Cousera��һ��21���ӵ���Ƶ�̳̺ܺõĽ�������������Ļ��������������Ҳ����ͨ��BFS��ɡ�
 */

public class Solution210 {
	
	/* ���Ȳ���207BFS��
	 * */
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], order = new int[numCourses];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        // ��ͼ�ι�ϵת��Ϊ�ٱ��б��ϵ
        for (int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++){
        	// ���γ���ӵ�order��queue�У���Ϊ��û���Ⱦ�����
            if (inDegree[i] == 0){
            	order[idx++] = i;
                queue.offer(i);
            }
        }
        // �����ж����ſγ̲���Ҫ�Ⱦ�����
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();	// �Ѿ������������޿γ�
            for (int i = 0; i < prerequisites.length; i++){
            	if (prerequisites[i][1] == prerequisite) {
            		inDegree[prerequisites[i][0]]--;	// ��Ϊ�Ѿ���ɣ�ÿ����ȼ���1
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
