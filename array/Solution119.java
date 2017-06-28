package array;

import java.util.ArrayList;
import java.util.List;

/* ����һ�����k��������������εĵ�k�С�
 * ������� k = 3�� ���� [1,3,3,1]��
 * */

public class Solution119 {
	
	/* �����˼·������118�Ļ����Ͻ����޸ģ�ֻ���ص�rowIndex�е�ArrayList��
	 * */
	
    /*public List<Integer> getRow(int rowIndex) {
    	if (rowIndex < 0) {
    		return new ArrayList<Integer>();
    	}
        List<Integer> resList = new ArrayList<Integer>();
        resList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            for (int j = 1; j < i; j++) {
                newList.add(resList.get(j-1) + resList.get(j));
            }
            newList.add(1);
            resList = newList;
        }
        return resList;
    }*/
	
	/* ͻȻ�뵽DP��ʹ�õ��ľ���ѹ��˼�롣
	 * 
	 * �������������������������γɵġ�
	 * ��k����k��Ԫ��
	 * ÿ���һ���Լ����һ��Ԫ��ֵΪ1
	 * ���ڵ�k��k > 2�����n��n > 1 && n < k����Ԫ��A[k][n]��A[k][n] = A[k-1][n-1] + A[k-1][n]
	 * 
	 * ���䱾�ʣ�ÿ��λ�õ���Ҫô��1��Ҫô����һ���1���ۼӵ���ǰ�С�
	 * Ҳ����˵��ÿ��λ�õ����������ɸ�1����ϣ���������������ϸ�ԳƵġ�
	 * ���Ϊ�����������ֽⷨ�ṩ�˱��ϡ�
	 * */
	
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> resList = new ArrayList<Integer>();
		//��0��λ������1��[1]����ʱΪ��һ�У��������������
		//��ִ��Сѭ��������0��λ������1��[1, 1]����ʱΪ�ڶ��У�������������� 
		//��ִ��Сѭ��������0��λ������1��[1, 1, 1]��ִ��Сѭ������[1, 2, 1]����ʱΪ�����У��������������
		//��ʱ����0��λ������1��[1, 1, 2, 1]��ִ��Сѭ������[1, 3, 3, 1����ʱΪ�����У��������������
		// ����
		//������ȥȷʵ���Եõ�ÿһ�е����ݣ���ʵ������һ��List��ģ��������ǵ�����
		for (int i = 0; i <= rowIndex; i++) {
			resList.add(0, 1);
			for (int j = 1; j < resList.size() - 1; j++) {
				resList.set(j, resList.get(j) + resList.get(j + 1));
			}
		}
		return resList;
	}
}
