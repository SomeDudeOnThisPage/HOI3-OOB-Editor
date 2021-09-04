package model;

import org.junit.jupiter.api.Test;

public class RegimentTest {
    @Test
    public void test() {
        final String data = TestUtils.load("regiment.txt");
/*
        try {

            //final Regiment regiment = new Regiment(data);
            Assertions.assertEquals(regiment.getType(), "militia_brigade");
            Assertions.assertEquals(regiment.getName(), "105. Landsturminfanterie");
            Assertions.assertTrue(regiment.isReserve());
            Assertions.assertEquals(regiment.getExperience(), 5);
            Assertions.assertEquals(regiment.getHistoricalModel(), 0);

        } catch (ParseException e) {
            Assertions.fail(e.toString());
        }*/
    }
}
