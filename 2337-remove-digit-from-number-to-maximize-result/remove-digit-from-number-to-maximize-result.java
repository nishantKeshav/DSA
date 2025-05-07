class Solution {
    public String removeDigit(String number, char digit) {
        int idx = -1;
        int n = number.length();
        for (int i = 0 ; i < n ; i++) {
            if (number.charAt(i) == digit) {
            idx = i;
            if (i < n - 1 && digit < number.charAt(i + 1)) {
                break;
            }
        }
        }
        number = number.substring(0 , idx) + number.substring(idx + 1 , n);
        return number;
    }
}

// number = "51563974"
// digit  = '5'