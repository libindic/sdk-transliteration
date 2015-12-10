package org.libindic.transliteration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujith on 2/7/14.
 */
public class CMUMapping {
    protected static Map<String, String> CMU_MALAYALAM_MAP;
    protected static Map<String, String> CMU_KANNADA_MAP;
    protected static Map<String, String> CMU_HINDI_MAP;

    static {
        CMU_MALAYALAM_MAP = new HashMap<String, String>();
        CMU_MALAYALAM_MAP.put("AA", "ഓ");
        CMU_MALAYALAM_MAP.put("AH", "അ");
        CMU_MALAYALAM_MAP.put("AE", "ഏ");
        CMU_MALAYALAM_MAP.put("AO", "ഓ");
        CMU_MALAYALAM_MAP.put("AW", "ഔ");
        CMU_MALAYALAM_MAP.put("AY", "ഐ");
        CMU_MALAYALAM_MAP.put("B", "ബ്");
        CMU_MALAYALAM_MAP.put("CH", "ച്ച്");
        CMU_MALAYALAM_MAP.put("D", "ഡ്");
        CMU_MALAYALAM_MAP.put("DH", "ദ്");
        CMU_MALAYALAM_MAP.put("EA", "ഈ");
        CMU_MALAYALAM_MAP.put("EH", "എ");
        CMU_MALAYALAM_MAP.put("ER", "എര്‍");
        CMU_MALAYALAM_MAP.put("EY", "എയ്");
        CMU_MALAYALAM_MAP.put("F", "ഫ്");
        CMU_MALAYALAM_MAP.put("G", "ഗ്");
        CMU_MALAYALAM_MAP.put("HH", "ഹ്");
        CMU_MALAYALAM_MAP.put("IH", "ഇ");
        CMU_MALAYALAM_MAP.put("IY", "ഈ");
        CMU_MALAYALAM_MAP.put("J", "ജ്");
        CMU_MALAYALAM_MAP.put("JH", "ജ്");
        CMU_MALAYALAM_MAP.put("K", "ക്");
        CMU_MALAYALAM_MAP.put("L", "ല്‍");
        CMU_MALAYALAM_MAP.put("M", "മ്");
        CMU_MALAYALAM_MAP.put("N", "ന്‍");
        CMU_MALAYALAM_MAP.put("NG", "ങ്");
        CMU_MALAYALAM_MAP.put("OW", "ഒ");
        CMU_MALAYALAM_MAP.put("P", "പ്");
        CMU_MALAYALAM_MAP.put("R", "ര്‍");
        CMU_MALAYALAM_MAP.put("S", "സ്");
        CMU_MALAYALAM_MAP.put("SH", "ഷ്");
        CMU_MALAYALAM_MAP.put("T", "റ്റ്");
        CMU_MALAYALAM_MAP.put("TH", "ത്");
        CMU_MALAYALAM_MAP.put("Y", "യ്");
        CMU_MALAYALAM_MAP.put("UW", "ഉ");
        CMU_MALAYALAM_MAP.put("W", "വ്");
        CMU_MALAYALAM_MAP.put("V", "വ്");
        CMU_MALAYALAM_MAP.put("Z", "സ്");
    }

