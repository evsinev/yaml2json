package com.payneteasy.yaml2json.example;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(makeFinal = true, level = PRIVATE)
@Builder
public class ExampleRequest {
    String name;
    long              id;
    List<ExampleItem> items;
    ExampleItem       item;
}
