package edu.badpals.romansgohome;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegexRomanNumber {

    private final Map <String,String >  regexCollection = new HashMap<String, String>();

    public RegexRomanNumber() {
        this.initRegexCollection();
    }
    public  String getRegex(String key) {
        return this.regexCollection.get(key);
    }
    void addRegex(String key, String value) {
		this.regexCollection.putIfAbsent(key, value);
	}

    private void initRegexCollection(){
        this.addRegex("grupoSuma","(?<!I)[XV] | (?<!X)[LC] | (?<!C)[DM] | (?<!C)[DM] ");
        this.addRegex("grupoResta","I[XV] | X[LC] | C[DM] ");
    }
    public List<String> getAllRegex(){
        return this.regexCollection.values().stream().collect(Collectors.toList());
    }

     


}
