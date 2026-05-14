class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strs.size() ; i++) {
            sb.append('#')
              .append(Integer.toString(strs.get(i).length()))
              .append('#')
              .append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        List<String> list = new ArrayList<>();
        int idx = 0;
        while(sb.length() > 0) {
            int lenStart = 1;
            int lenEnd = sb.indexOf("#",1);
            int len = Integer.parseInt(sb.substring(lenStart, lenEnd));
            String now = sb.delete(0,lenEnd+1).substring(0, len);
            list.add(now);
            sb.delete(0, len);
        }
        return list;
    }
}
