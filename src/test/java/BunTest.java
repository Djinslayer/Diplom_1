import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("Тестовая булка", 100500f);
    }

    @Test
    @DisplayName("Проверка получения корректного имени булки")
    public void getCorrectNameTest() {
        String expectedName = "Тестовая булка";
        String actualName = bun.getName();

        assertEquals("Значения имени должны совпадать", expectedName, actualName);
    }

    @Test
    @DisplayName("Проверка получения корректной цены булки")
    public void getCorrectPriceTest() {
        float expectedPrice = 100500f;
        float actualPrice = bun.getPrice();

        assertEquals("Значения цены должны совпадать", expectedPrice, actualPrice, 0);
    }
}
