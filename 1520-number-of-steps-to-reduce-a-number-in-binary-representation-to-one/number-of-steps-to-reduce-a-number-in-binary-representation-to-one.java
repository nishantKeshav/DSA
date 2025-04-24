class Solution {
    // public int numSteps(String s) {
    //     int n = s.length() - 1;
    //     int ops = 0 , carry = 0;
    //     for (int i = s.length() - 1 ; i >= 1 ; i--) {
    //         char ch = s.charAt(i);
    //         int num = ch - '0';
    //         if (((num + carry) % 2) == 1) {
    //             ops += 2;
    //             carry = 1;
    //         } else {
    //             ops += 1;
    //         }
    //     }
    //     return ops + carry;
    // }


    private void addOne(StringBuilder s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }
        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int op = 0;
        while (sb.length() > 1) {
            int n = sb.length();
            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(n - 1);
            } else {
                addOne(sb);
            }
            op++;
        }

        return op;
    }
}