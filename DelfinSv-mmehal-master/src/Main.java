import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
Member m1 = new Member("1010901010","gustav","jantzen",Gender.MAN,1,'k');
        MemberRegistry memberRegistry = new MemberRegistry();
        memberRegistry.memberListFileReader();
        memberRegistry.showMembers();
        System.out.println(".............");
        Training tr = new Training(LocalDate.now(),1,m1,Disciplin.BREASTSTROKE);
        tr.readBreastStroke();
        tr.readBackCraw();
        tr.readButterfly();
        tr.readCrawl();

        //  tr.addTraining(me, LocalDate.now(), 1);
        //  tr.addTraining(me, LocalDate.now(), 2);


    }


}

