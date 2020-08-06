```java
// Credits - https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequency of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        //this counter indicates the required no. of unique characters we need
        //must be the map size, NOT the string size because the char may be duplicate.
        int required = map.size();
        
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char ch = s.charAt(end);//get a character
            
            if( map.containsKey(ch) ){
                map.put(ch, map.get(ch)-1);// plus or minus one
                if(map.get(ch) == 0) required--;//modify the counter according the requirement(different condition).
            }
            end++;
            
            //increase begin pointer to make it invalid/valid again
            while(required == 0 /* counter condition. different question may have different condition */){
                
                char tempCh = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempCh)){
                    map.put(tempCh, map.get(tempCh) + 1);//plus or minus one
                    if(map.get(tempCh) > 0) required++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                begin++;
            }
        }
        return result;
    }
}
```