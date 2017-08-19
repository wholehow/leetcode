package graph;

import java.util.HashMap;
import java.util.HashSet;

/* 大意：
 * 以算式A / B = k的形式给出若干等式，其中A和B是以字符串表示的变量，k是实数（浮点数）。给定一些查询，返回结果。如果答案不存在，返回 -1.0。
 * 输入：a / b = 2.0, b / c = 3.0
 * 查询为：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 输出：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 输入为：vector<pair<string, string>> euqations, vector<double>& values, vector<pair<string, string>> query。
 * 其中 equations.size() == values.size()，values总是正数。
 * 根据以上有：
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * 输入永远是有效的。你可以假设查询结果不会出现除零错，并且等式之间不存在冲突。
 * */

public class Solution399 {
	
	/* 图a/b = k作为节点a和b之间的链接，从a到b的权重为k，反向权重为1/k。查询是在两个节点之间找到路径。
	 * */
	
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
        for (int i = 0; i < equations.length; i++) {
        	// 根据题目要求，我们需要构造无向图
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new HashMap<String, Double>());
            }
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new HashMap<String, Double>());
            }
            // 从a到b的权重为k，反向权重为1/k
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	// a和b能纳入我们构造的无向图中
            if (map.containsKey(queries[i][0]) && map.containsKey(queries[i][1])) {
            	// a和b重合
                if (queries[i][0] == queries[i][1])
                    res[i] = 1.0;
                else {
                    double tmp = dfs(queries[i][0], queries[i][1], new HashSet<String>(), map, 1.0);
                    res[i] = tmp == 0.0 ? -1.0 : tmp;
                }
            }
         // a和b不能纳入我们构造的无向图中
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
                // 为什么只要tmp不为0我们就返回呢？仔细想想，对于无向图，从a可以到b意味着从b也一定可以到a
                // 因为是dfs，如果第一次对于a我们试图穷尽和其直观相邻的所有顶点，那么之后方位a的所有邻居时，结果一定会重复
                // 也就是说，最终结果会重复两次
                if (tmp != 0.0) break;
            }
        }
        return tmp;
    }
}
