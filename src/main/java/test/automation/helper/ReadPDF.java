package test.automation.helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ReadPDF {

    private ReadPDF pdf=null;
    String pdfText=null;
    PdfReader reader=null;

    public ReadPDF getInstance()
    {
        if(pdf==null)
            pdf=new ReadPDF();
        return pdf;
    }


	public String getPDFText(String filepath,int pageNum)
	{
        try {
            reader = new PdfReader(filepath);
            if (!reader.isEncrypted())
                pdfText = PdfTextExtractor.getTextFromPage(reader, pageNum);
            else
                throw new RuntimeException("User Can't Read The Doc As Encrypted");
        }
        catch(Exception e)
        {
            reader.close();
            // To be Imp
        }
         return pdfText;
	}

    public String getPDFText(String filepath)
    {
        int pages=0;
        StringBuilder text=new StringBuilder();
        try {
            reader = new PdfReader(filepath);
            if (!reader.isEncrypted())
               pages=reader.getNumberOfPages();
            else
                throw new RuntimeException("User Can't Read The Doc As Encrypted");

            for(int pageIndex=1;pageIndex<=pages;pageIndex++)
            {
                text.append("\\n"+PdfTextExtractor.getTextFromPage(reader, pageIndex));
            }
        }
        catch (Exception e)
        {
            reader.close();
            // To be Imp
        }

        return pdfText;
    }


}
