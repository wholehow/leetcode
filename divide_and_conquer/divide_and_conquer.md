# === 循环递归 ===
在每一层递归上都有三个步骤：
## 分解：将原问题分解为若干个规模较小，相对独立，与原问题形式相同的子问题。
## 解决：若子问题规模较小且易于解决时，则直接解。否则，递归地解决各子问题。
## 合并：将各子问题的解合并为原问题的解。

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
