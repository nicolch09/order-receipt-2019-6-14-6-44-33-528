package org.katas.refactoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class OrderReceiptTest {
    @Test
    public void should_Print_Customer_Information_On_Order() {
        List<LineItem> lineItem = new ArrayList<LineItem>();
        OrderInformation order = new OrderInformation("Christoper", "Cavite, 60601", lineItem);
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output).contains("Christoper", "Cavite, 60601");
    }

    @Test
    public void should_Print_Line_Item_And_Sales_Tax_Information() {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new OrderInformation(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output).contains(
                "milk\t10.0\t2\t20.0\n",
                "biscuits\t5.0\t5\t25.0\n",
                "chocolate\t20.0\t1\t20.0\n",
                "Sales Tax\t6.5",
                "Total Amount\t71.5"
        );
    }

}
