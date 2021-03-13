package money;

import java.util.HashMap;
import java.util.Map;

class Bank {
	private Map<Pair, Integer> rates = new HashMap<>();

	Money reduce(Expression source, String to) {
		//		return Money.dollar(10);
		//		if (source instanceof Money)
		//			return ((Money) source).reduce(to);
		//
		//		Sum sum = (Sum) source;
		//		int amount = sum.augend.amount + sum.addend.amount;
		return source.reduce(this, to);
	}

	void addRate(String from, String to, int rate) {
		rates.put(new Pair(from, to), rate);
	}

	int rate(String from, String to) {
		if (from.equals(to)) {
			return 1;
		}

		return rates.get(new Pair(from, to));
	}
}
