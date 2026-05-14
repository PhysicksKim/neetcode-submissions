class Solution {

    final int SIZE = 'z'-'a'+1;

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++) {
            String s = strs[i];
            String nowGroup = getGroup(s);
            if(!groups.containsKey(nowGroup)) {
                groups.put(nowGroup, new ArrayList<>());
            }
            groups.get(nowGroup).add(s);
        }

        List<List<String>> answer = new ArrayList<>();
        for(List<String> vals : groups.values()) {
            answer.add(vals);
        }
        return answer;
    }

    private String getGroup(String s) {
        int[] ar = new int[SIZE];
        for(char c : s.toCharArray()) {
            ar[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < SIZE ; i++) {
            sb.append(ar[i]).append('_');
        }
        return sb.toString();
    }
}
