package org.example.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.example.models.Invoice;
import org.example.models.Material;

import java.io.IOException;
import java.util.List;

public class InvoiceWriter {
    public static void writeInvoice(String filePath, Invoice invoice) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Invoice");
                contentStream.newLine();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLine();
                contentStream.showText("Hours Worked: " + invoice.getHoursWorked());
                contentStream.newLine();
                contentStream.showText("Price per Hour: $" + invoice.getPricePerHour());
                contentStream.newLine();
                contentStream.showText("Materials Used:");
                double yOffset = 0;
                for (Material material : invoice.getMaterials()) {
                    contentStream.newLine();
                    yOffset -= 15; // Adjust the Y offset to avoid overlapping
                    contentStream.newLineAtOffset((float) 0, (float) yOffset);
                    contentStream.showText(material.getDescription() + ": £" + material.getPrice());
                }
                contentStream.newLine();
                contentStream.showText("Total Cost: $" + calculateTotalCost(invoice));
                contentStream.endText();
            }

            document.save(filePath);
            System.out.println("Invoice generated successfully and saved as '" + filePath + "'");
        } catch (IOException e) {
            System.err.println("Error occurred while generating invoice: " + e.getMessage());
        }
    }

    private static double calculateTotalCost(Invoice invoice) {


        double totalCost = invoice.getHoursWorked() * invoice.getPricePerHour();
        for (Material material : invoice.getMaterials()) {
            totalCost += material.getPrice();
        }
        return totalCost;
    }
}
