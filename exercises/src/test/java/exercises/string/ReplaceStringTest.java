package exercises.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.exercises.string.replacement.StringReplace;
import org.junit.Test;

public class ReplaceStringTest {

    @Test
    public void testBlankString() {
        String str = "";
        assertEquals(str, StringReplace.replaceIterative(str, 'a', 'b'));
        assertEquals(str, StringReplace.replaceRecursive(str, 'a', 'b'));

        str = null;
        assertEquals(str, StringReplace.replaceIterative(str, 'a', 'b'));
        assertEquals(str, StringReplace.replaceRecursive(str, 'a', 'b'));

        str = "            ";
        assertEquals(str, StringReplace.replaceIterative(str, 'a', 'b'));
        assertEquals(str, StringReplace.replaceRecursive(str, 'a', 'b'));

        str = "            ab";
        assertNotEquals(str, StringReplace.replaceIterative(str, 'a', 'b'));
        assertNotEquals(str, StringReplace.replaceRecursive(str, 'a', 'b'));
    }

    @Test
    public void testBlankChars() {
        String str = "teste";
        assertEquals(str, StringReplace.replaceIterative(str,
                Character.MIN_VALUE, Character.MIN_VALUE));
        assertEquals(str, StringReplace.replaceRecursive(str,
                Character.MIN_VALUE, Character.MIN_VALUE));

        str = "            ";
        assertEquals(str, StringReplace.replaceIterative(str,
                Character.MIN_VALUE, Character.MIN_VALUE));
        assertEquals(str, StringReplace.replaceRecursive(str,
                Character.MIN_VALUE, Character.MIN_VALUE));
    }

    @Test
    public void testIdentificalParameters() {
        String str = "teste";
        assertEquals(str, StringReplace.replaceIterative(str, 'a', 'a'));
        assertEquals(str, StringReplace.replaceRecursive(str, 'a', 'a'));
    }

    @Test
    public void testCharNotPresent() {
        String str = "teste";
        assertEquals(str, StringReplace.replaceIterative(str, 'a', 'b'));
        assertEquals(str, StringReplace.replaceRecursive(str, 'a', 'b'));
    }

    @Test
    public void testCaseSensitive() {
        String actual = "teste TESTE tes";
        assertEquals("teste TuSTu tes",
                StringReplace.replaceIterative(actual, 'E', 'u'));
        assertEquals("teste TuSTu tes",
                StringReplace.replaceRecursive(actual, 'E', 'u'));

        assertEquals("tustu TESTE tus",
                StringReplace.replaceIterative(actual, 'e', 'u'));
        assertEquals("tustu TESTE tus",
                StringReplace.replaceRecursive(actual, 'e', 'u'));
    }

    @Test
    public void testSpaceReplacement() {
        String actual = "teste TESTE tes";
        assertEquals("testeuTESTEutes",
                StringReplace.replaceIterative(actual, ' ', 'u'));
        assertEquals("testeuTESTEutes",
                StringReplace.replaceRecursive(actual, ' ', 'u'));
    }

    @Test
    public void testLastCharReplacement() {
        String actual = "testeeee e eee";

        assertEquals("txstxxxx x xxx",
                StringReplace.replaceIterative(actual, 'e', 'x'));
        assertEquals("txstxxxx x xxx",
                StringReplace.replaceRecursive(actual, 'e', 'x'));
    }

    @Test
    public void testLittleText() {
        String actual = "a";

        assertEquals("o", StringReplace.replaceIterative(actual, 'a', 'o'));
        assertEquals("o", StringReplace.replaceRecursive(actual, 'a', 'o'));
    }

    @Test
    public void testBigText() {
        String actual = "Lorem ipsum dolor sit amet, consectetur adipiscing eli"
                + "t. Mauris quis nunc vel nisl pulvinar pharetra. Nam sit amet"
                + " finibus felis, eu lobortis tellus. Aenean placerat interdum"
                + " nulla, sed blandit turpis tincidunt quis. In porttitor liber"
                + "o ut nunc molestie placerat. Praesent et nulla metus. Sed ma"
                + "ssa nibh, semper sit amet enim ut, tempor aliquet tellus. Et"
                + "iam sed purus magna. Pellentesque efficitur pellentesque nis"
                + "i, sit amet pulvinar mauris vulputate sed. Morbi rhoncus luc"
                + "tus nisi, ac suscipit libero.";
        String expected = "Lxrem ipsum dxlxr sit amet, cxnsectetur adipiscing e"
                + "lit. Mauris quis nunc vel nisl pulvinar pharetra. Nam sit am"
                + "et finibus felis, eu lxbxrtis tellus. Aenean placerat interd"
                + "um nulla, sed blandit turpis tincidunt quis. In pxrttitxr li"
                + "berx ut nunc mxlestie placerat. Praesent et nulla metus. Sed"
                + " massa nibh, semper sit amet enim ut, tempxr aliquet tellus."
                + " Etiam sed purus magna. Pellentesque efficitur pellentesque "
                + "nisi, sit amet pulvinar mauris vulputate sed. Mxrbi rhxncus "
                + "luctus nisi, ac suscipit liberx.";

        assertEquals(expected,
                StringReplace.replaceIterative(actual, 'o', 'x'));
        assertEquals(expected,
                StringReplace.replaceRecursive(actual, 'o', 'x'));
    }
}
