class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str1.equals(str2)) return true;

        int p1 = 0;
        int p2 = 0;

        while(p1 < str1.length() && p2 < str2.length()) {
            char a = str1.charAt(p1);
            char b = str2.charAt(p2);

            if(a == b) {
                p1++;
                p2++;
            } else if(b - a == 1 || a - 25 == b) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        if(p2 != str2.length()) {
            return false;
        }

        return true;
    }
}