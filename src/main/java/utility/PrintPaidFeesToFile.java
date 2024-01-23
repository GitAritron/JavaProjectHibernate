package utility;

import dto.ReceiptInformationDTO;
import entity.Apartment;
import entity.Building;
import entity.Company;
import entity.Employee;
import net.bytebuddy.asm.Advice;
import utility.model.Receipt;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class PrintPaidFeesToFile {
    //TODO


    public static void printReceiptForPayment(ReceiptInformationDTO receiptInformationDTO, LocalDate paidOn) throws IOException {
        Receipt receipt = new Receipt(receiptInformationDTO.getCompanyIDNameDTO(), receiptInformationDTO.getEmployeeIDNameDTO(), receiptInformationDTO.getBuildingNoFeesDTO(), receiptInformationDTO.getApartmentDTO(), receiptInformationDTO.getAmount(), paidOn);
        try (FileWriter fw = new FileWriter("src/main/java/receipts/receipt" + LocalDate.now() + Receipt.getIdcounter());
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(receipt);

        }
    }
}
