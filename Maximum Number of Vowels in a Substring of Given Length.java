class Solution {
  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public int maxVowels(String s, int k) {
    int cnt = 0, max = 0;

    for (var i=0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) cnt++;
      if (i >= k && isVowel(s.charAt(i-k))) cnt--;
      
      max = Math.max(max, cnt);
    }
    return max;
  }
}
