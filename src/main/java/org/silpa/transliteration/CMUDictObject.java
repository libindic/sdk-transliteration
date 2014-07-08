package org.silpa.transliteration;

/**
 * Created by sujith on 8/7/14.
 */
public class CMUDictObject implements Comparable<CMUDictObject> {
    String word;
    String phonemes;

    public CMUDictObject(String word, String phonemes) {
        this.word = word;
        this.phonemes = phonemes;
    }

    @Override
    public int compareTo(CMUDictObject dictionaryObject) {
        return this.word.compareTo(dictionaryObject.word);
    }
}
