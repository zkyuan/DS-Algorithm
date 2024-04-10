package com.zky;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     *
     * @author: yuan
     * @date: 2023/1/3
     * Description:   无重复字符的最长子串
     *                给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
     *                输入: s = "abcabcbb"
     *                输出: 3
     *                解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     */
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int [] dict = new int[256]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i=0;
        while(key < s.length()){
            i = s.charAt(key);  //获取字符的ASCII码
            if(dict[i] > base)
                base = dict[i];
            dict[i] = key+1; //以1作为起始位置，下标加1
            maxSize = (maxSize>key-base+1)?maxSize:key-base+1;
            key++;
        }
        return maxSize;
    }

    /**
     *   滑动窗口
     *    start不动，end向后移动
     *   当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
     *   怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), result = 0;//不重复子串长度
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {//不重复子串的开始位置和结束位置，end后移，start遇到重复字符后移
            char alpha = s.charAt(end);//挨个取出字符
            if (map.containsKey(alpha)) { //判断map里面是否存有该字符，若有则重复了，
                start = Math.max(map.get(alpha), start);//若遇到重复字符，子串开始位置移动到重复字符的后面，保留最大值，
            }
            result = Math.max(result, end - start + 1);//结束位置减开始位置+1，保留最大值
            map.put(s.charAt(end), end + 1);  //将字符作为key，将子串结束位置+1作为value
        }
        return result;
    }

}
