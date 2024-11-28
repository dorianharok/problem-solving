class Solution {
    public char findKthBit(int n, int k) {
        String t = get(n);

        return get(n).charAt(k-1);
    }

    public String get(int n) {
        if(n < 2) {
            return "0";
        }

        String t = get(n-1);

        return t + "1" + invert(t);
    }

    public String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            int c = s.charAt(i) - '0';
            c ^= 1;
            sb.append(c);
        }

        return sb.toString();
    }
}