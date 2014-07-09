package org.silpa.transliteration;

/**
 * Created by sujith on 9/7/14.
 */
public interface TransliteratorInterface {

    /**
     * This function returns transliterated text of contents of view
     *
     * @return string transliterated text
     */
    public String getTransliteratedText();

    /**
     * This function returns module name
     *
     * @return module name
     */
    public String getModuleName();

    /**
     * This function returns module information
     *
     * @return module information
     */
    public String getModuleInformation();
}
