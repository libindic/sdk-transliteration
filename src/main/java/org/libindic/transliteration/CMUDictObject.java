package org.libindic.transliteration;

/**
 * Created by sujith on 8/7/14.
 */
public class CMUDictObject implements Comparable<CMUDictObject> {
    private String word;
    private String phonemes;

    public CMUDictObject(String word, String phonemes) {
        this.word = word;
        this.phonemes = phonemes;
    }

    public String getWord() {
        return this.word;
    }

    public String getPhonemes() {
        return this.phonemes;
    }

    @Override
    public int compareTo(CMUDictObject dictionaryObject) {
        return this.word.compareTo(dictionaryObject.word);
    }
}
