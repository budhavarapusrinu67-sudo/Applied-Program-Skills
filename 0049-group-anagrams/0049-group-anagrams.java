class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        if(n == 0) return new ArrayList<>();

        // Time Complexity: O(NK)
        // Space Complexity: O(NK)
        // K -> maximum length of a string in strs

        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];

        for(String s : strs){
            Arrays.fill(count, 0); // we have to reset frequency for each string strs[i]
            //other wise it will keep incresing freq from string i + string i+1 character
            
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            //For count[] → same frequencies → same string key (Arrays.toString)

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }
}