class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows >= s.length()) 
            return s;

        int index=0;
        int direction=1;

        List<Character>[] rows = new ArrayList[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new ArrayList<>();
        }

        for(char c: s.toCharArray()){
            rows[index].add(c);
            if(index==0){
                direction=1;
            }
            else if(index==numRows-1){
                direction=-1;
            }
            index+=direction;
        } 

        StringBuilder result = new StringBuilder();
        for(List<Character> row: rows){
            for(char c: row){
            result.append(c);
            }
        }  

        return result.toString();  
    }
}