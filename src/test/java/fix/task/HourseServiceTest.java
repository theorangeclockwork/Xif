package fix.task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class HourseServiceTest {

    private HourseService hourseService;

    @Before
    public void setUp() throws Exception {
        hourseService = new HourseService();
    }

    @After
    public void tearDown() throws Exception {
        hourseService = null;
    }


    @Test
    public void shouldFindAndCount() {

        //имитация поиска пути со стартовой позицией b1 в конечную позицию f6 с учетом сделанного одного шага
        List<Position> temp = new ArrayList<>();
        temp.add(new Position(2, 1));
        temp.add(new Position(1, 3));
        temp.add(new Position(3, 3));
        temp.add(new Position(4, 2));
        int result = hourseService.findAndCount(temp, new Position(6, 6), 2, 8, 8, 3);

        Assert.assertEquals(3, result);

        //недостижимая позиция
        temp = new ArrayList<>();
        temp.add(new Position(1, 1));
        result = hourseService.findAndCount(temp, new Position(2, 1), 1, 2, 8, 0);

        Assert.assertEquals(-1, result);
    }


}