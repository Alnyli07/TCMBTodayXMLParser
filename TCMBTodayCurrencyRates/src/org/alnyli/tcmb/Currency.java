package org.alnyli.tcmb;

public class Currency {
	
	private String currencyCode;
	private String curencyName;
	private int    unit;
	private float  forexBuying;
	private float  forexSelling;
	private float  banknoteBuying;
	private float  banknoteSelling;
	private float  crossRateUSD;

	public Currency() {
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurencyName() {
		return curencyName;
	}

	public void setCurencyName(String curencyName) {
		this.curencyName = curencyName;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public float getForexBuying() {
		return forexBuying;
	}

	public void setForexBuying(float forexBuying) {
		this.forexBuying = forexBuying;
	}

	public float getForexSelling() {
		return forexSelling;
	}

	public void setForexSelling(float forexSelling) {
		this.forexSelling = forexSelling;
	}

	public float getBanknoteBuying() {
		return banknoteBuying;
	}

	public void setBanknoteBuying(float banknoteBuying) {
		this.banknoteBuying = banknoteBuying;
	}

	public float getBanknoteSelling() {
		return banknoteSelling;
	}

	public void setBanknoteSelling(float banknoteSelling) {
		this.banknoteSelling = banknoteSelling;
	}

	public float getCrossRateUSD() {
		return crossRateUSD;
	}

	public void setCrossRateUSD(float crossRateUSD) {
		this.crossRateUSD = crossRateUSD;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n"+curencyName);
		sb.append(" "+currencyCode);
		sb.append(" "+forexBuying);
		sb.append(" "+forexSelling);
		sb.append(" "+banknoteBuying);
		sb.append(" "+banknoteSelling);
		sb.append(" "+crossRateUSD);
		return sb.toString();
	}

}
