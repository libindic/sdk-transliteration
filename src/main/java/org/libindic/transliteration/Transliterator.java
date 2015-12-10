package org.libindic.transliteration;

import android.content.Context;

import org.libindic.common.CharacterMap;
import org.libindic.common.LanguageDetect;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.libindic.transliteration.IndicUtils.PUNCTUATIONS;
import static org.libindic.transliteration.IndicUtils.getAnuswaraForLanguage;
import static org.libindic.transliteration.IndicUtils.getViramaForLanguage;
import static org.libindic.transliteration.IndicUtils.getVowelSignsForLanguage;
import static org.libindic.transliteration.IndicUtils.getVowelsForLanguage;
import static org.libindic.transliteration.IndicUtils.languageDictionary;

/**
 * Created by sujith on 6/7/14.
 */
public class Transliterator {


    private CMUDict cmu;

    public static Map<String, Integer> langBases = new HashMap<>();

    static {
        langBases.put("en_US", 0);
        langBases.put("en_IN", 0);
        langBases.put("hi_IN", 0x0901);
        langBases.put("bn_IN", 0x0981);
        langBases.put("pa_IN", 0x0A01);
        langBases.put("gu_IN", 0x0A81);
        langBases.put("or_IN", 0x0B01);
        langBases.put("ta_IN", 0x0B81);
        langBases.put("te_IN", 0x0C01);
        langBases.put("kn_IN", 0x0C81);
        langBases.put("ml_IN", 0x0D01);
    }

    /**
     * Constructor
     *
     * @param context context of application
     */
    public Transliterator(Context context) {
        this.cmu = new CMUDict(context);
    }

    /**
     * Transliterate English to Malayalam with the help of
     * CMU pronuciation dictionary
     *
     * @param word The word to be transliterated
     * @return the translated word.
     */
    public String transliterateEnglishToMalayalam(String word) {
        return this.cmu.pronunciation(word, "ml_IN");
    }

    /**
     * Transliterate English to Kannada with the help of
     * CMU pronuciation dictionary
     *
     * @param word The word to be transliterated
     * @return the translated word.
     */
    public String transliterateEnglishToKannada(String word) {
        return this.cmu.pronunciation(word, "kn_IN");
    }

    /**
     * Transliterate English to Hindi with the help of
     * CMU pronuciation dictionary
     *
     * @param word The word to be transliterated
     * @return the translated word.
     */
    public String transliterateEnglishToHindi(String word) {
        return this.cmu.pronunciation(word, "hi_IN");
    }

    /**
     * Transliterate English to any Indian Language.
     *
     * @param word           The word to be transliterated.
     * @param targetLanguage The language into which word has to be transliterated.
     * @return the translated word.
     */
    private String transliterateEnglishToXX(String word, String targetLanguage) {
        if (word == null || word.length() == 0) {
            return "";
        }

        String txStr = null;
        if (targetLanguage.equals("en_IN") || targetLanguage.equals("en_US")) {
            return word;
        } else if (targetLanguage.equals("kn_IN")) {
            return transliterateEnglishToKannada(word);
        } else if (targetLanguage.equals("hi_IN")) {
            return transliterateEnglishToHindi(word);
        } else {
            txStr = transliterateEnglishToMalayalam(word);
        }

        if (targetLanguage.equals("ml_IN")) {
            return txStr;
        }

        if (txStr.charAt(txStr.length() - 1) == '്' && (targetLanguage.equals("hi_IN")
                || targetLanguage.equals("gu_IN") || targetLanguage.equals("bn_IN"))) {
            txStr = txStr.substring(0, txStr.length() - 1);
        }

        return transliterateIndicToIndic(txStr, "ml_IN", targetLanguage);
    }

    /**
     * Transliterate Indian Language to English.
     *
     * @param word        The word to be transliterated.
     * @param srcLanguage The language of the word.
     * @return the translated word.
     */
    private String transliterateXXToEnglish(String word, String srcLanguage) {
        if (srcLanguage.equals("en_IN") || srcLanguage.equals("en_US")) {
            return word;
        }
        // TODO: the function is generic now so no need of testing the lanuguage
        // but since the indic_en contains only for kn_IN and ml_IN we need this
        // check.
        // Add all indic language to indic_en
        // remplace this block with single call to indic_en function

        if (srcLanguage.equals("kn_IN")) {
            return transliterateIndicToEnglish(word, srcLanguage);
        }
        if (!(srcLanguage.equals("ml_IN"))) {
            word = transliterateIndicToIndic(word, srcLanguage, "ml_IN");
        }
        return transliterateIndicToEnglish(word, "ml_IN");
    }

