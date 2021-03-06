package codility;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static int solution(int N) {
        // String to be scanned to find the pattern.
        String line = Integer.toBinaryString(N);
        String pattern = "(1*)(0+)(1)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(line);
        int result = 0;
        System.out.println(line);
        while (m.find()) {

            result = m.group(2).length() > result ? m.group(2).length() : result;
            //System.out.println(result);
            //System.out.println(m.group(2));
        }
        return result;
    }

    public static int[] cyclicRotation(int[] A, int K) {
        if (A.length == 0) return new int[]{};
        int modul = K % A.length;
        int[] B = new int[A.length];
        //System.out.println(modul);
        for (int i = 0; i < A.length; i++) {
            B[i] = A[(i - modul) < 0 ? A.length + i - modul : i - modul];
        }

        return B;
    }

    public static int oddOccurrencesInArray_(int[] A) {
        Map<Integer, Long> map = new HashMap<>();
        //Map<Integer, Long> oddMap = new HashMap<>();
        map = IntStream.of(A).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

//        map = Arrays.stream(A).boxed()
//                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        //oddMap = map.entrySet().parallelStream().filter(a->(a.getValue()&1)==1).collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        //oddMap = map.entrySet().stream().filter(a->(a.getValue()&1)==1).collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        //map.values().removeIf(v -> (v&1) == 0);
        int result = map.entrySet().stream().filter(a -> (a.getValue() & 1) == 1).iterator().next().getKey();

        //System.out.println(map);
        //System.out.println(oddMap);
        return result;
    }

    public static int oddOccurrencesInArray(int[] A) {
        Arrays.sort(A);
        int i;
        for (i = 0; i < A.length - 1 && A[i] == A[i + 1]; i += 2) ;
        return A[i];
    }

    public static int permMissingElem(int A[]) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }

    public static int frogJmp(int X, int Y, int D) {
        return (Y - X) % D == 0 ? (Y - X) / D : (Y - X) / D + 1;
    }

    public static int tapeEquilibrium(int[] A) {
        long left = A[0];
        long sum = 0;
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
        }
        long right = sum;
        long diff = Math.abs(left - right);

        for (int p = 1; p < A.length - 1; p++) {
            left += A[p];
            right -= A[p];
            diff = Math.min(diff, Math.abs(left - right));
        }
        return (int) diff;
    }

    public static int permCheck(int[] A) {
        Arrays.sort(A);

        if (A[0] != 1) return 0;
        if (A.length == 1) return A[0] == 1 ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1] + 1) return 0;
        }
        return 1;
    }

    public static int frogRiverOne(int X, int[] A) {
        Set<Integer> way = new HashSet<>();
        for (int i = 1; i < X + 1; i++) {
            way.add(i);
        }
        System.out.println(way);
        for (int i = 0; i < A.length; i++) {
            if (way.contains(A[i])) {
                way.remove(A[i]);
                if (way.isEmpty()) return i;
            }
        }
        return -1;
    }

    public static int[] maxCounters(int N, int[] A) {
        int[] X = new int[N];
        int currentMax = 0;
        int currentMaxApplied = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                if (X[A[i] - 1] < currentMaxApplied) {
                    X[A[i] - 1] = currentMaxApplied + 1;
                } else {
                    X[A[i] - 1]++;
                }
                currentMax = Math.max(X[A[i] - 1], currentMax);
            } else {
                currentMaxApplied = currentMax;
            }
        }
        for (int i = 0; i < X.length; i++) {
            if (X[i] < currentMaxApplied) {
                X[i] = currentMaxApplied;
            }
        }
        return X;

    }

    public static int missingInteger(int[] A) {
        Arrays.sort(A);
        int max = 0;
        System.out.println(Arrays.toString(A));
        if (A.length == 1) return A[0] == 1 ? 2 : 1;
        for (int i = 0; i < A.length; i++) {

            if (A[i] < 0) continue;
            if (A[i] > max + 1) return max + 1;
            max = Math.max(max, A[i]);
        }

        return max + 1;
    }

    public static int passingCars(int[] A) {
        int east = 0;
        int west = 0;
        long pairs = 0;

        for (int i = 0; i < A.length; i++) {

            if ((A[i] == 0)) {
                east++;
            }
            if ((A[i] == 1)) {
                west++;
                pairs += east;
            }

        }
        return pairs > 1000000000L ? -1 : (int) pairs;
    }

    public static int[] tapeArray(int N) {
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (new Random().nextInt(100));
        }
        return array;
    }


    public static void main(String[] args) {
        //System.out.println(solution(328));
        //System.out.println(Arrays.toString(cyclicRotation(new int[]{3, 8, 9, 7, 6}, 5)));
        //System.out.println(permMissingElem(new int[]{1}));
        //System.out.println(frogJmp(10,85,30));
        //System.out.println(tapeEquilibrium(new int[]{-1000,1000}));
        //System.out.println(permCheck(new int[]{7}));
        //System.out.println(frogRiverOne(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        //System.out.println(Arrays.toString(maxCounters(5, new int[]{1, 1, 6, 2, 3, 5})));
        //System.out.println(missingInteger(new int[]{4, 5, 6, 10, 11, 13, 15, 15, 17, 18, 20, 22, 24, 24, 31, 32, 32, 34, 35, 37, 43, 48, 48, 49, 50, 50, 53, 53, 58, 63, 64, 65, 65, 66, 67, 67, 68, 68, 70, 72, 73, 78, 80, 80, 82, 83, 91, 96, 97, 98}));
        //System.out.println(missingInteger(new int[]{-1000000,1,2,4,6}));
        //System.out.println(passingCars(new int[]{0,1,0,1,1,0,0,0,1}));
        //System.out.println(Arrays.toString(RangeMinimumQuery.genomicRangeQuery("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(
                RangeSumQuery.sumRangeQuery(new int[]{-1,3,4,0,2,1}, new int[]{0},
                                                new int[]{5})));

    }

}