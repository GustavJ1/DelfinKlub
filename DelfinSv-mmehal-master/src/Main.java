import java.io.*;
import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Member m1 = new Member("1010901010", "gustav", "jantzen", Gender.MAN, 1, 'k', true);
        MemberRegistry memberRegistry = new MemberRegistry();
        memberRegistry.memberListFileReader();
        memberRegistry.showMembers();
        System.out.println(".............");
        memberRegistry.checkArreasStatus();
    }


}

