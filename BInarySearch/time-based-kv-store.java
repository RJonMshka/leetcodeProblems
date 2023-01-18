// LC981: Time Based Key-Value Store

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC981 {

    class TimeMap {

        class TimeNode {
            String value;
            int timestamp;

            public TimeNode() {}

            public TimeNode(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
        Map<String, List<TimeNode>> timeNodeMap;

        public TimeMap() {
            timeNodeMap  = new HashMap<String, List<TimeNode>>();
        }

        public void set(String key, String value, int timestamp) {
            TimeNode newNode = new TimeNode(value, timestamp);
            if(!timeNodeMap.containsKey(key)) {
                timeNodeMap.put(key, new ArrayList<TimeNode>());
            }
            List<TimeNode> timeNodeList = timeNodeMap.get(key);
            timeNodeList.add(newNode);
        }

        public String get(String key, int timestamp) {

            if(!timeNodeMap.containsKey(key)) {
                return "";
            }
            List<TimeNode> timeNodeList = timeNodeMap.get(key);

            int left = 0;
            int right = timeNodeList.size() - 1;
            String result = "";

            // Perform binary search in the list
            while(left <= right) {
                int mid = (left + right) / 2;

                if(timeNodeList.get(mid).timestamp <= timestamp) {
                    left = mid + 1;
                    result = timeNodeList.get(mid).value;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }
    }
}
