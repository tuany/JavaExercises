package exercises.challenges;

import static org.exercises.challenges.ChangeMoney.BILL_10;
import static org.exercises.challenges.ChangeMoney.BILL_5;
import static org.exercises.challenges.ChangeMoney.COIN_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.exercises.challenges.Change;
import org.exercises.challenges.ChangeMoney;
import org.junit.Test;
public class ChangeMoneyTest {

    @Test
    public void testDoHasChange() {
        ChangeMoney s = new ChangeMoney();
        Change c = s.optimalChange(49);
        assertNotNull(c);
        assertEquals(4, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(2, c.coin2);
        assertEquals(49,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));
        
        c = s.optimalChange(0);
        assertNotNull(c);
        assertEquals(0, c.bill10);
        assertEquals(0, c.bill5);
        assertEquals(0, c.coin2);
        assertEquals(0,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(51);
        assertNotNull(c);
        assertEquals(4, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(3, c.coin2);
        assertEquals(51,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));
        
        c = s.optimalChange(55);
        assertNotNull(c);
        assertEquals(5, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(0, c.coin2);
        assertEquals(55,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(53);
        assertNotNull(c);
        assertEquals(4, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(4, c.coin2);
        assertEquals(53,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(10);
        assertNotNull(c);
        assertEquals(1, c.bill10);
        assertEquals(0, c.bill5);
        assertEquals(0, c.coin2);
        assertEquals(10,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(2);
        assertNotNull(c);
        assertEquals(0, c.bill10);
        assertEquals(0, c.bill5);
        assertEquals(1, c.coin2);
        assertEquals(2,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(7);
        assertNotNull(c);
        assertEquals(0, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(1, c.coin2);
        assertEquals(7,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(5);
        assertNotNull(c);
        assertEquals(0, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(0, c.coin2);
        assertEquals(5,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(15);
        assertNotNull(c);
        assertEquals(1, c.bill10);
        assertEquals(1, c.bill5);
        assertEquals(0, c.coin2);
        assertEquals(15,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));

        c = s.optimalChange(12);
        assertNotNull(c);
        assertEquals(1, c.bill10);
        assertEquals(0, c.bill5);
        assertEquals(1, c.coin2);
        assertEquals(12,
                (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));
    }

    @Test
    public void testDoesNotHasChange() {
        ChangeMoney s = new ChangeMoney();
        assertNull(s.optimalChange(1));
        assertNull(s.optimalChange(3));
        assertNull(s.optimalChange(-5));
    }

    @Test
    public void testChangeSum() {
        ChangeMoney s = new ChangeMoney();
        Change c = null;

        for (int i = 4; i < 10000000; i++) {
            c = s.optimalChange(i);
            assertEquals(i, (c.bill10 * BILL_10) + (c.bill5 * BILL_5) + (c.coin2 * COIN_2));
            assertTrue(c.bill5 < 2);
            assertTrue(c.coin2 < 5);
        }
        System.out.println(c);
    }

}
