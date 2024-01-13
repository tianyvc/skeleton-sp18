import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 

    @Test
    public void testIsPalindrome()
    {
        assertTrue(parlindrome.isPalindorme(""));
        assertTrue(parlindrome.isPalindorme("a"));
        assertTrue(parlindrome.isPalindorme("aba"));
        assertTrue(parlindrome.isPalindorme("aaccbbbccaa"));

        assertFalse(parlindrome.isPalindorme("ab"));
        assertFalse(parlindrome.isPalindorme("ababba"));
    }

    @Test
    public void testIsOffByOnePalindrome()
    {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aba", cc));
    }
}
