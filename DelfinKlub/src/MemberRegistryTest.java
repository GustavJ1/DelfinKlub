import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberRegistryTest {

    @Test
    public void getTotalRevenue() {
        Membership membership = new Membership();
        MemberRegistry memberRegistry = new MemberRegistry(membership);

        Member member1 = new Member("0410011234", "Timo", "Casi", Gender.MAN, 454, 'K', true);
        memberRegistry.members.add(member1);
        double expectedRevenue = membership.getPrice(member1);

        String expected = "___________________________________________\n" +
                "Total omsætning = " + expectedRevenue + " kr,-\n" +
                "Antal medlemmer: " + memberRegistry.getAmountOfMembers() + "\n" +
                "___________________________________________\n";

        String actual = memberRegistry.totalrevenue();

        assertEquals(expected, actual);
    }
}


