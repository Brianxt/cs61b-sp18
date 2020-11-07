import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /**You must use this palindrome, and not instantiate
    new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("tat"));
        assertTrue(palindrome.isPalindrome("0"));
        assertFalse(palindrome.isPalindrome("abc"));
        assertFalse(palindrome.isPalindrome("1231"));
        assertTrue(palindrome.isPalindrome(""));
    }

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void test2isPalindrome() {
        assertTrue(palindrome.isPalindrome("acb", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("1", offByOne));
        assertFalse(palindrome.isPalindrome("abc", offByOne));
        assertFalse(palindrome.isPalindrome("bade", offByOne));
        assertTrue(palindrome.isPalindrome("rstq", offByOne));
    }
}
