package bit_manipulation;

/* UTF8中的一个字符可以是1到4个字节，具有以下规则：
 * 1.对于1字节字符，第一个位为0，其后是其unicode代码。
 * 2.对于n字节的字符，前n位数全是1，第n+1位是0，后面跟着n-1个字节，最高位的两位数是10。
 * 这是UTF-8编码的工作原理：
 * Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回是否是一个有效的utf-8编码。
 * 注意：
 * 输入是整数数组。仅使用每个整数的最低有效8位来存储数据。这意味着每个整数只表示1个字节的数据。
 * */

public class Solution393 {
	
	/* 这根本就是个阅读理解题！
	 * 摘自维基百科UTF-8编码：
	 * 对于UTF-8编码中的任意字节B，如果B的第一位为0，则B独立的表示一个字符(ASCII码)；
	 * 如果B的第一位为1，第二位为0，则B为一个多字节字符中的一个字节(非ASCII字符)； 128
	 * 如果B的前两位为1，第三位为0，则B为两个字节表示的字符中的第一个字节； 192
	 * 如果B的前三位为1，第四位为0，则B为三个字节表示的字符中的第一个字节； 224
	 * 如果B的前四位为1，第五位为0，则B为四个字节表示的字符中的第一个字节； 240
	 * 因此，对UTF-8编码中的任意字节，根据第一位，可判断是否为ASCII字符；根据前二位，可判断该字节是否为一个字符编码的第一个字节；
	 * 根据前四位（如果前两位均为1），可确定该字节为字符编码的第一个字节，并且可判断对应的字符由几个字节表示；
	 * 根据前五位（如果前四位为1），可判断编码是否有错误或数据传输过程中是否有错误。
	 * */
	
	public boolean validUtf8(int[] data) {
		if (data == null || data.length == 0) {
			return false;
		}
		boolean isValid = true;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > 255) 
				return false; // 每个整数只表示1个字节的数据
			int numberOfBytes = 0;
			if ((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
				numberOfBytes = 1;
			} else if ((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
				numberOfBytes = 2;
			} else if ((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
				numberOfBytes = 3;
			} else if ((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
				numberOfBytes = 4;
			} else {
				return false;
			}
			for (int j = 1; j < numberOfBytes; j++) { //检查以 10xxxxxx开头的后n位
				if (i+j >= data.length) return false;	// 超出长度
				// 最高两位不是10
				if ((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
			}
			i += numberOfBytes-1;
		}
		return isValid;
	}
}
