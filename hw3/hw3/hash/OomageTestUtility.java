package hw3.hash;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Oomage o : oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            if (map.containsKey(bucketNum)) {
                int num = map.get(bucketNum);
                map.put(bucketNum, num + 1);
            } else {
                map.put(bucketNum, 1);
            }
        }
        int n = oomages.size();
        for (int bucket : map.keySet()) {
            int t = map.get(bucket);
            if (t <= n / 50 || t >= n / 2.5) {
                return false;
            }
        }
        return true;
    }
}
