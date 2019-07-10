import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //given
        Integer count=0;
        Integer num=0;
        String Hamlet = "Hamlet";
        Pattern hamlet = Pattern.compile(Hamlet,Pattern.CASE_INSENSITIVE);
        Matcher mhamlet = hamlet.matcher(hamletParser.getHamletData());
        if(mhamlet.find()) {
         count=  mhamlet.groupCount();
        }
       hamletParser.ChangeHamletToLeon ();
       // Pattern.compile("Hamlet").matcher(hamletParser.getHamletData()).replaceAll("Leon");

        String leon = "Leon";
        Pattern Leon = Pattern.compile(leon,Pattern.CASE_INSENSITIVE);
        Matcher mleon = Leon.matcher(hamletParser.getHamletData());
        if(mleon.find()){
            num = mleon.groupCount();
        }

        Assert.assertEquals(count,num);


    }

    @Test
    public void testChangeHoratioToTariq() {
        Integer count=0;
        Integer num=0;
        String Horatio = "Horatio";
        Pattern horatio = Pattern.compile(Horatio,Pattern.CASE_INSENSITIVE);
        Matcher mhoratio = horatio.matcher(hamletParser.getHamletData());
        if(mhoratio.find()) {
            count=  mhoratio.groupCount();
        }
        hamletParser.ChangeHoratioToTariq();


        String Tariq = "Tariq";
        Pattern tariq = Pattern.compile(Tariq,Pattern.CASE_INSENSITIVE);
        Matcher mtariq = tariq.matcher(hamletParser.getHamletData());
        if(mtariq.find()){
            num = mtariq.groupCount();
        }

        assertEquals(count,num);

    }

    @Test
    public void testFindHoratio() {
        String PatterString = ".";
        Pattern pattern = Pattern.compile(PatterString, Pattern.CASE_INSENSITIVE);
        String text = "Horatio";
        Matcher matcher = pattern.matcher(text);
        Boolean isThere = matcher.matches();
        Boolean expected = hamletParser.FindHoratio();

        Assert.assertEquals(expected,isThere);
    }

    @Test
    public void testFindHamlet() {
        String PatterString = ".";
        Pattern pattern = Pattern.compile(PatterString, Pattern.CASE_INSENSITIVE);
        String text = "Hamlet";
        Matcher matcher = pattern.matcher(text);
        Boolean isThere = matcher.matches();
        Boolean expected = hamletParser.FindHamlet();

        Assert.assertEquals(expected,isThere);

    }


}