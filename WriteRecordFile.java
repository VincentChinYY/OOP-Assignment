public class WriteRecordFile extends WriteFile {
    // public WriteRecordFile(String fileName) {
    // String data = "Record\n";
    // this.write(data, fileName);
    // }

    public void addRecord(Record record, String fileName) {
        String data = "";

        data += "Record ID: " + record.getRecordId() + "\n";
        data += "Customer Id: " + record.getCustomer().getId() + "\n";
        data += "Customer Name: " + record.getCustomer().getName() + "\n";
        data += "Customer Age: " + record.getCustomer().getAge() + "\n";
        data += "Customer Phone Number: " + record.getCustomer().getPhoneNumber() + "\n";
        data += "Customer Address: " + record.getCustomer().getAddress() + "\n";
        // data += "Product ID\t\tProduct Name\t\tUnit Price(RM)\t\tQuantity\t\tTotal(RM)\n"
        //         + "--------------------------------------------------------------------------------\n";
        // for (int i = 0; i < record.getProducts().size(); i++) {

        // String productId = record.getProducts().get(i).getId();
        // String productName = record.getProducts().get(i).getName();
        // double unitPrice = record.getProducts().get(i).getPrice();
        // int quantity = record.getQuantityList().get(i);
        // double total = record.getTotalList().get(i);
        // total = Math.round(total * 100.0) / 100.0;
        // data += productId + "\t\t\t" + productName + "\t\t " + unitPrice + "\t\t\t\t"
        // + quantity
        // + "\t\t\t\t"
        // + total
        // + "\n";
        // }
        data+="Product\n";
            data+="------------------------------\n";
        for (int i = 0; i < record.getProducts().size(); i++) {
            String productId = record.getProducts().get(i).getId();
            String productName = record.getProducts().get(i).getName();
            double unitPrice = record.getProducts().get(i).getPrice();
            int quantity = record.getQuantityList().get(i);
            double total = record.getTotalList().get(i);
            total = Math.round(total * 100.0) / 100.0;

            data += productId + "\t" + productName + "\tRM" + Math.round(unitPrice * 100.0) / 100.0 + " x " + quantity
                    + " = RM" + total + "\n";
        }
        data+="------------------------------\n";
        data += "Total Before Tax: RM" + String.valueOf(Math.round(record.getTotalBeforeTax() * 100.0) / 100.0) + "\n";
        data += "Total After Tax ("
                + String.valueOf(Math.round(record.getTax() * 100.0)) + "%): RM"
                + String.valueOf(Math.round(record.getTotalAfterTax() * 100.0) / 100.0) + "\n";

        data += "Payment Method: ";
        if (record.getPaymentMethod().getClass().getSimpleName() == "PayByCash") {
            data += "Cash\n";
            data += "Pay: RM" + Math.round(record.getCash() * 100.0) / 100.0 + "\n";
            data += "Change : RM" + Math.round((record.getCash() - record.getTotalAfterTax()) * 100.0) / 100.0 + "\n";
        } else if (record.getPaymentMethod().getClass().getSimpleName() == "PayByCreditCard") {
            data += "Credit Card\n";
            data += "Card Number:" + record.getCreditCard().getCardNumber() + "\n";
            data += "Expire Date: " + record.getCreditCard().getExpireDate() + "\n";
            data += "CCV: " + record.getCreditCard().getCcv() + "\n";
        } else {
            data += "Debit Card\n";
            data += "Card Number: " + record.getDebitCard().getCardNumber() + "\n";
            data += "Expire Date: " + record.getDebitCard().getExpireDate() + "\n";
            data += "CCV: " + record.getDebitCard().getCcv() + "\n";
        }
        data += "\n";
        System.out.println(data);
        this.writeAppend(data, fileName);
    }
}