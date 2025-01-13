package app;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    private boolean useLowercase = true;
    private boolean useUppercase = true;
    private boolean useNumbers = true;
    private boolean useSpecial = true;
    private int defaultLength = 12;

    public PasswordGenerator() {}

    public PasswordGenerator(boolean useLowercase, boolean useUppercase,
                             boolean useNumbers, boolean useSpecial, int defaultLength) {
        this.useLowercase = useLowercase;
        this.useUppercase = useUppercase;
        this.useNumbers = useNumbers;
        this.useSpecial = useSpecial;
        this.defaultLength = defaultLength;
    }

    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        StringBuilder validChars = new StringBuilder();

        if (useLowercase) validChars.append(LOWERCASE_CHARS);
        if (useUppercase) validChars.append(UPPERCASE_CHARS);
        if (useNumbers) validChars.append(NUMBERS);
        if (useSpecial) validChars.append(SPECIAL_CHARS);

        // Проверка на случай, если не выбран ни один тип символов
        if (validChars.length() == 0) {
            throw new IllegalStateException("At least one character type must be selected");
        }

        // Генерация пароля
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }

    // Генерация пароля с длиной по умолчанию
    public String generatePassword() {
        return generatePassword(defaultLength);
    }


    // Геттеры и сеттеры
    public void setUseLowercase(boolean useLowercase) {
        this.useLowercase = useLowercase;
    }

    public void setUseUppercase(boolean useUppercase) {
        this.useUppercase = useUppercase;
    }

    public void setUseNumbers(boolean useNumbers) {
        this.useNumbers = useNumbers;
    }

    public void setUseSpecial(boolean useSpecial) {
        this.useSpecial = useSpecial;
    }

    public void setDefaultLength(int defaultLength) {
        if (defaultLength < 1) {
            throw new IllegalArgumentException("Password length must be positive");
        }
        this.defaultLength = defaultLength;
    }
}