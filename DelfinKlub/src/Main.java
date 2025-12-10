import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Membership membership = new Membership();
        MemberRegistry m = new MemberRegistry(membership);
        m.memberListFileReader();
        Console console = new Console();
        console.program();
        System.out.println(m.totalrevenue());
        //m.addMember(new Member("1010991010", "sylvester", "stalone", Gender.MAN, 10, 'k', true));
    }

}

