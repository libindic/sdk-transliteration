package org.silpa.transliteration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by sujith on 5/7/14.
 */
public class CMUDict {

    /**
     * Context of application
     */
    private Context mContext;

    /**
     * CMU Database
     */
    private SQLiteDatabase cmuDB;

    // Log tag
    private static final String LOG_TAG = "CMUDict";

    /**
     * Constructor
     *
     * @param context context
     */
    public CMUDict(Context context) {
        this.mContext = context;
        loadDB();
    }

    /**
     * Load database
     */
    private void loadDB() {
        CMUDictSQLiteHelper.copyDatabase(this.mContext);
        this.cmuDB = CMUDictSQLiteHelper.getCMUDatabase(this.mContext);
    }

    public List<String> find(String word) {
        if (this.cmuDB != null) {
            String phonemes = CMUDictSQLiteHelper.getCMUDictionaryEntry(this.cmuDB,
                    (word.toUpperCase(Locale.getDefault())))
                    .getPhonemes();
            return Arrays.asList(phonemes.split("[ \t]"));
        }
        return null;
    }

    /**
     * Function to get pronunciation string
     *
     * @param word     word
     * @param language language of word
     * @return string
     */
    public String pronunciation(String word, String language) {
        // equivalent of pythons .strip()
        String strippedWord = word.replaceAll("^[!,.?:]+", "").replaceAll("[!,.?:]+$", "");
        String punctuations = word.substring(strippedWord.length());

        List<String> cmuPronunciation = null;
        try {
            cmuPronunciation = find(strippedWord);
        } catch (Exception e) {
            // could not find word
            return word;
        }
        String pronunciationStr = "";
        if (language.equals("ml_IN")) {
            for (String syl : cmuPronunciation) {
                String value = CMUMapping.CMU_MALAYALAM_MAP.get(syl);
                if (value != null) {
                    pronunciationStr = pronunciationStr + value;
                } else {
                    // no key found
                    pronunciationStr = pronunciationStr + syl;
                }
            }
            pronunciationStr = fixVowelSignsMl(pronunciationStr);
        } else if (language.equals("kn_IN")) {
            for (String symbol : cmuPronunciation) {
                String value = CMUMapping.CMU_KANNADA_MAP.get(symbol);
                if (value != null) {
                    pronunciationStr = pronunciationStr + value;
                } else {
                    // no key found
                    pronunciationStr = pronunciationStr + symbol;
                }
            }
            pronunciationStr = fixVowelSignsKn(pronunciationStr);
        } else if (language.equals("hi_IN")) {
            for (String symbol : cmuPronunciation) {
                String value = CMUMapping.CMU_HINDI_MAP.get(symbol);
                if (value != null) {
                    pronunciationStr = pronunciationStr + value;
                } else {
                    // no key found
                    pronunciationStr = pronunciationStr + symbol;
                }
                pronunciationStr = fixVowelSignsHi(pronunciationStr);
            }
        }
        try {
            return (new String((pronunciationStr.getBytes("UTF-8")), "UTF-8")) + punctuations;
        } catch (UnsupportedEncodingException uee) {
            return pronunciationStr + punctuations;
        }
    }

    /**
     * Fix vowel signs Malayalam
     *
     * @param text text
     * @return string
     */
    private String fixVowelSignsMl(String text) {
        text = text.replaceAll("്അ", "");
        text = text.replaceAll("്‍അ", "");
        text = text.replaceAll("്ആ", "ാ");
        text = text.replaceAll("്‍ആ", "ാ");
        text = text.replaceAll("്ഇ", "ി");
        text = text.replaceAll("്‍ഇ", "ി");
        text = text.replaceAll("്ഈ", "ീ");
        text = text.replaceAll("്‍ഈ", "ീ");
        text = text.replaceAll("്ഉ", "ു");
        text = text.replaceAll("്‍ഉ", "ു");
        text = text.replaceAll("്ഊ", "ൂ");
        text = text.replaceAll("്‍ഊ", "ൂ");
        text = text.replaceAll("്റ", "്ര");
        text = text.replaceAll("്എ", "െ");
        text = text.replaceAll("്‍എ", "");
        text = text.replaceAll("്ഏ", "േ");
        text = text.replaceAll("്‍ഏ", "േ");
        text = text.replaceAll("്ഐ", "ൈ");
        text = text.replaceAll("്‍ഐ", "ൈ");
        text = text.replaceAll("്ഒ", "ൊ");
        text = text.replaceAll("്‍ഒ", "ൊ");
        text = text.replaceAll("്ഓ", "ോ");
        text = text.replaceAll("്‍ഓ", "ോ");
        text = text.replaceAll("്ഔ", "ൌ");
        text = text.replaceAll("്‍ഔ", "ൌ");
        text = text.replaceAll("ര്ര", "റ്റ");
        text = text.replaceAll("റ്ര", "റ്റ");
        text = text.replaceAll("ന്‍റ്റ", "ന്റ");
        return text;
    }

    /**
     * Fix vowel signs Kannada
     *
     * @param text text
     * @return string
     */
    private String fixVowelSignsKn(String text) {
        text = text.replaceAll("್ಅ", "");
        text = text.replaceAll("್ಆ", "ಾ");
        text = text.replaceAll("್ಇ", "ಿ");
        text = text.replaceAll("್ಈ", "ೀ");
        text = text.replaceAll("್ಉ", "ು");
        text = text.replaceAll("್ಊ", "ೂ");
        text = text.replaceAll("್ಋ", "ೃ");
        text = text.replaceAll("್ಎ", "ೆ");
        text = text.replaceAll("್ಏ", "ೇ");
        text = text.replaceAll("್ಐ", "ೈ");
        text = text.replaceAll("್ಒ", "ೊ");
        text = text.replaceAll("್ಓ", "ೋ");
        text = text.replaceAll("್ಔ", "ೌ");
        return text;
    }

    /**
     * Fix vowel signs Hindi
     *
     * @param text text
     * @return string
     */
    private String fixVowelSignsHi(String text) {
        text = text.replaceAll("अ", "");
        text = text.replaceAll("आ", "ा");
        text = text.replaceAll("इ", "ि");
        text = text.replaceAll("ई", "ी");
        text = text.replaceAll("उ", "ु");
        text = text.replaceAll("ऊ", "ू");
        text = text.replaceAll("ऋ", "ृ");
        text = text.replaceAll("ए", "े");
        text = text.replaceAll("ऐ", "ै");
        text = text.replaceAll("ओ", "ो");
        text = text.replaceAll("औ", "ौ");
        text = text.replaceAll("ङ", "न्");
        return text;
    }
}
