import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class ParametrizedTest {

    @RunWith(Parameterized.class)
    public static class ParameterizedTest {
        String sex;
        boolean hasMane;

        public ParameterizedTest(String sex, boolean hasMane) {
            this.sex = sex;
            this.hasMane = hasMane;
        }

        @Mock
        Feline feline;

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Test
        public void checkSexLionWhenHasManeResult() throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.doesHaveMane());
        }
    }


}
