public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            charCount[ransomNote.charAt(i) - 'a']--;
            if (charCount[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ransomNote = "aa";
        String magazine = "aab";
        if (s.canConstruct(ransomNote, magazine)) {
            System.out.println("Can construct");
        }
    }
}