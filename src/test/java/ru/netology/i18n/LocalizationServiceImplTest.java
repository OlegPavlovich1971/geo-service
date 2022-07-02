package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class LocalizationServiceImplTest {

    @Test
    public void testLocaleForRussia() {
        final String expected = "Добро пожаловать";
        final String result = new LocalizationServiceImpl().locale(RUSSIA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testLocaleForOther() {
        final String expected = "Welcome";
        final String result = new LocalizationServiceImpl().locale(USA);
        Assertions.assertEquals(expected, result);
    }

}
