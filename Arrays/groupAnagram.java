// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            int[] sCharMap = new int[26];
            
            for(int j = 0; j < strs[i].length(); j++) {
                sCharMap[(int)strs[i].charAt(j) - (int)'a'] += 1;
            }
            
            String sCharMapStr = Arrays.toString(sCharMap);
            
            if(anagramMap.containsKey(sCharMapStr)) {
                List<String> keyList = anagramMap.get(sCharMapStr);
                keyList.add(strs[i]);
                
                anagramMap.put(sCharMapStr, keyList);
            } else {
                 List<String> keyList = new ArrayList<String>();
                 keyList.add(strs[i]);
                 anagramMap.put(sCharMapStr, keyList);
            }
        }
        
        return new ArrayList<List<String>>(anagramMap.values());
    }
}