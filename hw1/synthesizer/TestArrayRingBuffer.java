package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(true, arb.isEmpty());
        arb.enqueue(15.2);
        arb.enqueue(-9.5);
        arb.enqueue(552.1);
        assertEquals(false, arb.isFull());
        arb.peek();
        arb.dequeue();
        arb.peek();
    }

    /** Calls tests for ArrayRingBuffer. */
    /**public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }*/
} 
