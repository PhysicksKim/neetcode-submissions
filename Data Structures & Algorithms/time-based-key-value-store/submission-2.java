class TimeMap {

    private static class Pair {
        int timestamp;
        String value;

        Pair(int t, String v) {
            timestamp=t; value=v;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> find = map.get(key);
        if(find==null) {
            find = new ArrayList<>();
            map.put(key, find);
        }

        find.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list==null) {
            return "";
        }

        return find(list, timestamp);
    }

    private String find(List<Pair> list, int timestamp) {
        int L = 0, R = list.size()-1;

        while(L<R) {
            int mid = L+(R-L)/2;

            // lowerBound
            if(timestamp <= list.get(mid).timestamp) {
                R = mid;
            } else {
                L = mid+1;
            }
        }

        Pair result = list.get(L);
        while(0 < L && timestamp < result.timestamp) {
            L--;
            result = list.get(L);
        }
        if(timestamp < result.timestamp) {
            return "";
        } else {
            return result.value;
        }
    }
}
