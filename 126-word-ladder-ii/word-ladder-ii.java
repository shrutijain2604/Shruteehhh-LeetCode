class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        List<List<String>> prevNodes = new ArrayList<>();
        
        if (!dict.contains(endWord))return ans;
        dict.remove(beginWord);
                
        boolean reached = false;
        
        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);        
        prevNodes.add(temp);
        
        
        while (dict.size() > 0 && !reached) {
            
            List<String> last = prevNodes.get(prevNodes.size()-1);
            List<String> curr = new ArrayList<>();
			
            //get all the previous valid nodes inside `prevNodes` until you find endWord 			
            for (int i = 0; i < last.size() && !reached; i++) {
                
                HashSet<String> visited = new HashSet<>(); 
                String from = last.get(i);                
                for(String to : dict){                     
                    if(visited.contains(to) || !oneCharIsDiff(from, to))continue;                    
                    if(to.equals(endWord)){
                        reached = true;
                        break;
                    }                    
                    curr.add(to);
                    visited.add(to);
                }
				//remove previous visited nodes we don't need anymore.
                for(String node : visited)
                    dict.remove(node);
            }            
            if (reached || curr.size() < 1) break;                 
            prevNodes.add(curr);
        }        
        
        if (!reached) 
            return ans;
			
        ArrayList<String> end = new ArrayList<>();
        end.add(endWord);    
        ans.add(end);        
		
		//go backwards and make paths
        for (int level = prevNodes.size() - 1; level >= 0; level--) {             
            int alen = ans.size();
			
            while (alen-->0) {                
                List<String> path = ans.get(0);
                ans.remove(0);                
                String from = path.get(0);  
				
                for (String word : prevNodes.get(level)) {                    
                    if (!oneCharIsDiff(word, from)) continue; 

				  //focus on this part, creating newPaths and adding them to answer.
                    List<String> newPath = new ArrayList<String>();                    
                    newPath.add(word);
                    for(String nbr : path){
                        newPath.add(nbr);
                    }                    
                    ans.add(newPath);                    
                }                
            }             
        }
        return ans;        
    }
    
    private boolean oneCharIsDiff(String str, String nbr){
        int count = 0;
        for(int i = 0; count<2 && i<str.length(); i++){
            if(str.charAt(i) != nbr.charAt(i))
                count++;
        }
        return count == 1;
    }
    
}