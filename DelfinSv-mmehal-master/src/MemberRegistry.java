import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistry {
    private int memberId;
    Member member;
    public ArrayList<Member> members = new ArrayList<>();
    private boolean yearlyRenewalStatus;

    public MemberRegistry(Member member) {
        this.member = member;
    }

    public void showMembers() {
        System.out.println("List of all current members");
        for (Member m : members) {
            System.out.println(m + " ");
        }
    }
// gør printmembers ikke det samme som showmembers? XD
    public void printMembers() {

        for (Member m : members) {
            System.out.println(m + "\n");
        }

    }

    public void memberListFileReader() {
        File file = new File("C:/Users/gusta/Downloads/DelfinSv-mmehal-master/DelfinSv-mmehal-master/MemberList.txt");

        try {
            BufferedReader memberListReader = new BufferedReader(new FileReader(file));
            String line;
            this.memberId = 0;
            while ((line = memberListReader.readLine()) != null) {

                memberId++;


                String[] parts = line.split(",");
                String cpr = parts[0];
                String firstName = parts[1];
                String lastName = parts[2];
                Gender gender = Gender.valueOf(parts[3]);

                Member member = new Member(cpr, firstName, lastName, gender, memberId);
                members.add(member);

            }
            memberListReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setArrears() {
        this.yearlyRenewalStatus = false;
    }

    public void checkYearlyRenewalStatus() {
        for (Member member : members) {


            if (yearlyRenewalStatus == false) {

                List<Member> arrears = new ArrayList<>();

                arrears.add(member);
            }
        }
    }





}
