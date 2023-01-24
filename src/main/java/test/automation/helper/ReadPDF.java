package test.automation.helper;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ReadPDF {

    //To Be Implement
	public void getpdfdata(String filepath,int pageNum) throws IOException, DocumentException 
	{
	//Document document = new Document();
//    PdfWriter writer = PdfWriter.getInstance(document,
//    new FileOutputStream(filepath));
//    document.open();
    PdfReader reader = new PdfReader(filepath);
    //int n = reader.getNumberOfPages();
    if(!reader.isEncrypted()) {
    String text=PdfTextExtractor.getTextFromPage(reader, pageNum);
   
    //Page Navigation 
//    for (int i = 1; i <= n; i++) {
//        if (i == 2) {
//      
//          //  page = writer.getImportedPage(reader, i);
//            Image instance = Image.getInstance();
//            document.add(instance);
//        }
//    }
    
   // document.close();
    System.out.println("pdfContent"+text);
    }
	}

	
}
