import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Membership membership = new Membership();
        Console console = new Console();
        MemberRegistry m=new MemberRegistry(membership);
        m.memberListFileReader();
        System.out.println(".......");

      console.program();










        //console.program();

        //mr.removeMember(1203041234);

    }

}

