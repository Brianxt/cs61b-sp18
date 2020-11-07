import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
	static CharacterComparator offByN = new OffByN(3);

	@Test
	public void testOffByN() {
		assertTrue(offByN.equalChars('a', 'd'));
		assertFalse(offByN.equalChars('a', 'c'));
		assertTrue(offByN.equalChars('5', '8'));
		assertFalse(offByN.equalChars('2', '0'));
	}
}
