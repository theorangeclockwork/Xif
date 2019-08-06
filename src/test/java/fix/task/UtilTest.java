package fix.task;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void shouldConvertToDecimal() throws Exception{
        int result = Util.convertToDecimal("ab", 26);
        Assert.assertEquals(28, result);
    }

    @Test
    public void shouldExtractVertical() {
        String result = Util.extractVertical("AbdrRf3359");
        Assert.assertEquals("AbdrRf", result);

        result = Util.extractVertical("234324");
        Assert.assertEquals("-2", result);
    }

    @Test
    public void shouldExtractHorizontal() {
        int result = Util.extractHorizontal("AbdrRf3359");
        Assert.assertEquals(3359, result);

        result = Util.extractHorizontal("djnfhf");
        Assert.assertEquals(-2, result);
    }
}