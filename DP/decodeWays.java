class Solution {
    public int numDecodings(String s) {
        int right = 0;
        int left = 1;
        int res = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                res = 0;
            } else {
                res = left;
            }

            if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1 )) ) {
                res += right;
            }
            right = left;
            left = res;
        }

        return res;
    }
}