import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public final class Utility {

    private Utility() {
        throw new java.lang.UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static <T extends Comparable<T>> void sort(List<T> lst) {
        class myComparator implements Comparator<T> {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        }
        sort(lst, new myComparator());
    }

    public static <T> void sort(List<T> lst, Comparator<? super T> c) {
        ArrayList<T> tmp = innerMergeSort(lst, c, 0, lst.size());
        for (int i = 0; i < lst.size(); i++) {
            lst.set(i, tmp.get(i));
        }
    }

    private static <T> ArrayList<T> innerMerge(ArrayList<T> a, ArrayList<T> b, Comparator<? super T> c) {
        ArrayList<T> res = new ArrayList<T>();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (c.compare(a.get(i), b.get(j)) < 0) {
                res.add(a.get(i));
                i++;
            } else {
                res.add(b.get(j));
                j++;
            }
        }
        while (i < a.size()) {
            res.add(a.get(i));
            i++;
        }
        while (j < b.size()) {
            res.add(b.get(j));
            j++;
        }
        return res;
    }

    private static <T> ArrayList<T> innerMergeSort(List<T> lst, Comparator<? super T> c, int left, int right) {
        if (left >= right) {
            return new ArrayList<T>();
        }
        if (left + 1 == right) {
            return new ArrayList<T>(List.of(lst.get(left)));
        }

        int mid = (left + right) / 2;
        ArrayList<T> ra = innerMergeSort(lst, c, left, mid);
        ArrayList<T> rb = innerMergeSort(lst, c, mid, right);
        ArrayList<T> res = innerMerge(ra, rb, c);
        return res;
    }

}
