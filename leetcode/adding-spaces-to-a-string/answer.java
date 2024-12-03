class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] arr = new char[s.length() + spaces.length];

        for(int i=0, j=0, k=0; i<arr.length; i++) {
            if(k < spaces.length && j == spaces[k]) {
                arr[i] = ' ';
                k++;
                continue;
            }

            arr[i] = s.charAt(j++);
        }

        return new String(arr);
    }
}