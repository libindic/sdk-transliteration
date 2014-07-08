package org.silpa.transliteration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sujith on 6/7/14.
 */
public class IndicUtils {

    public static final String PUNCTUATIONS = "[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]";

    public static Map<String, String> kannadaEnglishDict = new HashMap<>();

    static {
        kannadaEnglishDict.put("ಅ", "a");
        kannadaEnglishDict.put("ಆ", "aa");
        kannadaEnglishDict.put("ಇ", "i");
        kannadaEnglishDict.put("ಈ", "i");
        kannadaEnglishDict.put("ಉ", "u");
        kannadaEnglishDict.put("ಊ", "u");
        kannadaEnglishDict.put("ಋ", "rri");
        kannadaEnglishDict.put("ಎ", "e");
        kannadaEnglishDict.put("ಏ", "e");
        kannadaEnglishDict.put("ಐ", "ai");
        kannadaEnglishDict.put("ಒ", "o");
        kannadaEnglishDict.put("ಓ", "o");
        kannadaEnglishDict.put("ಔ", "au");
        kannadaEnglishDict.put("ಂ", "m");
        kannadaEnglishDict.put("ಃ", "h");
        kannadaEnglishDict.put("ಕ", "k");
        kannadaEnglishDict.put("ಖ", "kh");
        kannadaEnglishDict.put("ಗ", "g");
        kannadaEnglishDict.put("ಘ", "gh");
        kannadaEnglishDict.put("ಙ", "ng");
        kannadaEnglishDict.put("ಚ", "ch");
        kannadaEnglishDict.put("ಛ", "chh");
        kannadaEnglishDict.put("ಜ", "j");
        kannadaEnglishDict.put("ಝ", "jhh");
        kannadaEnglishDict.put("ಞ", "nj");
        kannadaEnglishDict.put("ತ", "th");
        kannadaEnglishDict.put("ಥ", "thh");
        kannadaEnglishDict.put("ದ", "d");
        kannadaEnglishDict.put("ಧ", "dh");
        kannadaEnglishDict.put("ನ", "n");
        kannadaEnglishDict.put("ಟ", "T");
        kannadaEnglishDict.put("ಠ", "Th");
        kannadaEnglishDict.put("ಡ", "D");
        kannadaEnglishDict.put("ಢ", "Dh");
        kannadaEnglishDict.put("ಣ", "N");
        kannadaEnglishDict.put("ಪ", "p");
        kannadaEnglishDict.put("ಫ", "ph");
        kannadaEnglishDict.put("ಬ", "b");
        kannadaEnglishDict.put("ಭ", "bh");
        kannadaEnglishDict.put("ಮ", "m");
        kannadaEnglishDict.put("ಯ", "y");
        kannadaEnglishDict.put("ರ", "r");
        kannadaEnglishDict.put("ಲ", "l");
        kannadaEnglishDict.put("ವ", "v");
        kannadaEnglishDict.put("ಶ", "sh");
        kannadaEnglishDict.put("ಷ", "shh");
        kannadaEnglishDict.put("ಸ", "s");
        kannadaEnglishDict.put("ಹ", "h");
        kannadaEnglishDict.put("ಳ", "L");
        kannadaEnglishDict.put("ಋ", "rri");
        kannadaEnglishDict.put("್", "");
        kannadaEnglishDict.put("ಾ", "aa");
        kannadaEnglishDict.put("ಿ", "i");
        kannadaEnglishDict.put("ೀ", "i");
        kannadaEnglishDict.put("ು", "u");
        kannadaEnglishDict.put("ೂ", "u");
        kannadaEnglishDict.put("ೃ", "rri");
        kannadaEnglishDict.put("ೆ", "e");
        kannadaEnglishDict.put("ೇ", "e");
        kannadaEnglishDict.put("ೈ", "ai");
        kannadaEnglishDict.put("ೊ", "o");
        kannadaEnglishDict.put("ೋ", "o");
        kannadaEnglishDict.put("ೌ", "au");
        kannadaEnglishDict.put("ಕ್ಷ", "ksh");
        kannadaEnglishDict.put("ತ್ರ", "tr");
        kannadaEnglishDict.put("ಜ್ಞ", "jn");
        kannadaEnglishDict.put("೧", "1");
        kannadaEnglishDict.put("೨", "2");
        kannadaEnglishDict.put("೩", "3");
        kannadaEnglishDict.put("೪", "4");
        kannadaEnglishDict.put("೫", "5");
        kannadaEnglishDict.put("೬", "6");
        kannadaEnglishDict.put("೭", "7");
        kannadaEnglishDict.put("೮", "8");
        kannadaEnglishDict.put("೯", "9");
        kannadaEnglishDict.put("೦", "0");
    }

