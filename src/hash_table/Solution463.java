package hash_table;

/* ���⣺
 * ����һ����ά����������ʽ�ĵ�ͼ������1��ʾ���أ�0��ʾˮ������Ԫˮƽ/��ֱ�����Խ��ߣ����ӡ�
 * ������ȫ��ˮ��Χ������������һ����������һ���������ӵĵ��浥Ԫ��������û�С���������ˮ��û�����ӵ����ϵ�ˮ����
 * ÿ����Ԫ���Ǿ��б߳�Ϊ1�������Ρ�����Ϊ���Σ���Ⱥ͸߶Ȳ�����100��ȷ�������ܳ���
 * ���磺[[0,1,0,0],
 		[1,1,1,0],
 		[0,1,0,0],
 		[1,1,0,0]]
 		���ӦΪ16��
 * */

public class Solution463 {
	
	/* Hash��������д���Ժ���
	 * ��������ܳ����������
	 * ��ͳɨ�跨����islands��¼��������neighbors��¼���е���������
	 * �����ҵ����еĵ��죬islands++��Ȼ���жϵ�ǰ������·����ҷ��Ƿ�����ھ�neighbors++��
	 * Ȼ��islands*4 - neighbors*2�������Ľ����ÿ��island����4���ߣ�ÿһ�����ڶ���ȥ���������ڵıߡ�
	 * */
	
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        	return -1;
        }
        int islands = 0, neighbors = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
        		if (grid[i][j] == 1) {
        			islands++;	//���㵺����
        			// ����ֱ���²��ھ�
            		if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            			neighbors++;
            		}
            		// ����ֱ���Ҳ��ھ�
            		if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
            			neighbors++;
            		}
        		}

        	}
        }
        return islands * 4 - neighbors * 2;
    }
}
