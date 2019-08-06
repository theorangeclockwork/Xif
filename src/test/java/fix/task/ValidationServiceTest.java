package fix.task;

import fix.task.service.ValidationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationServiceTest {

    private ValidationService validationService;

    @Before
    public void initObjects() throws Exception {
        validationService = new ValidationService();
    }

    @After
    public void tearDown() throws Exception {
        validationService = null;
    }

    @Test
    public void shouldCheckParams() {
        boolean result = validationService.checkParams("10", "10", "d2", "e10");
        assertTrue(result);

        result = validationService.checkParams("10", "10", "ad2", "1e10");
        assertFalse(result);

        result = validationService.checkParams("100", "100", "ad93", "n1");
        assertTrue(result);

        result = validationService.checkParams("100", "100", "ad93", null);
        assertFalse(result);
    }

    @Test
    public void shouldCheckParamsFormat() {
        boolean result = validationService.checkParamsFormat("10fj10", "-3", "22bb22", "bb220");
        assertFalse(result);

        result = validationService.checkParamsFormat("0", "0", "a0", "b0a10");
        assertFalse(result);

        result = validationService.checkParamsFormat("000109", "00230", "a0101", "ab030");
        assertTrue(result);
    }

    @Test
    public void shouldCheckParamsCompatibility() {
        boolean result = validationService.checkParamsCompatibility("100", "100", "ab30", "ba25");
        assertTrue(result);

        result = validationService.checkParamsCompatibility("10", "15", "ab30", "ba25");
        assertFalse(result);

        result = validationService.checkParamsCompatibility("10", "15", "b5", "ba25");
        assertFalse(result);
    }
}