class TimeMap {

    private static class TimestampValue {
        int timestamp;
        String value;

        TimestampValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<TimestampValue>> map = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            List<TimestampValue> timestampValues = new ArrayList<>();
            timestampValues.add(new TimestampValue(timestamp, value));
            map.put(key, timestampValues);
        } else {
            List<TimestampValue> timestampValues = map.get(key);
            timestampValues.add(new TimestampValue(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<TimestampValue> timestampValues = map.get(key);
        return binarySearch(timestampValues, timestamp);
    }

    private String binarySearch(List<TimestampValue> timestampValues, int timestamp) {
        String result = "";
        int low = 0;
        int high = timestampValues.size() - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if (timestampValues.get(mid).timestamp <= timestamp) {
                result = timestampValues.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return result;
    }
    
}
