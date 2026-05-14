class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')){
                sb.append(Character.toLowerCase(c));
            }
            if('0' <= c && c <= '9') {
                sb.append(c);
            }
        }

        int i = 0, j = sb.length()-1;
        while(i <= j) {
            if(sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
