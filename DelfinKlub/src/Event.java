import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Event {

    public Event() {
    }

    private void eventInfo(BufferedWriter writeTrainingFile) throws IOException {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            System.out.println("Indtast MedlemsNr: ");
            int memberId = sc.nextInt();
            writeTrainingFile.write(memberId + ",");

            System.out.println("Indtast placering");
            int placement = sc.nextInt();
            writeTrainingFile.write("" + placement);
            writeTrainingFile.write("\n");
        }
        writeTrainingFile.write("-");
        writeTrainingFile.write("\n");
        writeTrainingFile.flush();
    }


    public void eventDate(String pathname, LocalDate date) {
        File filePath = new File(pathname);

        try {
            BufferedWriter writeTrainingFile = new BufferedWriter(new FileWriter(filePath, true));
            writeTrainingFile.write(String.valueOf(date));
            writeTrainingFile.write("\n");
            writeTrainingFile.flush();

            eventInfo(writeTrainingFile);

            writeTrainingFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBackCrawl(LocalDate date) { // BackCrawl
        eventDate("DelfinKlub/src/Backcrawl.txt", date);
    }

    public void addBreastStroke(LocalDate date) { // BreastStroke

        eventDate("DelfinKlub/src/Breaststroke.txt", date);
    }

    public void addButterfly(LocalDate date) { //Butterfly

        eventDate("DelfinKlub/src/Butterfly.txt", date);
    }

    public void addCrawl(LocalDate date) {

        eventDate("DelfinKlub/src/Crawl.txt", date);
    }

    public void readEvent(String date, String filePath) {

        try {
            String startRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String line;

            if (!date.matches(startRegex)) {
                System.out.println("Ugyldigt datoformat");
                return;
            }

            try {
                BufferedReader readTrainingFile = new BufferedReader(new FileReader(filePath));

                while ((line = readTrainingFile.readLine()) != null) {

                    if (line.equals(date)) {
                        System.out.println(filePath + " resultater " + " - " + date + ":");

                        while ((line = readTrainingFile.readLine()) != null) {

                            if (line.equals("-")) {
                                return;
                            }
                            System.out.println(line);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("fil ikke fundet");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readBackCrawl(String date) {
        readEvent(date,"DelfinKlub/src/Backcrawl.txt");
    }

    public void readCrawl(String date) {
        readEvent(date, "DelfinKlub/src/crawl.txt");
    }

    public void readBreastStroke(String date) {
        readEvent(date,"DelfinKlub/src/Breaststroke.txt");
    }

    public void readButterfly(String date) {
        readEvent(date,"DelfinKlub/src/ButterFly.txt");
    }

    @Override
    public String toString() {
        return " ";
    }
}