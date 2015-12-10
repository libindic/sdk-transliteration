package org.libindic.transliteration;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.libindic.render.IndicEditText;

/**
 * Created by sujith on 9/7/14.
 */
public class TransliteratorEditText extends IndicEditText implements TransliteratorInterface {

    /**
     * Transliterator object
     */
    private Transliterator transliterator;

    /**
     * Target language for transliteration
     */
    private String targetLanguage;

    /**
     * Specified output field from layout
     */
    private int mOutputResourceId;

    /**
     * View specified from layout to output results
     */
    private View mOutputView;

    /**
     * For Transliterated Text
     */
    private String mTransliteratedText;

    private static final String[] langaugeMap = {"en_US", "en_IN", "hi_IN", "bn_IN",
            "pa_IN", "gu_IN", "or_IN", "ta_IN", "te_IN", "kn_IN", "ml_IN"};

    // Log tag
    private static final String LOG_TAG = "TransliteratorEditText";

    public TransliteratorEditText(Context context) {
        super(context);
        init(null, 0);
        initView();
    }

    public TransliteratorEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
        initView();
    }

    public TransliteratorEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
        initView();
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
                R.styleable.TransliteratorEditText,
                defStyle, defStyle
        );

        try {
            this.mOutputResourceId = a.getResourceId(
                    R.styleable.TransliteratorEditText_transliteratedTextOutputTo, -1);
            try {
                targetLanguage = langaugeMap[a.getInteger(R.styleable.TransliteratorEditText_targetLanguage, 0)];
            } catch (Exception e) {
                targetLanguage = langaugeMap[0];
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        } finally {
            a.recycle();
        }
    }

    /**
     * Initialize view function
     */
    private void initView() {
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (mOutputView == null && mOutputResourceId != -1) {
                    mOutputView = getRootView().findViewById(mOutputResourceId);
                }

                String enteredText = getText().toString();
                if (enteredText == null) {
                    return;
                }
                int len = enteredText.length();
                if (len == 0 || enteredText.charAt(len - 1) != ' ') {
                    return;
                }
                if (mOutputView != null) {
                    mTransliteratedText = transliterator.transliterate(enteredText, targetLanguage) + " ";

                    if (mOutputResourceId == getId()) {
                        removeTextChangedListener(this);
                        setText(mTransliteratedText);
                        setSelection(getText().length());
                        addTextChangedListener(this);
                    } else {
                        if (mOutputView instanceof EditText) {
                            ((EditText) mOutputView).setText(mTransliteratedText);
                        } else if (mOutputView instanceof TextView) {
                            ((TextView) mOutputView).setText(mTransliteratedText);
                        }
                    }
                }

            }
        });
    }

    /**
     * Explicitly set output field
     *
     * @param resourceId resource id of output field
     */
    public void setOutputField(int resourceId) {
        this.mOutputResourceId = resourceId;
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
        return mTransliteratedText;
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
