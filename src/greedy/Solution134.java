package greedy;

/* ����Բ��·����N����Ȼ��վ��λ��i����Ȼ��վ����Ϊgas[i]��
 * ����һ������������Ȼ���޵����������Ҵ�iվ������һվi+1�ķ�����cost[i]��
 * ����������Բ��·������һ�Σ�������ʼ����վ�����������򷵻�-1��
 * */

public class Solution134 {
	
	/* ˵���ˣ����������������ܷ�ʵ�ֻ��ε���֧ƽ�⡣
	 * ÿ�����Ǿ����ܵ�ȥ��һվ������������ڻ����0����ֱ�����ǲ��ܣ���������С��0����
	 * Ȼ�����Ǳ��뽫��վ���쵽�����һվ������վǰ����Ѱ�ҿ��ܵĽ���������ظ����������裬ֱ�����Ǽ�������е�վ��start == end����
	 * ֻ�е�ʣ��������ڻ����0ʱ�����ǲ���������С�
	 * */
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;		// �Ӻ���ǰ
        int end = 0;	// ��ǰ����
        int remain = gas[start] - cost[start];		// ��ǰʣ����������
        while (start > end) {
           if (remain >= 0) {
              remain += gas[end] - cost[end];
              ++end;	// remain>0��˵����ǰλ��������������end���Լ����Ƶ���һվ
           }
           else {
        	   --start;
              remain += gas[start] - cost[start];
           }
        }
        return remain >= 0 ? start : -1;
     }
}
