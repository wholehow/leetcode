package binary_search;

/* ���⣺
 * ����һ����Ʒ���������쵼�Ŷӿ���һ���²�Ʒ�����ҵ��ǣ���Ʒ�����°汾û��ͨ��������⡣
 * ����ÿһ���汾���ǻ�����һ���汾�����ģ�ĳһ���𻵵İ汾֮������а汾ȫ���ǻ��ġ�
 * ������n���汾[1, 2, ..., n]������Ҫ�ҳ���һ���𻵵İ汾�����������к���İ汾�������ˡ�
 * ����һ��API bool isBadVersion(version)������ĳһ���汾�Ƿ��𻵡�ʵ��һ�������ҳ���һ���𻵵İ汾��
 * ��Ӧ����С������API�Ĵ�����
 * */

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class Solution278 {
	
	/* ���ڰ汾���Ǵ�1��ʼ��һֱ��n�������������У���˿��Բ��ö��ֲ��ҵĲ��ԣ����ٱȽϴ�����
	 * ��Ҫע����ǣ���ȡ���ֲ��ҵ��м�ֵʱ����Ҫʹ��������Ӻ��ٳ���2�ķ�ʽ���������ܻ��ڼ���ʱ���������
	 * */
	
    public int firstBadVersion(int n) {        
        if (n <= 0) {
            return 0;
        }
        if (isBadVersion(1)) {
            return 1;
        } else if (!isBadVersion(n)) {
            return Integer.MAX_VALUE;
        }
        int left = 1;
        int right = n;
        int mid;
        while (true) {
            mid = left + (right - left) / 2;	//ע�� left + right �п��ܳ��������������ֵ
            if (mid == left) {
                return right;
            }
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}
