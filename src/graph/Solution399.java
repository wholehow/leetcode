package graph;

import java.util.HashMap;
import java.util.HashSet;

/* ���⣺
 * ����ʽA / B = k����ʽ�������ɵ�ʽ������A��B�����ַ�����ʾ�ı�����k��ʵ������������������һЩ��ѯ�����ؽ��������𰸲����ڣ����� -1.0��
 * ���룺a / b = 2.0, b / c = 3.0
 * ��ѯΪ��a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * �����[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * ����Ϊ��vector<pair<string, string>> euqations, vector<double>& values, vector<pair<string, string>> query��
 * ���� equations.size() == values.size()��values����������
 * ���������У�
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * ������Զ����Ч�ġ�����Լ����ѯ���������ֳ�������ҵ�ʽ֮�䲻���ڳ�ͻ��
 * */

public class Solution399 {
	
	/* ͼa/b = k��Ϊ�ڵ�a��b֮������ӣ���a��b��Ȩ��Ϊk������Ȩ��Ϊ1/k����ѯ���������ڵ�֮���ҵ�·����
	 * */
	
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
        for (int i = 0; i < equations.length; i++) {
        	// ������ĿҪ��������Ҫ��������ͼ
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new HashMap<String, Double>());
            }
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new HashMap<String, Double>());
            }
            // ��a��b��Ȩ��Ϊk������Ȩ��Ϊ1/k
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	// a��b���������ǹ��������ͼ��
            if (map.containsKey(queries[i][0]) && map.containsKey(queries[i][1])) {
            	// a��b�غ�
                if (queries[i][0] == queries[i][1])
                    res[i] = 1.0;
                else {
                    double tmp = dfs(queries[i][0], queries[i][1], new HashSet<String>(), map, 1.0);
                    res[i] = tmp == 0.0 ? -1.0 : tmp;
                }
            }
         // a��b�����������ǹ��������ͼ��
            else res[i] = -1.0;
        }
        return res;
    }
    
    private double dfs(String s, String t, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map, double val) {
        if (map.get(s).containsKey(t)) 
            return val * map.get(s).get(t);
        double tmp = 0.0;
        for (String neighbor : map.get(s).keySet()) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                tmp = dfs(neighbor, t, visited, map, val * map.get(s).get(neighbor));
                // ΪʲôֻҪtmp��Ϊ0���Ǿͷ����أ���ϸ���룬��������ͼ����a���Ե�b��ζ�Ŵ�bҲһ�����Ե�a
                // ��Ϊ��dfs�������һ�ζ���a������ͼ�����ֱ�����ڵ����ж��㣬��ô֮��λa�������ھ�ʱ�����һ�����ظ�
                // Ҳ����˵�����ս�����ظ�����
                if (tmp != 0.0) break;
            }
        }
        return tmp;
    }
}
