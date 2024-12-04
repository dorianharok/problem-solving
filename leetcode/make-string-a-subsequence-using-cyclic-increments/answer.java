class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str1.equals(str2)) return true;

        int[] arr = new int[26];
        for(int i=0; i<str1.length(); i++) {
            arr[str1.charAt(i)-'a']++;
        }

        for(int i=0; i<str2.length(); i++) {
            arr[str2.charAt(i)-'a']--;
        }

        int l = 0;
        int r = 0;
        while(l < str1.length() && r < str2.length()) {
            int a = str1.charAt(l) - 'a';
            int b = str2.charAt(r) - 'a';

            if(a == b) {
                l++;
                r++;
            } else if(b - a == 1 || (a + 1) % 26 == b) {
                arr[a]--;
                arr[b]++;
                l++;
                r++;
            } else {
                l++;
            }
        }

        for(int i=0; i<26; i++) {
            if(arr[i] < 0) {
                return false;
            }
        }

        return true;
    }
}