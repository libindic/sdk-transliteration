import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.silpa.transliteration.Transliterator;

/**
 * Created by sujith on 7/7/14.
 */
public class TestTransliterator extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testTransliterate() {

        Transliterator transliterator = new Transliterator(getContext());
        assertEquals("namaskaara idu kannaDa paThya TraansliTareshhan parikshhegaagi", transliterator.transliterate("ನಮಸ್ಕಾರ ಇದು ಕನ್ನಡ ಪಠ್ಯ ಟ್ರಾನ್ಸ್ಲಿಟರೇಷನ್ ಪರೀಕ್ಷೆಗಾಗಿ", "en_US"));
        assertEquals("namaskaar silpaa kee duniyaa mem aapakaa svaagath hai", transliterator.transliterate("नमस्कार सिल्पा की दुनिया में आपका स्वागत है", "en_US"));
        assertEquals("ದಿಸ್ ಇಸ್ ಅ ಇಂಗ್ಗ್ಲಿಷ್ ಟೆಕ್ಸ್ಟ್ ಫೋರ್ transliteration", transliterator.transliterate("This is a english text for transliteration", "kn_IN"));
        assertEquals("நமஸ்கார இது கந்நட பட்ய ட்ராந்ஸ்லிடரேஷந் பரீக்ஷெகாகி", transliterator.transliterate("ನಮಸ್ಕಾರ ಇದು ಕನ್ನಡ ಪಠ್ಯ ಟ್ರಾನ್ಸ್ಲಿಟರೇಷನ್ ಪರೀಕ್ಷೆಗಾಗಿ", "ta_IN"));

    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetModuleName() {
        Transliterator obj = new Transliterator(getContext());
        assertNotNull(obj);
        assertEquals(Transliterator.MODULE_NAME, obj.getModuleName());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetModuleInformation() {
        Transliterator obj = new Transliterator(getContext());
        assertNotNull(obj);
        assertEquals(Transliterator.MODULE_INFORMATION, obj.getModuleInformation());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