    /**
     * Transliterate the given word in src_language to
     * ISO15919
     *
     * @param word        The word to be transliterated.
     * @param srcLanguage The language of the word.
     * @return the translated word.
     */
    private String transliterateISO15919(String word, String srcLanguage) {

        String txStr = "";
        int index = 0;
        int wordLength = word.length();

        for (char chr : word.toCharArray()) {
            index += 1;
            int offset = chr - langBases.get(srcLanguage);
            if (offset >= 61 && offset <= 76) {
                txStr = txStr.substring(0, txStr.length() - 1);
            }
            if (offset > 0 && offset <= 128) {
                txStr = txStr + CharacterMap.charmapTransphon.get("ISO15919").get(offset);
            }

            if (txStr.charAt(txStr.length() - 1) == 'a' && (srcLanguage.equals("hi_IN") ||
                    srcLanguage.equals("gu_IN") || srcLanguage.equals("bn_IN"))) {
                if (wordLength == index && wordLength > 1) {
                    txStr = txStr.substring(0, txStr.length() - 1);
                }
            }
        }
        try {
            return new String(txStr.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            return txStr;
        }
    }

    /**
     * Transliterate the given word in src_language to
     * IPA - International Phonetical Alphabet notation.
     *
     * @param word        The word to be transliterated.
     * @param srcLanguage The language of the word.
     * @return the translated word.
     */
    private String transliterateIPA(String word, String srcLanguage) {
        String txStr = "";
        int index = 0;
        int wordLength = word.length();

        for (char chr : word.toCharArray()) {
            index += 1;
            if (chr < 255) {
                txStr += chr;
                continue;
            }
            int offset = chr - langBases.get(srcLanguage);
            if (offset >= 61 && offset <= 76) {
                txStr = txStr.substring(0, txStr.length() - 1);
            }
            if (offset > 0 && offset <= 128) {
                txStr = txStr + CharacterMap.charmapTransphon.get("IPA").get(offset);
            }

            if (txStr.charAt(txStr.length() - 1) == 'ə' && (srcLanguage.equals("hi_IN")
                    || srcLanguage.equals("gu_IN") || srcLanguage.equals("bn_IN"))
                    && wordLength == index && wordLength > 1) {
                txStr = txStr.substring(0, txStr.length() - 1);
            }
        }
        try {
            return new String(txStr.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            return txStr;
        }
    }

    private String malayalamFixes(String text) {
        try {
            text = text.replaceAll("മ് ", "ം ");
            text = text.replaceAll("മ്,", "ം,");
            text = text.replaceAll("മ്.", "ം.");
            text = text.replaceAll("മ്", "ം");
            text = text.replaceAll("ഩ", "ന");
            text = text.replaceAll("൤", ".");  // danda by fullstop
        } catch (Exception e) {

        }
        return text;
    }

    /**
     * Transliterate from an Indian language word
     * to another indian language word
     *
     * @param word           The word to be transliterated.
     * @param srcLanguage    The language of the word.
     * @param targetLanguage The language into which word has to be transliterated.
     * @return the translated word.
     */
    private String transliterateIndicToIndic(String word, String srcLanguage, String targetLanguage) {
        int index = 0;
        String txStr = "";
        // TODO normalize
        try {
            word = new String(word.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException uee) {

        }

        if (srcLanguage.equals("ml_IN") && !targetLanguage.equals("ml_IN")) {
            word = word.replaceAll("\u200C", "");
            word = word.replaceAll("\u200D", "");
            // replace all samvruthokaram by u vowels
            word = word.replaceAll("ു്", "");
        }

        for (char chr : word.toCharArray()) {
            index += 1;
            if (PUNCTUATIONS.contains(chr + "") || (chr <= 2304 && chr >= 3071)) {
                txStr = txStr + chr;
                continue;
            }
            int offset = chr + getOffset(srcLanguage, targetLanguage);
            if (offset > 0) {
                txStr = txStr + (char) offset;
            }
            // schwa deletion
            int baseoffset = offset - langBases.get(targetLanguage);
            if (index == word.length() && baseoffset == 76 && (targetLanguage.equals("hi_IN")
                    || targetLanguage.equals("gu_IN")
                    || targetLanguage.equals("pa_IN")
                    || targetLanguage.equals("bn_IN"))) {
                txStr = txStr.substring(0, txStr.length() - 1);
            }
            if (targetLanguage.equals("ml_IN") && srcLanguage.equals("ta_IN")) {
                txStr = txStr.replaceAll("ഩ", "ന");
            }
            if (targetLanguage.equals("ta_IN")) {
                txStr = txStr.replaceAll("\u0B96", "க");
                txStr = txStr.replaceAll("\u0B97", "க");
                txStr = txStr.replaceAll("\u0B98", "க");
                txStr = txStr.replaceAll("\u0B9B", "ச");
                txStr = txStr.replaceAll("\u0B9D", "ச");
                txStr = txStr.replaceAll("\u0BA0", "ட");
                txStr = txStr.replaceAll("\u0BA1", "ட");
                txStr = txStr.replaceAll("\u0BA2", "ட");
                txStr = txStr.replaceAll("\u0BA5", "த");
                txStr = txStr.replaceAll("\u0BA6", "த");
                txStr = txStr.replaceAll("\u0BA7", "த");
                txStr = txStr.replaceAll("\u0BAB", "ப");
                txStr = txStr.replaceAll("\u0BAC", "ப");
                txStr = txStr.replaceAll("\u0BAD", "ப");
                txStr = txStr.replaceAll("\u0BC3", "ிரு");
                txStr = txStr.replaceAll("ஂ", "ம்");
            }
        }
        if ((targetLanguage.equals("ml_IN")) &&
                (srcLanguage.equals("hi_IN")
                        || srcLanguage.equals("gu_IN")
                        || srcLanguage.equals("pa_IN")
                        || srcLanguage.equals("bn_IN") && Character.isLetter(txStr.charAt(txStr.length() - 1)))) {
            txStr = txStr + "്";
        }

        return txStr;
    }

    /**
     * Transliterate from Indic language to English
     *
     * @param text        Word to be transliterated (sentence)
     * @param srcLanguage Language from which we need to transilterate
     * @return transliterated string
     */
    private String transliterateIndicToEnglish(String text, String srcLanguage) {
        char[] word = text.toCharArray();

        Map<String, String> dictionary = languageDictionary.get(srcLanguage);
        List<Character> vowels = getVowelsForLanguage(srcLanguage);
        List<Character> vowelSigns = getVowelSignsForLanguage(srcLanguage);
        char virama = getViramaForLanguage(srcLanguage);
        char anuswara = getAnuswaraForLanguage(srcLanguage);

        int wordLength = word.length;
        int index = 0;
        String txString = "";

        while (index < wordLength) {
            // If current charachter is a punctuation symbol
            // skip it.
            // Added to avoid getting extra 'a' to the begining
            // of word next to punctuation symbol

            if (PUNCTUATIONS.contains(word[index] + "")) {
                txString += word[index];
                index += 1;
                continue;
            }

            // Virama = conjucter
            if (word[index] == virama) {
                index += 1;
                continue;
            }

            String value = dictionary.get(word[index] + "");
            if (value != null) {
                txString += value;
            } else {
                txString += word[index];
            }

            if (index + 1 < wordLength && !vowelSigns.contains(word[index + 1])
                    && dictionary.containsKey(word[index + 1] + "")
                    && !vowels.contains(word[index])
                    && !vowelSigns.contains(word[index])) {
                txString += 'a';
            }
            if (index + 1 == wordLength && !vowelSigns.contains(word[index])
                    && dictionary.containsKey(word[index] + "")) {
                txString += 'a';
            }

            // handle am sign
            if (index + 1 < wordLength && word[index + 1] == anuswara
                    && !vowelSigns.contains(word[index])) {
                txString += 'a';
            }

            index += 1;
        }
        return txString;
    }

    /**
     * The transliteration functioon which can transliterate text to the
     * supported target languages.
     *
     * @param text           The text to be transliterated.
     * @param targetLanguage The language into which word has to be transliterated.
     * @return the translated text.
     */
    public String transliterate(String text, String targetLanguage) {
        String txStr = "";
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word != null && word.trim().length() > 0) {
                    String srcLanguage = LanguageDetect.detectLanguage(word).get(word);
                    if (srcLanguage == null) {
                        txStr = txStr + " " + word;
                        continue;
                    }

                    if (srcLanguage.equals("en_US")) {
                        txStr = txStr + transliterateEnglishToXX(word, targetLanguage) + " ";
                        continue;
                    }

                    switch (targetLanguage) {
                        case "ISO15919":
                            txStr = txStr + transliterateISO15919(word, srcLanguage) + " ";
                            break;

                        case "IPA":
                            txStr = txStr + transliterateIPA(word, srcLanguage) + " ";
                            break;

                        case "en_US":
                        case "en_IN":
                            txStr = txStr + transliterateXXToEnglish(word, srcLanguage) + " ";
                            break;

                        default:
                            txStr = txStr + transliterateIndicToIndic(word, srcLanguage,
                                    targetLanguage) + " ";
                            break;
                    }
                } else {
                    txStr = txStr + word;
                }
            }
            if (lines.length > 1) {
                txStr = txStr + "\n";
            }
        }

        if (targetLanguage.equals("ml_IN")) {
            txStr = malayalamFixes(txStr);
        }

        return txStr.trim();
    }

    private int getOffset(String srcLanguage, String targetLanguage) {
        int srcId = 0;
        int targetId = 0;
        try {
            srcId = langBases.get(srcLanguage);
            targetId = langBases.get(targetLanguage);
            return targetId - srcId;
        } catch (Exception e) {
            return 0;
        }
    }

    public static final String MODULE_NAME = "Transliterator";
    public static final String MODULE_INFORMATION = "Transliterate the text between " +
            "any Indian Language";

    /**
     * This function returns module name
     *
     * @return string module name
     */
    public String getModuleName() {
        return Transliterator.MODULE_NAME;
    }

    /**
     * This function returns brief information of module
     *
     * @return string module information
     */
    public String getModuleInformation() {
        return Transliterator.MODULE_INFORMATION;
    }
}
