package org.alnyli.tcmb;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CurrencyHandler extends DefaultHandler{

	private StringBuffer buffer;
	private ArrayList<Currency> currencyies ;
	private Currency currency;

	public CurrencyHandler() {
		currencyies = new ArrayList<Currency>(0);
		buffer = new StringBuffer();
	}
	 @Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// System.out.println("stElm: "+qName+" | "+qName+" Buffer: "+buffer);
		 buffer.setLength(0); 
		 if(qName.equals("Currency")){
			 currency = new Currency(); 
			 currency.setCurrencyCode(attributes.getValue("CurrencyCode"));
		 }
	}
	 
	 @Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// System.out.println("endElm: "+qName+" | "+qName+" Buffer: "+buffer);
		 if(qName.equals("Currency")){
			 currencyies.add(currency);
		 }else if(qName.equals("Unit")){
			 if(!buffer.toString().isEmpty())
				 currency.setUnit(Integer.parseInt(buffer.toString()));
		 }else if( qName.equals("CurrencyName")){
			 if(!buffer.toString().isEmpty())
				 currency.setCurencyName(buffer.toString());
		 }else if( qName.equals("ForexBuying")){
			 if(!buffer.toString().isEmpty())
				 currency.setForexBuying(Float.parseFloat(buffer.toString()));
		 }else if( qName.equals("ForexSelling")){
			 if(!buffer.toString().isEmpty())
				 currency.setForexSelling(Float.parseFloat(buffer.toString()));
		 }else if( qName.equals("BanknoteBuying")){
			 if(!buffer.toString().isEmpty())
				 currency.setBanknoteBuying(Float.parseFloat(buffer.toString()));
		 }else if( qName.equals("BanknoteSelling")){
			 if(!buffer.toString().isEmpty())
				 currency.setBanknoteSelling(Float.parseFloat(buffer.toString()));
		 }else if( qName.equals("CrossRateUSD")){
			 if(!buffer.toString().isEmpty())
				 currency.setCrossRateUSD(Float.parseFloat(buffer.toString()));
		 }
		 
	}
	 
	  @Override
	  public void characters(char[] ch, int start, int length) {
	  	  buffer.append(ch, start, length);
	  }
	  
	  public ArrayList<Currency> getCurrencies(){
		  return currencyies;
	  }

}
