class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(String chars:strs){
            char[] charArray = chars.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if(!hashMap.containsKey(sorted)){
                hashMap.put(sorted,new ArrayList<>());
            }
            hashMap.get(sorted).add(chars);
        }

        return new ArrayList<>(hashMap.values());
    }
    
}