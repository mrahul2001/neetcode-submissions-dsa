class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        if (digits == null || digits.length() == 0) return result;

        func(0, digits, str, digitToChar, result);

        return result;
    }

    private void func(int i, String digits, StringBuilder str, String[] digitToChar, List<String> result) {
        if (i == digits.length()) {
            result.add(str.toString());
            return;
        }

        String charNum = digitToChar[digits.charAt(i) - '0'];

        for (char ch : charNum.toCharArray()) {
            str.append(ch);
            func(i + 1, digits, str, digitToChar, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
