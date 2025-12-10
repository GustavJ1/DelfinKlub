import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberRegistryTest {

    @Test
    public void getTotalRevenue() {
        Membership Membership = null;
        MemberRegistry memberRegistry = new MemberRegistry(Membership);
        Member member;
        Member member1 = new Member("0410011234", "Timo", "Casi", Gender.MAN, 454, 'k', true);


        String expected = """
                ___________________________________________
                Total omsætning = 0.0 kr,-
                Antal medlemmer: 0
                ___________________________________________
                """;

        String actual = memberRegistry.totalrevenue();

        assertEquals(expected, actual);
    }
}
