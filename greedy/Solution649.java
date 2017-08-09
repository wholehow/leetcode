package greedy;

import java.util.LinkedList;
import java.util.Queue;

/* 大意：
 * Dota2有两个政党，光明党与黑暗党（好扯）。参议院的参议员也都属于这两个政党。现在参议员们决定要对Data2做出改变，当然每个政党希望的改变是不一样的，需要投票决定。
 * 投票是一个回合制程序。在每一轮中，每个参议员都可以行使两种权利之一。一种权利是让另一个政党的参议员在这一轮以及以后的每一轮没有任何权利；另一种是在参议会中只剩一个政党的参议员有权利的时候代表这个政党的胜利。
 * 给出一个代表每个参议员党派归属的字符串，只包含两种字母，R和D，R代表Radiant，D代表Dire，如果有n个参议员那么字符串的长度就为n。
 * 回合制程序从第一个参议员开始，到最后一个指定的参议员。这个程序将持续到投票结束。所有失去权利的参议员都将在程序中被跳过。
 * 假设每个参议员是足够聪明，会为自己的当事人发挥最好的策略，你需要预测哪一方将最终宣布胜利并在DOTA2游戏的变化。输出应该是辐射或可怕的。
 * */

public class Solution649 {
	
	/* 简直就是阅读理解题。
	 * 每个参议员R必须禁止他的下一个最近的参议员D，否则D将禁止其下一个参议员R。
	 * 想法是使用两个队列分别从R和D的各方保存每个参议员的索引。 在每轮中，我们删除被禁止的参议员索引; 并加上剩余的参议员指数为n（输入参数参数的长度），然后将其移动到其相应队列的后面。
	 * */
	
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<Integer>(), dQueue = new LinkedList<Integer>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
        	if (senate.charAt(i) == 'R') rQueue.add(i);
        	else dQueue.add(i);
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
        	// 注意这里的顺序，是从后向前。如果使用双端队列，是可以使用pollFirst方法。
        	int rIdx = rQueue.poll(), dIdx = dQueue.poll();
        	if (rIdx < dIdx) rQueue.add(rIdx + len);
        	else dQueue.add(dIdx + len);
        }
        return rQueue.size() > dQueue.size() ? "Radiant" : "Dire";
    }
}
