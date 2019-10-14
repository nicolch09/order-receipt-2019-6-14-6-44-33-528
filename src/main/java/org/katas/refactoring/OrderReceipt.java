package org.katas.refactoring;

public class OrderReceipt {
    private static final double PERCENTAGE_AMOUNT = .10;
    private static final String TAB = "\t";
    private OrderInformation orderInformation;
    private StringBuilder outputMessage = new StringBuilder();
    private Double salesTax = 0d;
    private Double totalSalesTax = 0d;
    private Double totalAmount = 0d;


    public OrderReceipt(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }

    public String printReceipt() {
        String receiptHeader = "======Printing Orders======\n";
        String customerName = orderInformation.getCustomerName();
        String customerAddress = orderInformation.getCustomerAddress();
        outputMessage.append(receiptHeader + customerName + customerAddress);
        calculateAndAppendReceiptInformation(orderInformation);
        outputMessage.append("Sales Tax").append(TAB).append(totalSalesTax);
        outputMessage.append("Total Amount").append(TAB).append(totalAmount);
        return outputMessage.toString();
    }

    public void calculateAndAppendReceiptInformation(OrderInformation orderInformation){
        for (LineItem lineItem : orderInformation.getLineItems()) {
            outputMessage.append(lineItem.getDescription());
            outputMessage.append(TAB);
            outputMessage.append(lineItem.getPrice());
            outputMessage.append(TAB);
            outputMessage.append(lineItem.getQuantity());
            outputMessage.append(TAB);
            outputMessage.append(lineItem.totalAmount());
            outputMessage.append('\n');
            salesTax = lineItem.totalAmount() * PERCENTAGE_AMOUNT;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
    }
}