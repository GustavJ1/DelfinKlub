import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Training extends Member{
    Disciplin disciplin;
    LocalDate date;

    public ArrayList<Member> competitiveMembers = new ArrayList<>();

    public Training(){

    }

    public void addTraining(Member member, LocalDate date, int placement) {

        File currentTraining = new File("C:/Users/gusta/Downloads/DelfinSv-mmehal-master/DelfinSv-mmehal-master/TrainingResults.txt");

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(currentTraining, true));

            writeTrainingFile.write("Dato: ");
            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write(", MedlemsNr: ");
            writeTrainingFile.write(String.valueOf(member.getMemberId()));
            writeTrainingFile.write(", Stilling: ");
            writeTrainingFile.write(String.valueOf(placement));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();


            /*
            Fil indhold: Dato, id, placering
            Bufferedwriter
            Hent memberlist
            Random: Placement
            Sort: Efter placering
            write to file loop
             */
        writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readTrainingFile() {

        try {
            BufferedReader readTrainingFile = new BufferedReader(new FileReader("C:/Users/gusta/Downloads/DelfinSv-mmehal-master/DelfinSv-mmehal-master/TrainingResults.txt)"));
            String line;

            while ((line = readTrainingFile.readLine()) != null) {
                System.out.println(line);
            }
            readTrainingFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//
//      public void sortMemberByPlacementInDisciplines() {
//
//    }
//
//    public void addTopFiveToCompetition() {
//
//    }


    @Override
    public String toString() {
        return " ";
    }
}
