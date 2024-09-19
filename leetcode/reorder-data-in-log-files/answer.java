class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            if (s1x[1].equals(s2x[1])) {
                return s1x[0].compareTo(s2x[0]);
            }

            return s1x[1].compareTo(s2x[1]);
        });

        String[] answer = new String[logs.length];
        int idx = 0;
        for(String letter: letterList) {
            answer[idx++] = letter;
        }

        for(String digit: digitList) {
            answer[idx++] = digit;
        }

        return answer;
    }
}