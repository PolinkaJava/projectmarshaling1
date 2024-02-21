package org.example.jaxb;



import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.Order;
import org.example.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(OrderList.class);
            Marshaller marshaller = jc.createMarshaller();
            Order order = new Order();
            order.setName("Order");
            order.setDate("2024-02-07");

            Product product1 = new Product();
            product1.setType("Comp");
            product1.setPrice(3000.00);

            Product product2 = new Product();
            product2.setType("Telephone");
            product2.setPrice(3090.00);

            order.setProducts(List.of(product1, product2));

            marshaller.marshal(order, new File("C:\\Users\\user\\Desktop\\xml1.xml"));
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(order);
            System.out.println("JSON representation of the order: " + json);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}