class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>(); // list to store valid expressions
        remove(s, result, 0, 0, '(', ')'); // call helper method to remove invalid parentheses
        return result;
    }
    
    private void remove(String s, List<String> result, int iStart, int jStart, char open, char close) {
        int count = 0; // count of open parentheses
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                count++;
            } else if (s.charAt(i) == close) {
                count--;
            }
            
            if (count < 0) { // invalid closing parenthesis found
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == close && (j == jStart || s.charAt(j - 1) != close)) {
                        // remove the current closing parenthesis and recurse
                        remove(s.substring(0, j) + s.substring(j + 1), result, i, j, open, close);
                    }
                }
                
                return; // stop processing further
            }
        }
        
        // no invalid closing parenthesis found, so check for invalid open parentheses
        String reversed = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            remove(reversed, result, 0, 0, ')', '(');
        } else {
            result.add(reversed);
        }
    }
}
