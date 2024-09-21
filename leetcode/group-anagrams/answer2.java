class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(
                                str -> {
                                    char[] chars = str.toCharArray();
                                    Arrays.sort(chars);
                                    return new String(chars);
                                }
                        )).values()
        );
    }
}