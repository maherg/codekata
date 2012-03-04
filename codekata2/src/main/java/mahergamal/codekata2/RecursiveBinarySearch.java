package mahergamal.codekata2;

public class RecursiveBinarySearch implements BinarySearch {
    
    public int find(int[] list, int target) {
        return recursiveFind(list, target, 0, list.length - 1);
    }
    
    private int recursiveFind(int[] list, int target, int start, int end) {
        if (list.length == 0) {
            return -1;
        }
        if (start == end) {
            return list[start] == target ? start : -1;
        }
        int middle = (start + end) / 2;
        if (target == list[middle]) {
            return middle;
        } else if (target > list[middle]) {
            return recursiveFind(list, target, middle + 1, end);
        } else {
            return recursiveFind(list, target, start, middle);
        }
    }
}
