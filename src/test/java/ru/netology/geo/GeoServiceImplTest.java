package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    @Test
    public void testByIpForLocalHost() {
        final String argument = "127.0.0.1";
        final Location expected = new Location(null, null, null, 0);
        final Location result = new GeoServiceImpl().byIp(argument);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testByIpForMoscowIp() {
        final String argument = "172.0.32.11";
        final Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        final Location result = new GeoServiceImpl().byIp(argument);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testByIpForNewYorkIp() {
        final String argument = "96.44.183.149";
        final Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        final Location result = new GeoServiceImpl().byIp(argument);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testByIpForRussia() {
        final String argument = "172.0.0.0";
        final Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        final Location result = new GeoServiceImpl().byIp(argument);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testByIpForUsa() {
        final String argument = "96.0.0.0";
        final Location expected = new Location("New York", Country.USA, null, 0);
        final Location result = new GeoServiceImpl().byIp(argument);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testByIpForOther() {
        final String argument = "15.0.0.0";
        final Location result = new GeoServiceImpl().byIp(argument);
        Assertions.assertNull(result);
    }

    @Test
    public void testByCoordinates() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new GeoServiceImpl().byCoordinates(0.0, 0.0));
    }

}
