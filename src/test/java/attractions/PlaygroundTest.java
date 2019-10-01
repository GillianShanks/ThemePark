package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor youngVisitor;
    Visitor oldVisitor;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        youngVisitor = new Visitor(7, 100, 10);
        oldVisitor = new Visitor(20, 180, 30);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void checksAllowedToEnter__pass() {
        assertTrue(playground.isAllowedTo(youngVisitor));
    }

    @Test
    public void checksAllowedToEnter__fail() {
        assertFalse(playground.isAllowedTo(oldVisitor));
    }
}
