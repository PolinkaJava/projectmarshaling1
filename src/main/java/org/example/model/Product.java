package org.example.model;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class Product {
    private String type;
    private double price;

}
