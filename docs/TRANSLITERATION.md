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

#### To run tests

  Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test
