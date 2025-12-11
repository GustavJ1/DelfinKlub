import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;


public class Competition implements Comparable<Member> {

    MemberRegistry memberRegistry;

    Coach coach;
    List<Member> members = new ArrayList<>();

    int placement;
    LocalTime raceTime;
    Member member;

    public Competition() {
    }

    public int compareTo(Member member) {
        Member other = (member);

        if (member.getAge() > other.getAge()) {
            return -1;
        }
        if (other.getAge() > member.getAge()) {
            return 1;
        }
        return 0;
    }

    public void readCompetitionFile(String date) {

        try {
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String line;

            if (!date.matches(startRegex)) {
                System.out.println("Ugyldig konkurrence dato");
                return;
            }

            try {
                BufferedReader readCompetitionFile = new BufferedReader(new FileReader("DelfinKlub/src/Competition.txt"));

                while ((line = readCompetitionFile.readLine()) != null) {

                    if (line.equals(startRegex)) {
                        System.out.println(line);
                    }

                    while ((line = readCompetitionFile.readLine()) != null) {

                        if (line.equals("-")) {
                            return;
                        }
                        System.out.println(line);
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("fil ikke fundet");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


/*
Sorterer mellem junior og senior
Skrive 20 medlemmer med tid og placering inden for en dato, med 5 i hver disciplin (Junior)
Skrive 20 medlemmer med tid og placering inden for en dato, med 5 i hver disciplin (Senior)
Automatisk sorterer og placerer deltagerne efter tid

*/