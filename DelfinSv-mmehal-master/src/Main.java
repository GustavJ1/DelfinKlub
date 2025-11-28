import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Member me = new Member();
        me.memberListFileReader();
        me.printMembers();

        Training tr = new Training();

        tr.addTraining(me, LocalDate.now(), 1);








    }


}

