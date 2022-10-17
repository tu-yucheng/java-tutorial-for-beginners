package cn.tuyucheng.taketoday.junit4vstestng;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortedUnitTest {

    @Test
    public void a_givenString_whenChangedToInt_thenTrue() {
        assertTrue(Integer.valueOf("10") instanceof Integer);
    }

    @Test
    public void b_givenInt_whenChangedToString_thenTrue() {
        assertTrue(String.valueOf(10) instanceof String);
    }
}