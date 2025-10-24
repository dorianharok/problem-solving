class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb;
        while(s.length() > 2) {
            sb = new StringBuilder();

            for(int i=0; i<s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                int sum = a + b;

                sb.append(sum % 10);
            }

            s = sb.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}