    public static List<Character> knVowels = Arrays.asList('ಅ', 'ಆ', 'ಇ', 'ಈ', 'ಉ', 'ಊ', 'ಋ', 'ಎ', 'ಏ', 'ಐ',
            'ಒ', 'ಓ', 'ಔ');
    public static List<Character> knVowelSigns = Arrays.asList('್', 'ಾ', 'ಿ', 'ೀ', 'ು', 'ೂ', 'ೃ', 'ೆ', 'ೇ',
            'ೈ', 'ೊ', 'ೋ', 'ೌ', 'ಂ', 'ಃ', ' ');


    public static Map<String, String> malayalamEnglishDict = new HashMap<>();

    static {
        malayalamEnglishDict.put("അ", "a");
        malayalamEnglishDict.put("ആ", "aa");
        malayalamEnglishDict.put("ഇ", "i");
        malayalamEnglishDict.put("ഈ", "ee");
        malayalamEnglishDict.put("ഉ", "u");
        malayalamEnglishDict.put("ഊ", "oo");
        malayalamEnglishDict.put("ഋ", "ri");
        malayalamEnglishDict.put("എ", "e");
        malayalamEnglishDict.put("ഏ", "e");
        malayalamEnglishDict.put("ഐ", "ai");
        malayalamEnglishDict.put("ഒ", "o");
        malayalamEnglishDict.put("ഓ", "o");
        malayalamEnglishDict.put("ഔ", "au");
        malayalamEnglishDict.put("ക", "k");
        malayalamEnglishDict.put("ഖ", "kh");
        malayalamEnglishDict.put("ഗ", "g");
        malayalamEnglishDict.put("ഘ", "gh");
        malayalamEnglishDict.put("ങ്ങ", "ng");
        malayalamEnglishDict.put("ങ", "ng");
        malayalamEnglishDict.put("ച", "ch");
        malayalamEnglishDict.put("ഛ", "chh");
        malayalamEnglishDict.put("ജ", "j");
        malayalamEnglishDict.put("ഝ", "jhh");
        malayalamEnglishDict.put("ഞ", "nj");
        malayalamEnglishDict.put("ട", "t");
        malayalamEnglishDict.put("ഠ", "th");
        malayalamEnglishDict.put("ഡ", "d");
        malayalamEnglishDict.put("ഢ", "dh");
        malayalamEnglishDict.put("ണ", "n");
        malayalamEnglishDict.put("ത", "th");
        malayalamEnglishDict.put("ഥ", "th");
        malayalamEnglishDict.put("ദ", "d");
        malayalamEnglishDict.put("ധ", "dh");
        malayalamEnglishDict.put("ന", "n");
        malayalamEnglishDict.put("പ", "p");
        malayalamEnglishDict.put("ഫ", "ph");
        malayalamEnglishDict.put("ബ", "b");
        malayalamEnglishDict.put("ഭ", "bh");
        malayalamEnglishDict.put("മ", "m");
        malayalamEnglishDict.put("യ", "y");
        malayalamEnglishDict.put("ര", "r");
        malayalamEnglishDict.put("ല", "l");
        malayalamEnglishDict.put("വ", "v");
        malayalamEnglishDict.put("റ", "r");
        malayalamEnglishDict.put("ശ", "s");
        malayalamEnglishDict.put("ഷ", "sh");
        malayalamEnglishDict.put("സ", "s");
        malayalamEnglishDict.put("ഹ", "h");
        malayalamEnglishDict.put("ള", "l");
        malayalamEnglishDict.put("ഴ", "zh");
        malayalamEnglishDict.put("്", "");
        malayalamEnglishDict.put("ം", "m");
        malayalamEnglishDict.put("ാ", "aa");
        malayalamEnglishDict.put("ി", "i");
        malayalamEnglishDict.put("ീ", "ee");
        malayalamEnglishDict.put("ു", "u");
        malayalamEnglishDict.put("ൂ", "oo");
        malayalamEnglishDict.put("ൃ", "ri");
        malayalamEnglishDict.put("െ", "e");
        malayalamEnglishDict.put("േ", "e");
        malayalamEnglishDict.put("ൈ", "ai");
        malayalamEnglishDict.put("ൊ", "o");
        malayalamEnglishDict.put("ോ", "oo");
        malayalamEnglishDict.put("ൗ", "au");
        malayalamEnglishDict.put("ൌ", "ou");
    }

