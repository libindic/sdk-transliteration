package org.silpa.transliteration;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by sujith on 5/7/14.
 */
public class CMUDict {

    /**
     * Context
     */
    private Context mContext;

    /**
     * local cmu dictionary
     */
    private Map<String, List<String>> cmudictionary;

    // Log tag
    private static final String LOG_TAG = "CMUDict";

    /**
     * Constructor
     * @param context context
     */
    public CMUDict(Context context) {
        this.mContext = context;
        load();
    }

    /**
     * Load values into map
     */
    public void load() {
        this.cmudictionary = new HashMap<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(this.mContext.getResources().
                    openRawResource(R.raw.silpa_sdk_cmudict_0_7a_sphinx_40)));

            String line = br.readLine();
            while (line != null) {
                line = line.trim();
                List<String> lst = new LinkedList<String>(Arrays.asList(line.split("[ \t]")));
                String lhs = lst.get(0);
                lst.remove(0);
                this.cmudictionary.put(lhs, lst);
                line = br.readLine();
            }
            br.close();
        } catch (IOException ioe) {
            Log.e(LOG_TAG, "Error : " + ioe.getMessage());
        }
    }

    public List<String> find(String word) {
        if (this.cmudictionary == null) {
            load();
        }
        return this.cmudictionary.get(word.toUpperCase(Locale.getDefault()));
    }

    /**
     * Function to get pronunciation string
     * @param word word
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
            }
            pronunciationStr = fixVowelSignsHi(pronunciationStr);
        }
        try {
            return (new String((pronunciationStr.getBytes("UTF-8")), "UTF-8")) + punctuations;
        } catch (UnsupportedEncodingException uee) {
            return pronunciationStr + punctuations;
        }
    }

    /**
     * Fix vowel signs Malayalam
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
