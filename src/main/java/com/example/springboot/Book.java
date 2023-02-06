package com.example.springboot;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    String ID;
    String lists;
    int price;
}
