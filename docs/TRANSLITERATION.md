Usage
=====

### Note :
This module is still under development and this document presently shows only currently available utilities.

#### Creating object
```
        Transliterator transliterator = new Transliterator(getContext());
```
The code demonstrates on how to create a Transliterator object. 

#### Get Transliterated text
```
        Transliterator transliterator = new Transliterator(getContext());
        String text = transliterator.transliterate("ನಮಸ್ಕಾರ ಇದು ಕನ್ನಡ ಪಠ್ಯ ಟ್ರಾನ್ಸ್ಲಿಟರೇಷನ್ ಪರೀಕ್ಷೆಗಾಗಿ", "en_US");
        
// Sample output:  text -> "namaskaara idu kannaDa paThya TraansliTareshhan parikshhegaagi"
```

The above function accepts text in any language and transliterates to a given language.


#### Get module name and information
```
        String moduleName = obj.getModuleName();
        String moduleInforamtion =  obj.getModuleInformation();
```

#### TransliteratorEditText

```

        <org.silpa.transliteration.TransliteratorEditText
                android:id="@+id/edtTransliterator"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                transliterator:targetLanguage="english_US"
                transliterator:transliteratedTextOutputTo="@+id/edtId" />

```

Here  `transliterator:targetLanguage="english_US"` is used to set target language for transliteration, default being english_US.
and `transliterator:transliteratedTextOutputTo="@+id/edtId"` would output transliterated output of the edit text automatically to another Edittext or TextView specified by 'fieldId'
If id is same as that of current edit text then it would replace contents of current edit text too.

Transliterated text can also be obtained by :

```
    String transliterator = edtTransliterator.getTransliteratedText();
```

#### TransliteratorTextView

```

        <org.silpa.transliteration.TransliteratorTextView
                android:id="@+id/tvTransliterator"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                transliterator:targetLanguage="english_US" />

```

Same functions available except for outputting to another field.

#### To run tests

  Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test
