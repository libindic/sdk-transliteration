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

        Transliterator tx = new Transliterator(getContext());
        assertEquals("namaskaara idu kannaDa paThya TraansliTareshhan parikshhegaagi", tx.transliterate("ನಮಸ್ಕಾರ ಇದು ಕನ್ನಡ ಪಠ್ಯ ಟ್ರಾನ್ಸ್ಲಿಟರೇಷನ್ ಪರೀಕ್ಷೆಗಾಗಿ", "en_US"));
        assertEquals("namaskaar silpaa kee duniyaa mem aapakaa svaagath hai", tx.transliterate("नमस्कार सिल्पा की दुनिया में आपका स्वागत है", "en_US"));
        assertEquals("ದಿಸ್ ಇಸ್ ಅ ಇಂಗ್ಗ್ಲಿಷ್ ಟೆಕ್ಸ್ಟ್ ಫೋರ್ transliteration", tx.transliterate("This is a english text for transliteration", "kn_IN"));
        assertEquals("நமஸ்கார இது கந்நட பட்ய ட்ராந்ஸ்லிடரேஷந் பரீக்ஷெகாகி", tx.transliterate("ನಮಸ್ಕಾರ ಇದು ಕನ್ನಡ ಪಠ್ಯ ಟ್ರಾನ್ಸ್ಲಿಟರೇಷನ್ ಪರೀಕ್ಷೆಗಾಗಿ", "ta_IN"));
        assertEquals("ഇലവച", tx.transliterate("இலவச", "ml_IN"));
        assertEquals("-ஸந்த்ய", tx.transliterate("-സന്ധ്യ", "ta_IN"));
        assertEquals("8 *", tx.transliterate(" 8 *", "ta_IN"));
        assertEquals("ആധാരവാഗിരുവ", tx.transliterate("ಆಧಾರವಾಗಿರುವ", "ml_IN"));
        assertEquals("തീപാവളി വാഴ്ത്തുകള്", tx.transliterate("தீபாவளி வாழ்த்துகள்", "ml_IN"));
        assertEquals("ತೀಪಾವಳಿ ವಾ಴್ತ್ತುಕಳ್", tx.transliterate("தீபாவளி வாழ்த்துகள்", "kn_IN"));
        assertEquals("ഔട്‍‍‍‍‍‍ലുക് മുകളിൽ പകർന്നുതന്ന അറിവിന്‍റെ തേൻകണം", tx.transliterate("ഔട്‍‍‍‍‍‍ലുക് മുകളിൽ പകർന്നുതന്ന അറിവിന്‍റെ തേൻകണം ", "ml_IN"));
        assertEquals("റ്റ്റേന്‍സ്ലയ്ഷന്‍", tx.transliterate("translation", "ml_IN"));
        assertEquals("śārada sandhyakaḷ maravūri cuṟṟūṁ", tx.transliterate("ശാരദ സന്ധ്യകള്‍ മരവൂരി ചുറ്റൂം", "ISO15919"));
        assertEquals("ɕaːɾəd̪ə sən̪d̪ʱjəkəɭ məɾəʋuːɾi ʧurruːm", tx.transliterate("ശാരദ സന്ധ്യകള്‍ മരവൂരി ചുറ്റൂം", "IPA"));
        assertEquals("हौ वाज़ द मेच?", tx.transliterate("how was the match?", "hi_IN"));
        assertEquals("அவந", tx.transliterate("അവനു്", "ta_IN"));
        assertEquals("நகம்", tx.transliterate("നഖം", "ta_IN"));
        assertEquals("avanu", tx.transliterate("അവനു്", "en_IN"));
        assertEquals("avan", tx.transliterate("അവനു്?", "ISO15919"));
        assertEquals("help", tx.transliterate("help", "en_IN"));
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
