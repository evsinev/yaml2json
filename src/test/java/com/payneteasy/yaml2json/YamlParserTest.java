package com.payneteasy.yaml2json;

import com.payneteasy.yaml2json.example.ExampleRequest;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class YamlParserTest {

    @Test
    public void test() {
        YamlParser     parser  = new YamlParser();
        ExampleRequest request = parser.parseFile(new File("src/test/resources/example-01.yaml"), ExampleRequest.class);
        assertNotNull(request);
        assertEquals("name-1", request.getName());
        assertEquals(123, request.getId());
        assertNotNull(request.getItem());
        assertEquals(0, request.getItem().getItemId());
        assertEquals("item", request.getItem().getItemName());

        assertNotNull(request.getItems());
        assertEquals(2, request.getItems().size());

        assertEquals("item-0", request.getItems().get(0).getItemName());
        assertEquals(0       , request.getItems().get(0).getItemId());

        assertEquals("item-1", request.getItems().get(1).getItemName());
        assertEquals(1       , request.getItems().get(1).getItemId());


    }
}