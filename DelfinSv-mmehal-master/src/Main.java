import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Member me = new Member("1010991010","gustav", "jantzen,", Gender.MAN,23);
        MemberRegistry memberRegistry = new MemberRegistry(me);
        memberRegistry.memberListFileReader();

        memberRegistry.showMembers();


        Training tr = new Training();

        tr.addTraining(me, LocalDate.now(), 1);
        tr.addTraining(me, LocalDate.now(), 2);






    }


}

