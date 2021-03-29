package money;

class Money implements Expression {
	protected int amount;
	protected String currency;

	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	};

	String currency() {
		return currency;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && currency.equals(money.currency);
	}

	public String toString() {
		return amount + " " + currency;
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	public Money reduce(Bank bank, String to) {
		//		return this;
		int rate = bank.rate(currency, to);
//		int rate = (currency.equals("CHF") && to.contentEquals("USD")) ? 2 : 1;
//		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
}
