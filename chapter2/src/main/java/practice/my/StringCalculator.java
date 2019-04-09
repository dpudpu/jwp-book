package practice.my;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int getSum(String str) {
        if(str==null || str.isEmpty())
            return 0;

        int[] nums = convertStringsToInts(seperate(str));
        return addNums(nums);
    }

    private String[] seperate(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return str.split(",|:");
    }

    private int[] convertStringsToInts(String[] strs) {
        int nums[] = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);

            if (isNegativeNum(nums[i]))
                throw new RuntimeException();
        }
        return nums;
    }

    private boolean isNegativeNum(int num) {
        return num < 0 ? true : false;
    }

    private int addNums(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }
}
