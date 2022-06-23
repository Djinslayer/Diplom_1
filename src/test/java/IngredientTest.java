import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public  void createIngredientObject(){
        ingredient = new Ingredient(IngredientType.SAUCE,"Тестовый ингредиент", 100500f);
    }

    @Test
    @DisplayName("Проверка получения корректного имени ингредиента")
    public void getCorrectIngredientNameTest() {
        String expectedName = "Тестовый ингредиент";
        String actualName = ingredient.getName();

        assertEquals("Значения имени должны совпадать", expectedName, actualName);
    }

    @Test
    @DisplayName("Проверка получения корректной цены ингредиента")
    public void getCorrectIngredientPriceTest() {
        float expectedPrice = 100500f;
        float actualPrice = ingredient.getPrice();

        assertEquals("Значения цен должны совпадать", expectedPrice, actualPrice, 0);
    }

    @Test
    @DisplayName("Проверка получения корректного типа ингредиента")
    public void getCorrectIngredientTypeTest() {
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();

        assertEquals("Значения типа ингредиента должны совпадать", expectedType, actualType);
    }

}