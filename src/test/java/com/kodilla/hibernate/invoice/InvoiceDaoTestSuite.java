package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.task.TaskDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testFindByPaid() {

        //Given
        Product product1 = new Product(1,"ananas");

        Item item1 = new Item(1,product1,new BigDecimal(3.50),2,new BigDecimal(7));

        Invoice invoice = new Invoice(1,"2021/01/258");

        invoice.



    }
}
