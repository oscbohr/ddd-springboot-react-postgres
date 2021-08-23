package com.challenge.app.tienda.repositorio.modelo.pay;

import java.io.Serializable;

/**
 * STUB de API-REST PlaceToPay
 * @author ombohorquez
 *
 */
public class PaymentRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String reference;
	private Amount amount;
	private boolean allowPartial;
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/**
	 * @return the amount
	 */
	public Amount getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	/**
	 * @return the allowPartial
	 */
	public boolean isAllowPartial() {
		return allowPartial;
	}
	/**
	 * @param allowPartial the allowPartial to set
	 */
	public void setAllowPartial(boolean allowPartial) {
		this.allowPartial = allowPartial;
	}
	@Override
	public String toString() {
		return "PaymentRequest [reference=" + reference + ", amount=" + amount + ", allowPartial=" + allowPartial + "]";
	}
}
