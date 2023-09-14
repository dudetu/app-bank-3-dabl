package com.example.appbank2.additions;

import java.util.Random;

public class AccountGenerator {
    private static final String BANK_ACCOUNT_REGEX = "\\d{10}"; // Регулярное выражение для 10-значного номера банковского счета
    private static final String CREDIT_CARD_REGEX = "\\d{16}"; // Регулярное выражение для 16-значного номера кредитной карты

    private static final String VISA_PREFIX = "4";
    private static final String MASTERCARD_PREFIX = "5";

    private final Random random;

    public AccountGenerator() {
        random = new Random();
    }

    /**
     * Генерирует случайный номер банковского счета.
     *
     * @return сгенерированный номер банковского счета
     */
    public String generateBankAccountNumber() {
        StringBuilder builder = new StringBuilder();

        while (builder.length() < 16) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        return builder.toString();
    }

    /**
     * Генерирует случайный номер кредитной карты.
     *
     * @param cardType тип кредитной карты (например, "visa", "mastercard")
     * @return сгенерированный номер кредитной карты
     */
    public String generateCreditCardNumber(String cardType) {
        StringBuilder builder = new StringBuilder();

        String prefix = "";

        if (cardType.equalsIgnoreCase("visa")) {
            prefix = VISA_PREFIX;
        } else if (cardType.equalsIgnoreCase("mastercard")) {
            prefix = MASTERCARD_PREFIX;
        }

        builder.append(prefix);

        while (builder.length() < 16) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        return builder.toString();
    }

    /**
     * Генерирует случайный номер банковского счета, соответствующий указанному регулярному выражению.
     *
     * @param regexPattern регулярное выражение для номера банковского счета
     * @return сгенерированный номер банковского счета
     */
    public String generateCustomBankAccountNumber(String regexPattern) {
        String generatedNumber = generateBankAccountNumber();

        while (!generatedNumber.matches(regexPattern)) {
            generatedNumber = generateBankAccountNumber();
        }

        return generatedNumber;
    }

    /**
     * Генерирует случайный номер кредитной карты, соответствующий указанному регулярному выражению.
     *
     * @param regexPattern регулярное выражение для номера кредитной карты
     * @param cardType     тип кредитной карты (например, "visa", "mastercard")
     * @return сгенерированный номер кредитной карты
     */
    public String generateCustomCreditCardNumber(String regexPattern, String cardType) {
        String generatedNumber = generateCreditCardNumber(cardType);

        while (!generatedNumber.matches(regexPattern)) {
            generatedNumber = generateCreditCardNumber(cardType);
        }

        return generatedNumber;
    }

    public static void main(String[] args) {
        AccountGenerator accountGenerator = new AccountGenerator();

        for (int i = 0; i < 1; i++) {
            String bankAccountNumber = accountGenerator.generateBankAccountNumber();
            System.out.println("Bank Account Number: " + bankAccountNumber);

            String visaCardNumber = accountGenerator.generateCreditCardNumber("visa");
            System.out.println("Visa Card Number: " + visaCardNumber);

            String mastercardNumber = accountGenerator.generateCreditCardNumber("mastercard");
            System.out.println("Mastercard Number: " + mastercardNumber);
        }
    }
}




