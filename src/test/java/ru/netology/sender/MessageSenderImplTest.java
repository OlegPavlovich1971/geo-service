package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

public class MessageSenderImplTest {

    @ParameterizedTest
    @ArgumentsSource(EmployeesArgumentsProvider.class)
    public void testSend(Country country, String ip, String message) {
        Location location = new Location(null, country, null, 0);
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(any()))
                .thenReturn(location);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(country))
                .thenReturn(message);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String result = messageSender.send(headers);
        Assertions.assertEquals(message, result);
    }

}
