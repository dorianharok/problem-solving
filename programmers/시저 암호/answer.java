class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                int nn = c + n;
                if (Character.isLowerCase(c)) {
                    if (nn > 'z') {
                        nn -= 26;
                    }
                } else {
                    if (nn > 'Z') {
                        nn -= 26;
                    }
                }
                char next = (char) nn;
                sb.append(next);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}