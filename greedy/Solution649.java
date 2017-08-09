package greedy;

import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * Dota2��������������������ڰ������ó���������Ժ�Ĳ���ԱҲ���������������������ڲ���Ա�Ǿ���Ҫ��Data2�����ı䣬��Ȼÿ������ϣ���ĸı��ǲ�һ���ģ���ҪͶƱ������
 * ͶƱ��һ���غ��Ƴ�����ÿһ���У�ÿ������Ա��������ʹ����Ȩ��֮һ��һ��Ȩ��������һ�������Ĳ���Ա����һ���Լ��Ժ��ÿһ��û���κ�Ȩ������һ�����ڲ������ֻʣһ�������Ĳ���Ա��Ȩ����ʱ��������������ʤ����
 * ����һ������ÿ������Ա���ɹ������ַ�����ֻ����������ĸ��R��D��R����Radiant��D����Dire�������n������Ա��ô�ַ����ĳ��Ⱦ�Ϊn��
 * �غ��Ƴ���ӵ�һ������Ա��ʼ�������һ��ָ���Ĳ���Ա��������򽫳�����ͶƱ����������ʧȥȨ���Ĳ���Ա�����ڳ����б�������
 * ����ÿ������Ա���㹻��������Ϊ�Լ��ĵ����˷�����õĲ��ԣ�����ҪԤ����һ������������ʤ������DOTA2��Ϸ�ı仯�����Ӧ���Ƿ������µġ�
 * */

public class Solution649 {
	
	/* ��ֱ�����Ķ�����⡣
	 * ÿ������ԱR�����ֹ������һ������Ĳ���ԱD������D����ֹ����һ������ԱR��
	 * �뷨��ʹ���������зֱ��R��D�ĸ�������ÿ������Ա�������� ��ÿ���У�����ɾ������ֹ�Ĳ���Ա����; ������ʣ��Ĳ���Աָ��Ϊn��������������ĳ��ȣ���Ȼ�����ƶ�������Ӧ���еĺ��档
	 * */
	
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<Integer>(), dQueue = new LinkedList<Integer>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
        	if (senate.charAt(i) == 'R') rQueue.add(i);
        	else dQueue.add(i);
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
        	// ע�������˳���ǴӺ���ǰ�����ʹ��˫�˶��У��ǿ���ʹ��pollFirst������
        	int rIdx = rQueue.poll(), dIdx = dQueue.poll();
        	if (rIdx < dIdx) rQueue.add(rIdx + len);
        	else dQueue.add(dIdx + len);
        }
        return rQueue.size() > dQueue.size() ? "Radiant" : "Dire";
    }
}
