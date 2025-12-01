import java.io.*;
import java.time.Period;
import java.time.LocalDate;
public class Member {

    private int memberId;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String cpr;
    private boolean competitionSwimmer;
    private boolean membershipStatus;
    public boolean active;
    private int squad;



    public Member(String cpr, String firstName, String lastName, Gender gender, int memberId) {
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitionSwimmer = false;
        this.active = true;
        this.squad = assignSquadByCpr();
        this.memberId=memberId;
    }


    public Member() {

    }

    public int getMemberId(){
        return this.memberId;
    }

    public int yearFromCpr() {
        int year = Integer.parseInt(cpr.substring(4, 6));

        if (year > 30) {
            year += 1900;
        } else {
            year += 2000;
        }
        return year;
    }

    private int monthFromCpr() {
        return Integer.parseInt(cpr.substring(2, 4));

    }

    private int dayFromCpr() {
        return Integer.parseInt(cpr.substring(0, 2));
    }

    public int getAge() {
        Period age = Period.between(getBirthday(), LocalDate.now());
        return age.getYears();
    }

    private LocalDate getBirthday() {
        return LocalDate.of(yearFromCpr(), monthFromCpr(), dayFromCpr());
    }

    public int assignSquadByCpr() {
        int squad = 0;
        int age = getAge();

        if (age < 18) {
            squad = 1;
        } else if (age > 60) {
            squad = 3;

        } else {
            squad = 5;
        }
        return squad;
    }




    @Override
    public String toString() {
        return lastName + ", " + firstName + ". Medlems Nr: " + memberId;
    }
}
