package codility;

import java.util.Arrays;

public class RangeSumQuery {
    static int st[]; //array to store segment tree

    // A utility function to get minimum of two numbers
    static int minVal(int x, int y) {
        return (x < y) ? x : y;
    }

    // A utility function to get maximum of two numbers
    static int maxVal(int x, int y) {
        return (x > y) ? x : y;
    }

    // A utility function to get the middle index from corner
    // indexes.
    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /*  A recursive function to get the minimum value in a given
        range of array indexes. The following are parameters for
        this function.

        st    --> Pointer to segment tree
        index --> Index of current node in the segment tree. Initially
                   0 is passed as root is always at index 0
        ss & se  --> Starting and ending indexes of the segment
                     represented by current node, i.e., st[index]
        qs & qe  --> Starting and ending indexes of query range */
    static int RMQUtil(int ss, int se, int qs, int qe, int index) {
        // If segment of this node is a part of given range, then
        // return the min of the segment
        if (qs <= ss && qe >= se)
            return st[index];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);

        int leftSum =RMQUtil(ss, mid, qs, qe, 2 * index + 1);
        int rightSum = RMQUtil(mid + 1, se, qs, qe, 2 * index + 2);

        return (leftSum+rightSum)/(se-ss);
    }

    // Return minimum of elements in range from index qs (query
    // start) to qe (query end).  It mainly uses RMQUtil()
    static int RMQ(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    // A recursive function that constructs Segment Tree for
    // array[ss..se]. si is index of current node in segment tree st
    static int constructSTUtil(int arr[], int ss, int se, int si) {
        // If there is one element in array, store it in current
        //  node of segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the maximum of two values in this node
        int mid = getMid(ss, se);

        int leftSum = constructSTUtil(arr, ss, mid, si * 2 + 1);
        int rightSum = constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        st[si] = (leftSum + rightSum)/(se-ss);
        return st[si];
    }

    /* Function to construct segment tree from given array. This function
       allocates memory for segment tree and calls constructSTUtil() to
       fill the allocated memory */
    static void constructST(int arr[], int n) {
        // Allocate memory for segment tree

        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size]; // allocate memory

        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, 0);
    }

    public static int[] genomicRangeQuery(int[] S, int[] P, int[] Q) {

        int n = S.length;
        int[] result = new int[P.length];

        // Build segment tree from given array
        constructST(S, n);
        System.out.println(Arrays.toString(st));
        for (int i = 0; i < P.length; i++) {
            // P[i] Starting index of query range
            // Q[i] Ending index of query range
            result[i] = RMQ(n, P[i], Q[i]);
        }


        return result;
    }

}
