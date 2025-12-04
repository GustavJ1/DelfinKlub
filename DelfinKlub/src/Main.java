import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Working directory: " + new File(".").getAbsolutePath());
        Membership membership = new Membership();
        Member member= new Member("1010901010","gustav","jantzen",Gender.MAN,1,'k',false);
        MemberRegistry memberRegistry = new MemberRegistry(membership);
        memberRegistry.memberListFileReader();
        memberRegistry.showMembers();
        memberRegistry.checkArreasStatus();
        System.out.println("membership:" + membership);
        System.out.println(membership.getPrice(member));
        System.out.println(memberRegistry.totalrevenue());
        System.out.println(1);

        System.out.println("..............");

        Training tr = new Training();
        tr.readBackCrawl("30-04-2025");
    }

}

