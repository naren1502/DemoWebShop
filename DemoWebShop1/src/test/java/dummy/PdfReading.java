package dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class PdfReading {
	public static void main(String[] args) throws IOException, SAXException, TikaException {
		
		
				BodyContentHandler contentHandler=new BodyContentHandler();
		
		FileInputStream fis=new FileInputStream(new File("./src/test/resources/testData/Framework.pdf"));
		
		Metadata metaData=new Metadata();
		
		ParseContext parseContext=new ParseContext();
		
		PDFParser parser=new PDFParser();
		
		parser.parse(fis, contentHandler, metaData, parseContext);
		
		System.out.println(contentHandler.toString());
	}

}
