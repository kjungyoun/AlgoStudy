class Solution {
    public String[] solution (int n, int[] arr1, int[] arr2){
        String[] result = new String[n];
        for(int i = 0; i<n; i++){
            String str = StringLPAD(Integer.toBinaryString(arr1[i]|arr2[i]),n,"0");
            char [] charArr = str.toCharArray();
            for(int j=0; j<charArr.length; j++){
                if(charArr[j] == '0'){
                    charArr[j] = ' ';
                }else {
                    charArr[j] = '#';
                }
                result[i] = String.valueOf(charArr);
                System.out.println(result[i]);
            }
            
        }
        return result;
    }
    public String StringLPAD(String origin, int len, String str){
        for(int i = origin.length(); i<len; i++){
            origin += str;
        }
        return origin;
    }
}
