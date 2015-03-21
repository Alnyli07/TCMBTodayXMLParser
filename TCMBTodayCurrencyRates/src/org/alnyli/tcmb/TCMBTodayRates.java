package org.alnyli.tcmb;

import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class TCMBTodayRates {

	private static final String TCMB_KUR = "http://www.tcmb.gov.tr/kurlar/today.xml";
	
	public TCMBTodayRates(){
		
	}
	
	public static void main(String[] args){
		ArrayList<Currency> currencies = new TCMBTodayRates().parseCurrencyResponse(TCMB_KUR);
		for (int i = 0; i < currencies.size(); i++) {
			System.out.println(currencies.get(i));
		}
	}
	
	/* TCMB XML PARSER */
	private  XMLReader initializeReader(){
	  SAXParserFactory factory = SAXParserFactory.newInstance();
	  try {
		  SAXParser parser = factory.newSAXParser();
		  XMLReader xmlreader = parser.getXMLReader();
		  return xmlreader;
	  } catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
	  }
	  return null;	 	  
    }
	
	public  ArrayList<Currency> parseCurrencyResponse(String xml) {
		try {
			XMLReader xmlreader = initializeReader();
			CurrencyHandler currencyHandler = new CurrencyHandler();
			xmlreader.setContentHandler(currencyHandler);
			// perform the synchronous parse
			xmlreader.parse(xml);
			return currencyHandler.getCurrencies();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
	    } 
     }

}
