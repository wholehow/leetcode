package bit_manipulation;

/* ¸ø¶¨Ò»¸öÊı×ÖÊı×ÖµÄÊı×é£¬ÆäÖĞÓĞÁ½¸öÔªËØÖ»³öÏÖÒ»´Î£¬ËùÓĞÆäËûÔªËØ³öÏÖÁ½´Î¡£ÕÒµ½Ö»³öÏÖÒ»´ÎµÄÁ½¸öÔªËØ¡£
 * */

public class Solution260 {

	/* Èç¹ûÖ»ÓĞaºÍb³öÏÖÁËÒ»´ÎÆäÓà¶¼³öÏÖÁËÁ½´Î£¬ÄÇÃ´ËùÓĞÊı×îºóÒì»òµÄ½á¹û¾ÍÊÇa^b¡£
	 * ÒòÎªaºÍbÊÇ²»Í¬µÄ£¬ËùÒÔÒ»¶¨¿ÉÒÔÕÒµ½µÚkÎ»£¬¼ÙÉèaµÄµÚkÎ»Îª0£¬ÄÇÃ´bµÄµÚkÎ»Ò»¶¨ÊÇ1¡£
	 * ½ÓÏÂÀ´ÔÙ±éÀúÒ»´ÎÊı×é£¬Õâ´ÎÖ»ÓëµÚkÎ»ÉÏÊÇ1µÄÊıÒì»ò£¬ÆäËûµÄÊıºöÂÔ¡£ÄÇÃ´µÚ¶ş´Î±éÀú½áÊøºó£¬Òì»ò½á¹û
	 * ¾ÍÊÇa»òbÖĞµÄÒ»¸ö£¬¼ÙÉèÊÇb£¬ÔÙÓëa^bÒì»òÒ»´Î¾ÍµÃµ½a¡£
	 * */
	
	public int[] singleNumber(int[] nums) {
	    int[] res = new int[2];        
	    int xor = 0;
	    for (int num : nums)
	    {
	        xor ^= num;
	    }
	    int rightMost = xor & ~(xor - 1);	// Ñ°ÕÒ×îÓÒ²àµÄ1
	    // int bit = xor & (~xor + 1);
	    int num1 = 0, num2 = 0;
	    for (int num : nums)
	    {
	        if ((num & rightMost) > 0)
	        {
	            num1 ^= num;
	        } else
	        {
	            num2 ^= num;
	        }
	    }
	    res[0] = num1;
	    res[1] = num2;
	    return res;
	}
}
