class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int up = 0;

        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || up == 1) {
            int sum = up;
            if(i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            up = sum / 10;
            sum %= 10;

            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}