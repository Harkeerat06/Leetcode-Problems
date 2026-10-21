class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        if (s.equals(sorted))
            return 0;

        if (n == 2)
            return -1;

        char min = arr[0];
        char max = arr[n - 1];

        if (s.charAt(0) == min || s.charAt(n - 1) == max)
            return 1;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max)
                return 2;
        }

        return 3;
    }
}
