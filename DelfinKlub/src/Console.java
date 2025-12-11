import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Console {
    Member member;
    Membership membership = new Membership();
    MemberRegistry mr= new MemberRegistry(membership);
    Event event = new Event();

    public void program() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        mr.memberListFileReader();

        while (running) {
            // Program Display
            System.out.println("🐬~~~~~~~~~~~~~~~~~~~~🐬");
            System.out.println("VELKOMMEN til Delfin Club");
            System.out.println("Tast 1 for [Coach]  -  Tast 2 for [Formand]  -  Tast 3 for [Kasserer]  -  Tast 0 for [Afslut Program]");
            System.out.println("↓");

            int scInput = sc.nextInt();
            sc.nextLine(); // Rydder buffer

            switch (scInput) {

                case 1:
                    System.out.print("""
                                        [1] - Indskrivning af trænings-resultater: \s
                                        [2] - Indskrivning af tidligere trænings-resultater:
                                        [3] - Indskrivning af konkurrenceresultater:
                                        [4] - Se træningsresultater:
                                     """);
                    int choice = sc.nextInt();

                    // tilføj trænings-resultater
                    if (choice == 1) {
                        System.out.println("Disciplin (TAG HØJDE FOR CAPS");
                        Disciplin disciplin = Disciplin.valueOf(sc.next());
                        event.eventDate(disciplin, "DelfinKlub/src/Training.txt");
                        System.out.println("Træningen er hermed tilføjet");
                    }

                    if (choice == 2) {
                        System.out.println("Disciplin (TAG HØJDE FOR CAPS");
                        Disciplin disciplin = Disciplin.valueOf(sc.next());

                        System.out.println("Indtast dato for pågældende trænings-resultater (yyyy-MM-dd)");
                        System.out.println("↓");

                        LocalDate date = LocalDate.parse(sc.next());
                        event.manuallyEnterEventDate(date, disciplin, "DelfinKlub/src/Training.txt");
                        System.out.println("Træningen fra en tidligere dato er hermed tilføjet");
                    }

                    // Indskriv konkurrence-resultater
                    if (choice == 3) {
                        System.out.print("Konkurrence Resultater");
                    }

                    // Se trænings-resultater
                    if (choice == 4) {
                        System.out.println("Indtast dato for pågældende trænings-resultater (yyyy-MM-dd)");
                        System.out.println("↓");
                        LocalDate date = LocalDate.parse(sc.next());

                        event.readEvent(String.valueOf(date),"DelfinKlub/src/Training.txt");
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
                                 [1] Se Total Revenue
                                 [2] Se Medlemmer i Restance
                                 [3] Se specifik medlem kontigent""");
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
                    sc.close();
                    break;

                default:
                    System.out.println("ugyldigt valg");
                    break;
            }
        }
    }
}



/*
Coach
tast 1 opret training
tast 2 opret competition
tast 3 print trainingResults (skal man have noget funktionalitet i forhold til udtagelse til competition?)
tast 4 print competitionResults
<<<<<<< HEAD
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
=======

Formand
tast 1 opret medlem
Tast 2 fjern medlem
Tast 3 liste af medlemmer

Kasserer
Tast 1 se totalRevenue (periode)
>>>>>>> Joakim
tast 2 se medlemmer i restance
tast 3 se specifik medlem kontingent
*/



