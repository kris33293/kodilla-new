package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testFindByPaid() {

        //Given
        Product product1 = new Product(1,"ananas");
        Product product2 = new Product(2,"jajka");

        Item item1 = new Item(1,new BigDecimal(3.50),2,new BigDecimal(7));
        Item item2 = new Item(2,new BigDecimal(4.50),5,new BigDecimal(22.5));

        Invoice invoice = new Invoice(1,"2021/01/258");

        item1.setProducts(product1);
        item1.setProducts(product2);

        item2.setProducts(product1);
        item2.setProducts(product2);

        invoice.setItem(item1);
        invoice.setItem(item2);
        //When

        invoiceDao.save(invoice);

        int invoiceId = invoice.getId();

        //Then

        assertNotEquals(0, invoiceId);




    }
}
