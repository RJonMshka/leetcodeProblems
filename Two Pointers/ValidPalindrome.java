public class Palindrome {
    public static void main(String[] args) {
        new Palindrome().isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;

        while(l < h) {
            while(l < h && !this.isAlphaNumeric(s.charAt(l))) {
                l += 1;
            }

            while(l < h && !this.isAlphaNumeric(s.charAt(h))) {
                h -= 1;
            }

            char low = s.charAt(l);
            char high = s.charAt(h);

            if (isUpperAlpha(low)) {
                low = Character.toLowerCase(low);
            }

            if (isUpperAlpha(high)) {
                high = Character.toLowerCase(high);
            }

            if(low != high) {
                return false;
            }
            l += 1;
            h -= 1;
        }

        return true;


    }

    public boolean isAlphaNumeric(char c) {
        return this.isLowerAlpha(c) || this.isUpperAlpha(c) || this.isNumeric(c);
    }

    public boolean isLowerAlpha(char c) {
        return (int)'a' <= (int) c && (int) c <= (int)'z';
    }

    public boolean isUpperAlpha(char c) {
        return (int)'A' <= (int) c && (int) c <= (int)'Z';
    }

    public boolean isNumeric(char c) {
        return (int)'0' <= (int) c && (int) c <= (int)'9';
    }
}
