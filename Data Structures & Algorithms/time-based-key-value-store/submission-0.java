class TimeMap {

    private Map<String, List<Pair<Integer, String>>> mpp;

    public TimeMap() {
        mpp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mpp.putIfAbsent(key, new ArrayList<>());
        mpp.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = mpp.getOrDefault(key, new ArrayList<>());
        int low = 0, high = values.size() - 1;
        String res = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (values.get(mid).getKey() <= timestamp) {
                res = values.get(mid).getValue();
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
