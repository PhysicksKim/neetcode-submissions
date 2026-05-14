class Solution {
    public boolean isAnagram(String s, String t) {
        final int ALPHABET = 'z'-'a'+1;
        int[] a = new int[ALPHABET];
        int[] b = new int[ALPHABET];

        for(char c : s.toCharArray()) {
            a[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            b[c-'a']++;
        }

        for(int i = 0 ; i < ALPHABET ; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
