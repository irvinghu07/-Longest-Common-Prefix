/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: Longest Common Prefix
 * Date: 2018-11-20
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minIndex = findMin(strs);
        if (minIndex == -1) {
            return "";
        }
//        System.out.println(minIndex);
        int upperBound = 0;
        char currentChar;
        for (int i = 0; i < strs[minIndex].length(); i++) {
            currentChar = strs[minIndex].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (j == minIndex) {
                    continue;
                }
                if (strs[j].charAt(i) != currentChar) {
                    return strs[minIndex].substring(0, upperBound);
                }
            }
            upperBound++;
        }
        return strs[minIndex].substring(0, upperBound);
    }

    private static boolean hasEmpty(String[] strs) {
        for (String str : strs) {
            if (str.length() == 0) {
                return true;
            }
        }
        return false;
    }

    private static int findMin(String[] strs) {
        int minLength = strs[0].length();
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return -1;
            }
            if (minLength > strs[i].length()) {
                minIndex = i;
                minLength = strs[i].length();
            }
        }
        return minIndex;
    }
}