    public static List<Character> mlVowels = Arrays.asList('അ', 'ആ', 'ഇ', 'ഈ', 'ഉ', 'ഊ', 'ഋ', 'എ', 'ഏ', 'ഐ',
            'ഒ', 'ഓ', 'ഔ');
    public static List<Character> mlVowelSigns = Arrays.asList('്', 'ം', 'ാ', 'ി', 'ീ', 'ു', 'ൂ', 'ൃ', 'െ', 'േ',
            'ൈ', 'ൊ', 'ോ', 'ൗ', 'ൌ', '‍');

    public static Map<String, String> hindiEnglishDict = new HashMap<>();

    static {
        hindiEnglishDict.put("अ", "a");
        hindiEnglishDict.put("आ", "aa");
        hindiEnglishDict.put("इ", "i");
        hindiEnglishDict.put("ई", "i");
        hindiEnglishDict.put("उ", "u");
        hindiEnglishDict.put("ऊ", "u");
        hindiEnglishDict.put("ऋ", "rri");
        hindiEnglishDict.put("ए", "e");
        hindiEnglishDict.put("ऐ", "ai");
        hindiEnglishDict.put("ओ", "o");
        hindiEnglishDict.put("औ", "au");
        hindiEnglishDict.put("ं", "m");
        hindiEnglishDict.put("ಃ", "h");
        hindiEnglishDict.put("क", "k");
        hindiEnglishDict.put("ख", "kh");
        hindiEnglishDict.put("ग", "g");
        hindiEnglishDict.put("घ", "gh");
        hindiEnglishDict.put("ङ", "ng");
        hindiEnglishDict.put("च", "ch");
        hindiEnglishDict.put("छ", "chh");
        hindiEnglishDict.put("ज", "j");
        hindiEnglishDict.put("झ", "jhh");
        hindiEnglishDict.put("ञ", "nj");
        hindiEnglishDict.put("ट", "th");
        hindiEnglishDict.put("ठ", "thh");
        hindiEnglishDict.put("ड", "d");
        hindiEnglishDict.put("ढ", "dh");
        hindiEnglishDict.put("ण", "n");
        hindiEnglishDict.put("त", "T");
        hindiEnglishDict.put("थ", "Th");
        hindiEnglishDict.put("द", "D");
        hindiEnglishDict.put("ध", "Dh");
        hindiEnglishDict.put("न", "N");
        hindiEnglishDict.put("प", "p");
        hindiEnglishDict.put("फ", "ph");
        hindiEnglishDict.put("ब", "b");
        hindiEnglishDict.put("भ", "bh");
        hindiEnglishDict.put("म", "m");
        hindiEnglishDict.put("य", "y");
        hindiEnglishDict.put("र", "r");
        hindiEnglishDict.put("ल", "l");
        hindiEnglishDict.put("व", "v");
        hindiEnglishDict.put("ष", "sh");
        hindiEnglishDict.put("श", "shh");
        hindiEnglishDict.put("स", "s");
        hindiEnglishDict.put("ह", "h");
        hindiEnglishDict.put("ಳ", "L");
        hindiEnglishDict.put("ृ", "rri");
        hindiEnglishDict.put("ा", "aa");
        hindiEnglishDict.put("ि", "i");
        hindiEnglishDict.put("ी", "i");
        hindiEnglishDict.put("ु", "u");
        hindiEnglishDict.put("ू", "u");
        hindiEnglishDict.put("ृ", "rri");
        hindiEnglishDict.put("े", "e");
        hindiEnglishDict.put("ॆ", "e");
        hindiEnglishDict.put("ै", "ai");
        hindiEnglishDict.put("ो", "o");
        hindiEnglishDict.put("ॊ", "o");
        hindiEnglishDict.put("ौ", "au");
        hindiEnglishDict.put("क्ष", "ksh");
        hindiEnglishDict.put("त्र", "tr");
        hindiEnglishDict.put("ज्ञ", "jn");
        hindiEnglishDict.put("೧", "१");
        hindiEnglishDict.put("२", "2");
        hindiEnglishDict.put("३", "3");
        hindiEnglishDict.put("೪", "4");
        hindiEnglishDict.put("५", "5");
        hindiEnglishDict.put("६", "6");
        hindiEnglishDict.put("७", "7");
        hindiEnglishDict.put("८", "8");
        hindiEnglishDict.put("९", "9");
        hindiEnglishDict.put("०", "0");
    }

