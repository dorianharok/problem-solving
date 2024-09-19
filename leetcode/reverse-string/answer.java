class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] c, int left, int right) {
        char temp = c[right];
        c[right] = c[left];
        c[left] = temp;
    }
}