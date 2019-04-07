import java.io.FileNotFoundException;
import java.io.IOException;

public class CourseWork2 {

    public static void main(String[] args) throws IOException {
        int i = 0;
        Character cw2i = new Character();// creating the character class object
        // calling other class methods
        int level = cw2i.levelMethod();
        int[] finalSum = cw2i.dicerollTxMethod();
        cw2i.dicerollMethod(level, finalSum);

    }
}
