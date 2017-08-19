package dp;

/* ���⣺
 * �����ַ���s�ǡ�abcdefghijklmnopqrstuvwxyz�������޻����ַ���������s��������ʾ����... zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd ....����
 * ������������һ���ַ���p����Ĺ������ҳ�p�д��ڶ���Ψһ�ķǿ��Ӵ����ر�أ�����������ַ���p������Ҫ���ַ���s�����p�Ĳ�ͬ�ǿ��Ӵ�����Ŀ��
 * ���磺
 * ���룺"a"
 * �����1��ֻ���ַ�����a�����Ӵ���a�����ַ���s�С�
 * ���룺"cac"
 * �����2���ַ���s�е��ַ�����cac�����������ַ�����a������c����
 * ���룺"zab"
 * �����6���ַ���s�е��ַ�����zab�����������ַ�����z������a������b������za������ab������zab����
 * */

public class Solution467 {
	
	/* ֻҪp�ǿճ��Ȳ�Ϊ0����ô������һ�������len������ֵΪ1��
	 * ����p����Сд��ĸ��������ĸ��alphabets=new int[26]��Ԣ����ÿ����ĸ��β��ʱ�򾿾������ö��ٸ��ǿ��Ӵ���
	 * ����ж�za���֣�(z+1)%26һ����õ�a��
	 * */
	
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
        	return 0;
        }
        int len = 1;
        int[] alphabets = new int[26];
        // ��ʼ��alphabets��һ��λ��
        alphabets[p.charAt(0) - 'a'] = 1;
        // ��Ϊsѭ����ֻҪ��ǰλ������������ô��֮ǰ����λ�ö�������������len�������ӣ��������ǰλ�ò�����������˵����Ҫ���¼���
        for (int i = 1; i < p.length(); i++) {
        	int curr = p.charAt(i) - 'a';
        	int prev = p.charAt(i - 1) - 'a';
        	if ((prev + 1) % 26 == curr) {
        		len++;
        	} else len = 1;	
        	// �Ե�ǰλ�ý�β�Ӵ��ĸ���
        	alphabets[curr] = Math.max(alphabets[curr], len);
        }
        int res = 0;
        for (int a : alphabets)
        	res += a;
        return res;
    }
}