    static {
        CMU_KANNADA_MAP = new HashMap<String, String>();
        CMU_KANNADA_MAP.put("AA", "ಆ");
        CMU_KANNADA_MAP.put("AH", "ಅ");
        CMU_KANNADA_MAP.put("AE", "ಏ");
        CMU_KANNADA_MAP.put("AO", "ಓ");
        CMU_KANNADA_MAP.put("AW", "ಔ");
        CMU_KANNADA_MAP.put("AY", "ಐ");
        CMU_KANNADA_MAP.put("B", "ಬ್");
        CMU_KANNADA_MAP.put("CH", "ಚ್");
        CMU_KANNADA_MAP.put("D", "ಡ್");
        CMU_KANNADA_MAP.put("DH", "ದ್");
        CMU_KANNADA_MAP.put("EA", "ಈ");
        CMU_KANNADA_MAP.put("EH", "ಎ");
        CMU_KANNADA_MAP.put("ER", "ಅರ್");
        CMU_KANNADA_MAP.put("EY", "ಎಯ್");
        CMU_KANNADA_MAP.put("F", "ಫ್");
        CMU_KANNADA_MAP.put("G", "ಗ್");
        CMU_KANNADA_MAP.put("HH", "ಹ್");
        CMU_KANNADA_MAP.put("IH", "ಇ");
        CMU_KANNADA_MAP.put("IY", "ಈ");
        CMU_KANNADA_MAP.put("J", "ಜ್");
        CMU_KANNADA_MAP.put("JH", "ಜ್");
        CMU_KANNADA_MAP.put("K", "ಕ್");
        CMU_KANNADA_MAP.put("L", "ಲ್");
        CMU_KANNADA_MAP.put("M", "ಮ್");
        CMU_KANNADA_MAP.put("N", "ನ್");
        CMU_KANNADA_MAP.put("NG", "ಂಗ್");
        CMU_KANNADA_MAP.put("OW", "ಒ");
        CMU_KANNADA_MAP.put("P", "ಪ್");
        CMU_KANNADA_MAP.put("R", "ರ್");
        CMU_KANNADA_MAP.put("S", "ಸ್");
        CMU_KANNADA_MAP.put("SH", "ಷ್");
        CMU_KANNADA_MAP.put("T", "ಟ್");
        CMU_KANNADA_MAP.put("TH", "ತ್");
        CMU_KANNADA_MAP.put("Y", "ಯ್");
        CMU_KANNADA_MAP.put("UW", "ಊ");
        CMU_KANNADA_MAP.put("UH", "ಉ");
        CMU_KANNADA_MAP.put("W", "ವ್");
        CMU_KANNADA_MAP.put("V", "ವ್");
        CMU_KANNADA_MAP.put("Z", "ಸ್");
        CMU_KANNADA_MAP.put("ZH", "ಷ್");
    }

    static {
        CMU_HINDI_MAP = new HashMap<String, String>();
        CMU_HINDI_MAP.put("AA", "आ");
        CMU_HINDI_MAP.put("AH", "अ");
        CMU_HINDI_MAP.put("AE", "ए");
        CMU_HINDI_MAP.put("AO", "औ");
        CMU_HINDI_MAP.put("AW", "औ");
        CMU_HINDI_MAP.put("AY", "ऐ");
        CMU_HINDI_MAP.put("B", "ब");
        CMU_HINDI_MAP.put("CH", "च");
        CMU_HINDI_MAP.put("D", "ड");
        CMU_HINDI_MAP.put("DH", "द");
        CMU_HINDI_MAP.put("EA", "ई");
        CMU_HINDI_MAP.put("EH", "ऐ");
        CMU_HINDI_MAP.put("ER", "अर");
        CMU_HINDI_MAP.put("EY", "एय");
        CMU_HINDI_MAP.put("F", "फ");
        CMU_HINDI_MAP.put("G", "ग");
        CMU_HINDI_MAP.put("HH", "ह");
        CMU_HINDI_MAP.put("IH", "इ");
        CMU_HINDI_MAP.put("IY", "ई");
        CMU_HINDI_MAP.put("J", "ज");
        CMU_HINDI_MAP.put("JH", "झ");
        CMU_HINDI_MAP.put("K", "क");
        CMU_HINDI_MAP.put("L", "ल");
        CMU_HINDI_MAP.put("M", "म");
        CMU_HINDI_MAP.put("N", "न");
        CMU_HINDI_MAP.put("NG", "ङ");
        CMU_HINDI_MAP.put("OW", "ओ");
        CMU_HINDI_MAP.put("P", "प");
        CMU_HINDI_MAP.put("R", "र");
        CMU_HINDI_MAP.put("S", "स");
        CMU_HINDI_MAP.put("SH", "ष");
        CMU_HINDI_MAP.put("T", "ट");
        CMU_HINDI_MAP.put("TH", "त");
        CMU_HINDI_MAP.put("Y", "य");
        CMU_HINDI_MAP.put("UW", "ऊ");
        CMU_HINDI_MAP.put("UH", "उ");
        CMU_HINDI_MAP.put("W", "व");
        CMU_HINDI_MAP.put("V", "भ");
        CMU_HINDI_MAP.put("Z", "ज़");
        CMU_HINDI_MAP.put("ZH", "श");
    }
}
