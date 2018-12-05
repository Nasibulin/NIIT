package codility;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public static int oddOccurrencesInArray(int[] A) {
//        ArrayList<Integer> list = new ArrayList<>(A.length);
//        for (int i = 0; i < A.length; i++) {
//            list.add(A[i]);
//        }
//        Set<Integer> duplicates = new HashSet<>(list);
//        unique.stream()
//                .filter(t -> Collections.frequency(list, t) == 1)
//        .forEach(key -> System.out.println(key + ": " + Collections.frequency(list, key)));
        List<Integer> duplicates = Arrays.stream(A).boxed().collect(Collectors.toList());

        Set<Integer> unique = duplicates.stream().filter(i -> Collections.frequency(duplicates, i) % 2 == 1)
                .collect(Collectors.toSet());
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        Map<Long, Integer> map2 = new HashMap<Long, Integer>();
        map = Arrays.stream(A).boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }

        System.out.println(map2);
        System.out.println(duplicates);
        System.out.println(unique);
        return map2.entrySet().iterator().next().getValue();
    }


    public static void main(String[] args) {
        //System.out.println(solution(328));
        //System.out.println(Arrays.toString(cyclicRotation(new int[]{3, 8, 9, 7, 6}, 5)));
        System.out.println(oddOccurrencesInArray(new int[]{9, 10, 3, 9, 3, 9, 7, 7, 9}));

    }
}