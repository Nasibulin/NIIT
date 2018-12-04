package codility;

import java.util.Arrays;
import java.util.Map;
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
        if (A.length==0) return new int[]{};
        int modul = K % A.length;
        int[] B = new int[A.length];
        //System.out.println(modul);
        for (int i = 0; i < A.length; i++) {
            B[i] = A[(i - modul) < 0 ? A.length + i - modul : i - modul];
        }

        return B;
    }

    public static int oddOccurrencesInArray(int[] A){


//        Map<Integer, Long> result = Stream.of(1,2,3,1,2,3,7)
//                .collect(Collectors.groupingBy(r -> r, Collectors.counting()));

        Map<Integer, Long> result1 = Arrays.stream(A).mapToObj(i->i)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println(result1);
        System.out.println(result1.entrySet().stream().filter(map -> map.getValue()==1L)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        return 1;
    }


    public static void main(String[] args) {
        //System.out.println(solution(328));
        //System.out.println(Arrays.toString(cyclicRotation(new int[]{3, 8, 9, 7, 6}, 5)));
        System.out.println(oddOccurrencesInArray(new int[]{1,2,3,1,2,3,7}));

    }
}