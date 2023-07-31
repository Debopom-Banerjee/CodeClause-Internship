import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import java.util.List;

public class PdfSplitter {

    public static void splitPDF(String inputFilePath, String outputDirectory) throws IOException {
        File inputFile = new File(inputFilePath);
        PDDocument document = Loader.loadPDF(inputFile);

        Splitter splitter = new Splitter();
        List<PDDocument> pages = splitter.split(document);

        int pageNumber = 1;
        for (PDDocument page : pages) {
            String outputPath = outputDirectory + "page_" + pageNumber + ".pdf";
            page.save(outputPath);
            page.close();
            pageNumber++;
        }

        document.close();
    }

    public static void main(String[] args) {
        String inputFilePath = "\"C:\\Users\\debopom banerjee\\Downloads\\Multiple Assessment_Soham Das.pdf\"";
        String outputDirectory = "C:\\Users\\debopom banerjee\\Documents\\3rd Sem";

        try {
            splitPDF(inputFilePath, outputDirectory);
            System.out.println("PDF split successful!");
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
