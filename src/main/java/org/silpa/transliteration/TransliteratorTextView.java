package org.silpa.transliteration;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;

import org.silpa.render.IndicTextView;

/**
 * Created by sujith on 10/7/14.
 */
public class TransliteratorTextView extends IndicTextView implements TransliteratorInterface {
    /**
     * Transliterator object
     */
    private Transliterator transliterator;

    /**
     * Target language for transliteration
     */
    private String targetLanguage;

    private static final String[] langaugeMap = {"en_US", "en_IN", "hi_IN", "bn_IN",
            "pa_IN", "gu_IN", "or_IN", "ta_IN", "te_IN", "kn_IN", "ml_IN"};

    // Log tag
    private static final String LOG_TAG = "TransliteratorTextView";

    public TransliteratorTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public TransliteratorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TransliteratorTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    /**
     * Initialize data members
     *
     * @param attrs    attribute set
     * @param defStyle default style
     */
    private void init(AttributeSet attrs, int defStyle) {

        this.transliterator = new Transliterator(getContext());
        initAttrs(attrs, defStyle);
    }

    /**
     * Initialize attributes used
     *
     * @param attrs    attribute set
     * @param defStyle default style
     */
    private void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TransliteratorTextView,
                defStyle, defStyle
        );

        try {
            targetLanguage = langaugeMap[a.getInteger(R.styleable.TransliteratorTextView_targetLanguage, 0)];
        } catch (Exception e) {
            targetLanguage = langaugeMap[0];
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        } finally {
            a.recycle();
        }
    }

    /**
     * This function is used to set target langauge
     *
     * @param targetLangauge language code
     */
    @Override
    public void setTargetLanguage(String targetLangauge) {
        this.targetLanguage = targetLangauge;
    }

    /**
     * This function is used to get target langauge
     */
    @Override
    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    /**
     * This function returns transliterated text of contents of view
     *
     * @return string transliterated text
     */
    @Override
    public String getTransliteratedText() {
        if (transliterator != null) {
            return transliterator.transliterate(getText().toString(), targetLanguage);
        }
        return "";
    }

    /**
     * This function returns module name
     *
     * @return module name
     */
    @Override
    public String getModuleName() {
        return this.transliterator.getModuleName();
    }

    /**
     * This function returns module information
     *
     * @return module information
     */
    @Override
    public String getModuleInformation() {
        return this.transliterator.getModuleInformation();
    }
}
