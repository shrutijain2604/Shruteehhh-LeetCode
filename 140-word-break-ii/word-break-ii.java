class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        return wordBreaker(s, 0, hs);
    }

    private List<String> wordBreaker(String s, int start, HashSet<String> dict){
        List<String> validSubStr = new ArrayList<>();

        if(start == s.length())
        validSubStr.add("");
        for(int end = start+1; end<=s.length(); end++){
            String word = s.substring(start,end);
            if(dict.contains(word)){
                List<String> suffix = wordBreaker(s, end, dict);
                for(String suf: suffix){
                    validSubStr.add(word+(suf.equals("")? "":" ")+suf);
                }
            }
        }
        return validSubStr;
    }
}