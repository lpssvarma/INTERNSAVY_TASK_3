import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Initialize exchange rates
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.83);
        exchangeRates.put("GBP", 0.71);
        exchangeRates.put("JPY", 110.21);
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double rateFrom = exchangeRates.get(fromCurrency);
        double rateTo = exchangeRates.get(toCurrency);

        return amount * (rateTo / rateFrom);
    }

    public void displayCurrencies() {
        System.out.println("Available Currencies:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();

        System.out.println("Welcome to the Currency Converter!");

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        scanner.nextLine(); // Consume the newline character

        System.out.println("Available Currencies:");
        currencyConverter.displayCurrencies();

        System.out.print("Enter the currency to convert from: ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency to convert to: ");
        String toCurrency = scanner.nextLine().toUpperCase();

        double convertedAmount = currencyConverter.convert(amount, fromCurrency, toCurrency);

        System.out.println(amount + " " + fromCurrency + " is equivalent to " + convertedAmount + " " + toCurrency);

        scanner.close();
    }
}