    public static List<Character> hiVowels = Arrays.asList('अ', 'आ', 'इ', 'ई', 'उ', 'ऊ', 'ऋ', 'ए',
            'ऐ', 'ओ', 'औ');
    public static List<Character> hiVowelSigns = Arrays.asList(' ', 'ा', 'ि', 'ी', 'ु', 'ू', 'ृ', 'े', 'ॆ',
            'ै', 'ो', 'ॊ', 'ौ', 'ं', 'ಃ');

    // language dictionary mapping
    public static Map<String, Map<String, String>> languageDictionary = new HashMap<>();

    static {
        languageDictionary.put("kn_IN", kannadaEnglishDict);
        languageDictionary.put("ml_IN", malayalamEnglishDict);
        languageDictionary.put("hi_IN", hindiEnglishDict);
    }

    // language vowels mapping
    public static Map<String, List<Character>> languageVowels = new HashMap<>();

    static {
        languageVowels.put("kn_IN", knVowels);
        languageVowels.put("ml_IN", mlVowels);
        languageVowels.put("hi_IN", hiVowels);
    }

    // language vowel signs mapping
    public static Map<String, List<Character>> languageVowelSigns = new HashMap<>();

    static {
        languageVowelSigns.put("kn_IN", knVowelSigns);
        languageVowelSigns.put("ml_IN", mlVowelSigns);
        languageVowelSigns.put("hi_IN", hiVowelSigns);

    }

    // language virama sign mapping
    public static Map<String, Character> languageVirama = new HashMap<>();

    static {
        languageVirama.put("kn_IN", '್');
        languageVirama.put("ml_IN", '്');
        languageVirama.put("hi_IN", '्');

    }

    // language anuswara sign mapping
    public static Map<String, Character> languageAnuswara = new HashMap<>();

    static {
        languageAnuswara.put("kn_IN", 'ಂ');
        languageAnuswara.put("ml_IN", 'ം');
        languageAnuswara.put("hi_IN", 'ं');
    }

    /**
     * Returns the 'language' english-dict. If there
     * is no dictionary available for a language then
     * return ml_IN dictionary
     *
     * @param lang Language for which dictionary is required
     * @return language map
     */
    public static Map<String, String> getDictionaryForLanguage(String lang) {
        if (languageDictionary.get(lang) != null) {
            return languageDictionary.get(lang);
        } else {
            return languageDictionary.get("ml_IN");
        }
    }

    /**
     * Returns the 'lang' vowels list. If vowel list
     * is not available for a language return list for
     * ml_IN
     *
     * @param lang Language for which vowel list should be returned
     * @return list of vowels
     */
    public static List<Character> getVowelsForLanguage(String lang) {
        if (languageVowels.get(lang) != null) {
            return languageVowels.get(lang);
        } else {
            return languageVowels.get("ml_IN");
        }
    }

    /**
     * Returns the 'lang' vowel signs list. If vowel signs list
     * is not available for a language return list for
     * ml_IN
     *
     * @param lang Language for which vowel signs list should be returned
     * @return list of vowel signs
     */
    public static List<Character> getVowelSignsForLanguage(String lang) {
        if (languageVowelSigns.get(lang) != null) {
            return languageVowelSigns.get(lang);
        } else {
            return languageVowelSigns.get("ml_IN");
        }
    }

    /**
     * Return the virama symbol for given language
     *
     * @param lang Language for which virama symbol should be returned
     * @return character
     */
    public static char getViramaForLanguage(String lang) {
        if (languageVirama.get(lang) != null) {
            return languageVirama.get(lang);
        } else {
            return languageVirama.get("ml_IN");
        }
    }

    /**
     * Return the anuswara symbol for the language
     *
     * @param lang Language for which anuswara symbol is needed
     * @return character
     */
    public static char getAnuswaraForLanguage(String lang) {
        if (languageAnuswara.get(lang) != null) {
            return languageAnuswara.get(lang);
        } else {
            return languageAnuswara.get("ml_IN");
        }
    }
}
