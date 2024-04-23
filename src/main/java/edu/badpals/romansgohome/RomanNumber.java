package edu.badpals.romansgohome;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private final String romanNum;

    private int decimalNum = 0;

    private RegexRomanNumber regexCol = null;

    public RomanNumber(String romanNum) {
        this.romanNum = romanNum;
        this.decimalNum = 0;
        regexCol = new RegexRomanNumber();
    }

    public int getDecimalNum() {
        return this.decimalNum;
    }

    public RegexRomanNumber getRegexCol() {
        return this.regexCol;
    }

    private List<String> regexCol() {
        return getRegexCol().getAllRegex();
    }

    private Matcher createMatch(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.romanNum);
        return matcher;
    }
    public int decimalValue(String romanNum){
        RomanSymbols symbol = Enum.valueOf(RomanSymbols.class, String.valueOf(romanNum));
        return symbol.getValor();
    }
    private void grupoSumaToDecimal(Matcher matcher) {
        while (matcher.find()) {
            this.decimalNum += decimalValue(matcher.group());
        }
    }
    public int toDecimal() {
        for(String regex : regexCol()){
            Matcher matcher = createMatch(regex);
            grupoSumaToDecimal(matcher);
        }
        return getDecimalNum();
    }


}
