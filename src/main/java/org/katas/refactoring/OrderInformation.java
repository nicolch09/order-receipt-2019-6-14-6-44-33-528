package org.katas.refactoring;

import java.util.List;

public class OrderInformation {
    String name;
    String address;
    List<LineItem> lineItems;

    public OrderInformation(String name, String address, List<LineItem> lineItems) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
