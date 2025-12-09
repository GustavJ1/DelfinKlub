import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Console {
    Training training;
    Membership membership = new Membership();
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    MemberRegistry mr = new MemberRegistry(membership);


    public void program() {
        mr.memberListFileReader();
        while (running) {


            System.out.println("Velkommen til Delfin Club");
            System.out.println("Tast 1 for [Coach] \nTast 2 for [Formand] \nTast 3 for [Kasserer]");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Tast 1 for at indskrive træningsresultater\n" +
                            "Tast 2 for indskrive konkurrenceresultater \n" +
                            "Tast 3 for at se træningsresultater");

                    int choices = sc.nextInt();

                    if (choices == 1) {
                        System.out.println("Enter date (yyyy-MM-dd)");
                        String input = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        try {
                            LocalDate myDate = LocalDate.parse(input, formatter);
                            training.readBackCrawl(myDate.toString());

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    } else if (choices == 2) {

                    } else if (choices == 3) {
                        System.out.println("""
                                Hvad vil du se resultater for?\s
                                [1] Backcrawl
                                [2] Breaststroke
                                [3] Butterfly
                                [4] Crawl""");

                        int chooseFile = sc.nextInt();
                        if (chooseFile == 1) {
                            System.out.println("Vælg dato");
                            String date = sc.nextLine();
                            training.readBackCrawl(date);

                        } else if (chooseFile == 2) {
                            System.out.println("vælg dato");
                            //training.readBreastStroke(sc.nextLine());
                        }
                    }

                    break;

                case 2:

                    System.out.println("""
                            hvad vil du gøre nu?\s
                            [1] tilføje medlem
                            [2] fjerne medlem
                            [3] se alle medlemmer""");

                    choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("det virker");
                        //skal lave metode til addmember()?
                    } else if (choice == 2) {
                        System.out.println("vælg medlemsID du vil fjerne");
                        int removeMember = sc.nextInt();
                        mr.removeMember(removeMember);

                    } else if (choice == 3) {

                        mr.memberListFileReader();
                        mr.showMembers(); //virker, viser medlemmer skal også være en tom linje inden break
                        sc.nextLine();

                    }
                    break;
                case 3: // Kasserers tool (økonomi)
                    System.out.println("""
                            Du kan nu vælge følgende \s
                            Tast [1] Se Total Revenue
                            Tast [2] Se Medlemmer i Restance
                            Tast [3] Se specifik medlem kontigent""");
                    int revchoice = sc.nextInt();
                    if (revchoice == 1) {
                        System.out.println(mr.totalrevenue());


                    } else if (revchoice == 2) {
                        mr.checkArrearsStatus();
                    }
                    else if (revchoice==3){
                        mr.setActive();
                    }
                    break;

                case 0:
                    System.out.println("programmet afsluttet");
                    running = false;
                    break;
                default:
                    System.out.println("ugyldigt valg");
                    break;
            }


        }
    }
}
/*                 */

/* Scanner start menu - "velkommen til Delfin Club
Coach / Formand / Kasserer
Coach {
tast 1 opret training
tast 2 opret competition
tast 3 print trainingResults (skal man have noget funktionalitet i forhold til udtagelse til competition?)
tast 4 print competitionResults
}
Formand {
tast 1 opret nyt medlem
Tast 2 foretag ændringer på medlem
 - opsig medlem
 - gør medlem passiv status
Tast 3 liste af medlemmer
tast
}
Kasserer {
Tast 1 se totalRevenue (periode) fikset
tast 2 se medlemmer i restance
tast 3 se specifik medlem kontingent

}
*/