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
        if(list.get(0).timestamp > timestamp) {
            return "";
        }

        int L = 0, R = list.size()-1;

        while(L<R) {
            int mid = L+(R-L)/2;

            // upper bound
            if(list.get(mid).timestamp < timestamp) {
                L = mid+1;
            } else {
                R = mid;
            }
        }

        Pair result = list.get(L);
        if(timestamp < result.timestamp) {
            result = list.get(L-1);
        } 

        return result.value;
    }
}
