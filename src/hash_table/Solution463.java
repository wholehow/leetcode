package hash_table;

/* 大意：
 * 给出一个二维整数网格形式的地图，其中1表示土地，0表示水。网格单元水平/垂直（不对角线）连接。
 * 网格完全被水包围，并且正好有一个岛（即，一个或多个连接的地面单元）。岛上没有“湖泊”（水内没有连接到岛上的水）。
 * 每个单元格是具有边长为1的正方形。网格为矩形，宽度和高度不超过100。确定岛的周长。
 * 例如：[[0,1,0,0],
 		[1,1,1,0],
 		[0,1,0,0],
 		[1,1,0,0]]
 		结果应为16。
 * */

public class Solution463 {
	
	/* Hash方法不会写，以后补上
	 * 计算的是周长不是面积！
	 * 传统扫描法。用islands记录岛屿数，neighbors记录所有的相邻数。
	 * 首先找到所有的岛屿，islands++；然后判断当前岛屿的下方和右方是否存在邻居neighbors++。
	 * 然后islands*4 - neighbors*2就是最后的结果（每个island都有4条边，每一次相邻都会去掉两条相邻的边。
	 * */
	
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        	return -1;
        }
        int islands = 0, neighbors = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
        		if (grid[i][j] == 1) {
        			islands++;	//计算岛屿数
        			// 计算直接下侧邻居
            		if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            			neighbors++;
            		}
            		// 计算直接右侧邻居
            		if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
            			neighbors++;
            		}
        		}

        	}
        }
        return islands * 4 - neighbors * 2;
    }
}
