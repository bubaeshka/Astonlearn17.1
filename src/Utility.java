import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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

	// binary search realization is below
	public static <T extends Comparable<T>> int binarySearch(List<T> lst, T target) {
		class myComparator implements Comparator<T> {
			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		}
		return binarySearch(lst, target, new myComparator(),0, lst.size());
	}

	public static <T extends Comparable<T>> int binarySearch(List<T> lst, T target, Comparator<? super T> c) {
		return binarySearch(lst, target, c,0, lst.size());
	}

	private static <T> int binarySearch(List<T> lst, T target, Comparator<? super T> c, int left, int right) {
		int index = Integer.MAX_VALUE;

		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (c.compare(lst.get(mid), target) < 0) {
				left = mid + 1;
			} else if (c.compare(lst.get(mid), target) > 0) {
				right = mid - 1;
			} else if (c.compare(lst.get(mid), target) == 0) {
				index = mid;
				break;
			}
		}
		return index;

	}

	class KeyGetter<T> implements Function<T, Integer> {
		@Override
		public Integer apply(T t) {
			return 5;
		}
	}

	public static <T extends Comparable<T>> void strahgeSort(List<T> lst, KeyGetter<T> keyGetter) {

		class myComparator implements Comparator<T> {
			KeyGetter<T> keyGetter;

			public myComparator(KeyGetter<T> keyGetter) {
				this.keyGetter = keyGetter;
			}

			@Override
			public int compare(T o1, T o2) {
				Integer key1 = keyGetter.apply(o1);
				Integer key2 = keyGetter.apply(o2);
				return key1.compareTo(key2);
			}
		}
		ArrayList<T> movableList = new ArrayList<T>();
		movableList.addAll(lst.stream().filter(X -> keyGetter.apply(X) % 2 == 0).toList());
		sort(movableList, new myComparator(keyGetter));
		int j = 0;
		for (int i = 0; i < lst.size(); i++) {
			if (keyGetter.apply(lst.get(i)) % 2 == 0) {
				lst.set(i, movableList.get(j));
				j++;
			}
		}

	}
}
