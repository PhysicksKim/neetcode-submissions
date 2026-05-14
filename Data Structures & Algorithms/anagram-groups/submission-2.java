class Solution {

    final int SIZE = 'z'-'a'+1;

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();

        for(String s : strs) {
            String group = getGroup(s);

            List<String> list = groups.get(group);
            if(list == null) {
                list = new ArrayList<>();
                groups.put(group, list);
            }
            list.add(s);
        }

        List<List<String>> answer = new ArrayList<>();
        for(List<String> vals : groups.values()) {
            answer.add(vals);
        }
        return answer;
    }

    private String getGroup(String s) {
        char[] count = new char[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        return new String(count);
    }
}
