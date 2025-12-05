import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Working directory: " + new File(".").getAbsolutePath());
        Membership membership = new Membership();
        Member member= new Member("1010901010","gustav","jantzen",Gender.MAN,1,'k');




        Membership ms = new Membership();
        MemberRegistry mr = new MemberRegistry(ms);
        mr.memberListFileReader();
        mr.checkArrearsStatus();
        member.paidArrears(1);

    }

}

