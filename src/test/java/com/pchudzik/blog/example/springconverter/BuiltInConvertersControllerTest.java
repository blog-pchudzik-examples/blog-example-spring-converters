package com.pchudzik.blog.example.springconverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BuiltInConvertersController.class)
public class BuiltInConvertersControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConversionArgumentCaptor captor;

    @Test
    public void should_convert_locale() throws Exception {
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/builtin-converters/locale?value=en"))

                //then
                .andExpect(status().isOk());
        Mockito.verify(captor).captureLocale(Locale.ENGLISH);
    }

    @Test
    public void should_convert_currency() throws Exception {
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/builtin-converters/currency?value=PLN"))   //note must be upper case

                //then
                .andExpect(status().isOk());
        Mockito.verify(captor).captureCurrency(Currency.getInstance("PLN"));
    }

    @Test
    public void should_convert_map() throws Exception {
        //given
        final Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("a", "1");
        expectedMap.put("b", "2");

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/builtin-converters/map?a=1&b=2"))

                //then
                .andExpect(status().isOk());
        Mockito.verify(captor).captureMap(expectedMap);
    }

    @Test
    public void should_convert_any_map_to_map_of_string_to_string() throws Exception {
        //given
        final Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put(AnyEnum.FIRST.toString(), "1");
        expectedMap.put(AnyEnum.SECOND.toString(), "2");

        //when
        //controller signature: public void stringToMapWithEnumsConverter(@RequestParam Map<AnyEnum, Integer> map)
        mockMvc.perform(MockMvcRequestBuilders.get("/builtin-converters/map-with-enum?FIRST=1&SECOND=2"))

                //then
                .andExpect(status().isOk());
        Mockito.verify(captor).captureMapWithEnum(expectedMap);
    }

    @Test
    public void should_convert_stream() throws Exception {
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/builtin-converters/stream?stream=1,2,3"))

                //then
                .andExpect(status().isOk());
        Mockito.verify(captor).captureStream(Stream.of(1, 2, 3));
    }
}