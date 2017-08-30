# leetcode
记录leetcode刷题的点滴，实现语言Java，编译器Eclipse
## 小伙伴们自行参阅有关文件夹，有更好的想法欢迎即时提出。
## 等到AC80%题目的时候，会做出相应调整。现在无论自己查询还是做出更改都比较麻烦。
### git get
### 如果在GitHub进行了内容修改，一定要先pull到本地在进行push。
### 分享一个个人认为最好的git入门指南 https://try.github.io/levels/1/challenges/1
## 下一步的目标就是hexo+github搭建个人技术博客。
## 请联系
> 微信 QQ22423866(QQ请不要省略)

> Email zuoquan1993cn@gmail.com
# 写一些关于最新刷题的新的。

## 1. Backtracking，回溯法，又名记忆搜索法，是暴力搜寻法中的一种。
回溯法在字符串匹配——朴素匹配算法和KMP匹配算法的比对中体现的淋漓尽致。
> 回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

>> 找到一个可能存在的正确的答案

>> 在尝试了所有可能的分步方法后宣告该问题没有答案

> 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

## 2. BFS，广度优先遍历，多用于树结构和图结构。
广度优先遍历多使用队列，即每一层的个数都遍历到是当前最高优先级。
## 实现方法
> 1.首先将根节点放入队列中。

> 2.从队列中取出第一个节点，并检验它是否为目标。

>> 如果找到目标，则结束搜寻并回传结果。

>> 否则将它所有尚未检验过的直接子节点加入队列中。

> 3.若队列为空，表示整张图都检查过了——亦即图中没有欲搜寻的目标。结束搜寻并回传“找不到目标”。

> 4.重复步骤2。

## 3. DFS，深度优先遍历，多用于树结构和图结构。
深度优先遍历多使用栈，即从当前结点开始走到它能走到的尽头这条路径上的所有结点都被遍历到具有当前最高优先级。
## 实现方法
> 1.首先将根节点放入队列中。

> 2.从队列中取出第一个节点，并检验它是否为目标。

>> 如果找到目标，则结束搜寻并回传结果。

>> 否则将它某一个尚未检验过的直接子节点加入队列中。

> 3.重复步骤2。

> 4.如果不存在未检测过的直接子节点。

>> 将上一级节点加入队列中。

>> 重复步骤2。

> 5.重复步骤4。

> 6.若队列为空，表示整张图都检查过了——亦即图中没有欲搜寻的目标。结束搜寻并回传“找不到目标”。

## 4. Divide and Conquer，分治
在每一层递归上都有三个步骤：
> 分解：将原问题分解为若干个规模较小，相对独立，与原问题形式相同的子问题。

> 解决：若子问题规模较小且易于解决时，则直接解。否则，递归地解决各子问题。

> 合并：将各子问题的解合并为原问题的解。

```java
void mergeSort(int[] arr, int left, int right) {
 	int mid = 0;
 	while(left < right)
 	{
 		mid = left + (right - left) / 2;
 		mergeSort(arr, left, mid);
 		mergeSort(arr, mid + 1, right);
 		merge(arr, left, mid, right);
 	}
 }
```
## 5. Dynamic Programming，动态规划
感觉DP类的问题还是有一定难度的，主要就是注意所设置的DP元素究竟代表的是什么含义。

有点像迭代问题，需要找到递推公式。

二维DP问题注意画图，自己空想还是很抽象的（通过画图考虑好DP前进的方向）。

一维DP问题总是可以人为是二维DP问题的空间压缩版本。

动态规划所处理的问题是一个多阶段决策问题，一般由初始状态开始，通过对中间阶段决策的选择，达到结束状态。这些决策形成了一个决策序列，同时确定了完成整个过程的一条活动路线(通常是求最优的活动路线)。

动态规划的设计都有着一定的模式，一般要经历以下几个步骤。

    初始状态→│决策１│→│决策２│→…→│决策ｎ│→结束状态
>(1)划分阶段：按照问题的时间或空间特征，把问题分为若干个阶段。在划分阶段时，注意划分后的阶段一定要是有序的或者是可排序的，否则问题就无法求解。

>(2)确定状态和状态变量：将问题发展到各个阶段时所处于的各种客观情况用不同的状态表示出来。当然，状态的选择要满足无后效性。

>(3)确定决策并写出状态转移方程：因为决策和状态转移有着天然的联系，状态转移就是根据上一阶段的状态和决策来导出本阶段的状态。所以如果确定了决策，状态转移方程也就可写出。但事实上常常是反过来做，根据相邻两个阶段的状态之间的关系来确定决策方法和状态转移方程。

>(4)寻找边界条件：给出的状态转移方程是一个递推式，需要一个递推的终止条件或边界条件。

一般，只要解决问题的阶段、状态和状态转移决策确定了，就可以写出状态转移方程（包括边界条件）。

实际应用中可以按以下几个简化的步骤进行设计：

>（1）分析最优解的性质，并刻画其结构特征。

>（2）递归的定义最优解。

>（3）以自底向上或自顶向下的记忆化方式（备忘录法）计算出最优值

>（4）根据计算最优值时得到的信息，构造问题的最优解

## 6. Greedy，贪心算法
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码……对于其他问题，贪心法一般不能得到我们所要求的答案。一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是最好或最优

### 细节
1.建立数学模型来描述问题。

2 把求解的问题分成若干个子问题。

3.对每一子问题求解，得到子问题的局部最优解。

4.把子问题的解局部最优解合成原来解问题的一个解。

实现该算法的过程：

> 从问题的某一初始解出发；

> while 能朝给定总目标前进一步 do ,求出可行解的一个解元素；

> 最后，由所有解元素组合成问题的一个可行解。

## 7. 常用方法

Collections.sort(obj)

Collections.binarySearch(obj)

Collections.reverse(obj)

Collections.min(obj)/Collections.max(obj)

Collections.IndexOfSubList(list, li)/Collestions.LastIndexOfSubList(list,li)

Math.abs

Math.min/Math.max

Math.ceil/Math.floor/Math.round

List.add(0, Obj)用来实现层次遍历倒序输出

TreeMap有序的哈希表

PriorityQueue用以实现堆排序，可以选择实现Compare接口