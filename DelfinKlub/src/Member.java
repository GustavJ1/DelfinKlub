import java.io.*;
import java.time.Period;
import java.time.LocalDate;

public class Member {

    private final int memberId;
    private final Gender gender;
    private String firstName;
    private String lastName;
    private final String cpr;
    private char competitionSwimmer;
    private boolean active;

    public Member(String cpr, String firstName, String lastName, Gender gender, int memberId, char competitionSwimmer, boolean active) {
        this.cpr = cpr;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitionSwimmer = competitionSwimmer;
        this.active = active;
        this.memberId=memberId;
    }
    public boolean isActive(){
        return active;
    }

    public boolean isCompetitionSwimmer() {
        return competitionSwimmer == 'K';
    }

    public String getCompSwimmerString(){
        if (this.competitionSwimmer == 'T' ){
            return "T";
        } else return "K";
    }

    public String stringFromGender() {
        if (this.gender == Gender.MAN) {
            return "MAN";
        } else return "WOMAN";
    }

    public int getMemberId(){
        return this.memberId;
    }

    public int yearFromCpr() {
        int year = Integer.parseInt(cpr.substring(4, 6));

        if (year > 25) {
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

    public String getCpr() {
        return cpr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ". Medlems Nr: " + memberId + ", " + (competitionSwimmer == 'K' ? "Konkurrence Svømmer" : "Fritids Svømmer");
    }


}
