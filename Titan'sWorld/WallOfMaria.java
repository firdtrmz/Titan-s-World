// Java program to find the most frequent element
// in an array
import java.util.*;

class WallOfMaria {

    public static ArrayList<Integer> ConvertToOneList(List<List<Integer>> data) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (!data.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            layer = data.get(0);
            data.remove(0);
            while (!layer.isEmpty()) {
                arr.add(layer.get(0));
                layer.remove(0);
            }
        }
        return arr;
    }

    public static int mostFrequentArrayList(ArrayList<Integer> arr, int n) {
        // Sort the array
        Collections.sort(arr);
        // find the max frequency using linear traversal
        Integer max_count = 1;
        Integer res = arr.get(0);
        int curr_count = 1;

        for (int i = 1; i < n; i++) {
            if (Objects.equals(arr.get(i), arr.get(i - 1))) {
                curr_count++;
            } else {
                curr_count = 1;
            }

            if (curr_count > max_count) {
                max_count = curr_count;
                res = arr.get(i - 1);
            }
        }
        return res;
    }
}
