package Tests.gameControllerTests;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import gameController.Inputs.Utils;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void parseInt() {
        String s1="5";
        String s2="-5";
        String s3="515";
        String s4="2156775";
        String s5="-21231356";
        String s6="+5112";
        String s7="5.";
        String s8="553,111";
        String s9="5a";
        String s10="ah";

        ArrayList<Integer> listUncorrect=new ArrayList<>();
        listUncorrect.add(Utils.parseInt(s7));
        listUncorrect.add(Utils.parseInt(s8));
        listUncorrect.add(Utils.parseInt(s9));
        listUncorrect.add(Utils.parseInt(s10));

        assertEquals(5,Utils.parseInt(s1));
        assertEquals(-5,Utils.parseInt(s2));
        assertEquals(515,Utils.parseInt(s3));
        assertEquals(2156775,Utils.parseInt(s4));
        assertEquals(-21231356,Utils.parseInt(s5));
        assertEquals(5112,Utils.parseInt(s6));

        for (Integer i:listUncorrect) {
            assertEquals(0,i.intValue());
        }
        }


    }