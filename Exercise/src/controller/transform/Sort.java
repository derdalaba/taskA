package controller.transform;

import java.util.ArrayList;
import java.util.List;

public final class Sort<T extends Comparable<T>> {
    public  List<T> mergeSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<List<T>> splitList = split(list);
        while (splitList.size() > 1) {
            splitList.add(merge(splitList.remove(0), splitList.remove(0)));
        }
        return splitList.get(0);
    }
    private List<List<T>> split(List<T> list) {
        List<List<T>> splitList = new ArrayList<>();
        for (T element : list) {
            List<T> singletonList = new ArrayList<>();
            singletonList.add(element);
            splitList.add(singletonList);
        }
        return splitList;
    }
    private List<T> merge(List<T> left, List<T> right) {
        List<T> mergedList = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                mergedList.add(left.remove(0));
            } else {
                mergedList.add(right.remove(0));
            }
        }
        if (!left.isEmpty()) {
            mergedList.addAll(left);
        }
        if (!right.isEmpty()) {
            mergedList.addAll(right);
        }
        return mergedList;
    }

}
