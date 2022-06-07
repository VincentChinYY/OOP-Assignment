public class WriteReceiptFile extends WriteFile {

        // public WriteReceiptFile(String fileName) {
        // String data =
        // "================================================================================\n"
        // + "\t\t\t\t\t\tABC Supermarket\n" + "\t\tNo 100, Jalan ABC, Taman XYZ, 20000,
        // Kuala Lumpuer, Malaysia\n"
        // + "\t\t\t\t\t\tDate: 10/10/2022\n"
        // +
        // "================================================================================\n";
        // this.write(data, fileName);
        // }

        public void WriteReceipt(Record record, String fileName) {
                // String data = "";
                String data = "================================================================================\n"
                                + "\t\t\t\t\t\tABC Supermarket\n"
                                + "\t\tNo 100, Jalan ABC, Taman XYZ, 20000, Kuala Lumpuer, Malaysia\n"
                                + "\t\t\t\t\t\tDate: " + record.getDate() + "\n"
                                + "================================================================================\n";

                data += "\t\t\t\t\t\tRecord ID:" + record.getRecordId() + "\n\n";
                data += "Product ID\t\tProduct Name\t\tUnit Price(RM)\t\tQuantity\t\tTotal(RM)\n"
                                + "--------------------------------------------------------------------------------\n";
                for (int i = 0; i < record.getProducts().size(); i++) {

                        String productId = record.getProducts().get(i).getId();
                        String productName = record.getProducts().get(i).getName();
                        double unitPrice = record.getProducts().get(i).getPrice();
                        int quantity = record.getQuantityList().get(i);
                        double total = record.getTotalList().get(i);
                        total = Math.round(total * 100.0) / 100.0;
                        data += productId + "\t\t\t" + productName + "\t\t    " + unitPrice + "\t\t\t\t" + quantity
                                        + "\t\t\t\t"
                                        + total
                                        + "\n";
                }

                data += "\n--------------------------------------------------------------------------------\n";
                data += "\t\t\t\t\t\t\t\t\t\t\t\t\t    Total Before Tax: RM"
                                + String.valueOf(Math.round(record.getTotalBeforeTax() * 100.0) / 100.0) + "\n";

                data += "\t\t\t\t\t\t\t\t\t\t\t\t\tTotal After Tax ("
                                + String.valueOf(Math.round(record.getTax() * 100.0)) + "%): RM"
                                + String.valueOf(Math.round(record.getTotalAfterTax() * 100.0) / 100.0) + "\n";
                                
                if (record.getPaymentMethod().getClass().getSimpleName() == "PayByCash") {
                        data += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Payment: RM"
                                        + Math.round(record.getCash() * 100.0) / 100.0
                                        + "\n";
                        data += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Change : RM"
                                        + Math.round((record.getCash() - record.getTotalAfterTax()) * 100.0) / 100.0
                                        + "\n";
                }
                // if (record.getPaymentMethod().getClass().getSimpleName() ==
                // "PayByCreditCard") {
                // data += "t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPayment Method: Credit Card";
                // }
                // if (record.getPaymentMethod().getClass().getSimpleName() == "PayByDeditCard")
                // {
                // data += "t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPayment Method: Dedit Card";
                // }

                this.write(data, fileName);
        }
}
