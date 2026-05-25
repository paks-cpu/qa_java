import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String MALE = "Самец";
    private static final String UNSUPORTED_SEX = "unsuported sex";
    private static final String TEST_EXT = "Используйте допустимые значения пола животного - самей или самка";

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(MALE, feline);
        Mockito.when(feline.getKittens()).thenReturn(3);
        int actualKittensCount = lion.getKittens();
        int expectedKittensCount = 3;
        assertEquals("Неправильное число львят", expectedKittensCount, actualKittensCount);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(MALE, feline);
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals("У самца пропала грива", expectedHaveMane, actualHaveMane);
        }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(MALE, feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals("Лев питается неправильно", expected, actual);
    }

    @Test
    public void doesHaveManeThrowsExceptionTest() {
        try {
            Lion lion = new Lion("Котик", feline);
        } catch (Exception exception) {
            String textException = "Используйте допустимые значения пола животного - самей или самка";
            Assert.assertEquals(textException, exception.getMessage());
        }
    }
}


