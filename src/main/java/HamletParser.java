import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

//    public static void main(String[] args) {
//
//        System.out.println(hamletParser.ChangeHamletToLeon());
//
//    }

    public Boolean FindHamlet(){
        Integer count =0;
        String Hamlet = "Hamlet";
        Pattern hamlet = Pattern.compile(Hamlet,Pattern.CASE_INSENSITIVE);
        Matcher mhamlet = hamlet.matcher(getHamletData());
        if(mhamlet.find())
            count=  mhamlet.groupCount();
        if(count > 0)
            return true;

        return false;

    }

    public Boolean FindHoratio() {
        Integer count =0;
        String Horatio = "Horatio";
        Pattern horatio = Pattern.compile(Horatio,Pattern.CASE_INSENSITIVE);
        Matcher mhoratio = horatio.matcher(getHamletData());
        if(mhoratio.find())
            count=  mhoratio.groupCount();
        if(count > 0)
            return true;

        return false;


    }

    public void ChangeHamletToLeon() {
        Pattern.compile("Hamlet").matcher(getHamletData()).replaceAll("Leon");

    }

    public void ChangeHoratioToTariq() {
        Pattern.compile("Horatio").matcher(getHamletData()).replaceAll("Tariq");
    }
}
