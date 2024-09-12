import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Ingredient ingredientFilling;

    @Mock
    private Ingredient ingredientSauce;

    @Mock
    private Bun bun;

    @Before
    public void createTestObjects(){

        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Тестовая булка");
        Mockito.when(bun.getPrice()).thenReturn(100500f);

        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(100f);
        Mockito.when(ingredientFilling.getName()).thenReturn("Какая-то начинка");

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(500f);
        Mockito.when(ingredientSauce.getName()).thenReturn("Сычуаньский");

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

    }


    @Test
    @DisplayName("Проверка получения правильного количества ингредиентов бургера")
    public void addIngredientReturnsCorrectNumberTest() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        int actualCountIngredients = burger.ingredients.size();
        int expectedCountIngredients = 4;

        assertEquals("Количество ингредиентов не совпадает", expectedCountIngredients,actualCountIngredients);
    }

    @Test
    @DisplayName("Проверка удаления ингредиента бургера")
    public void removeIngredientTest() {
        Ingredient removedIngredient = burger.ingredients.get(0);
        burger.removeIngredient(0);
        boolean isIngredientIn = burger.ingredients.contains(removedIngredient);

        assertFalse("Ингридиент должен быть удален", isIngredientIn);
    }

    @Test
    @DisplayName("Проверка перемещения ингредиентов бургера")
    public void moveIngredientCorrectOrderTest() {
        Ingredient firstIngredientBeforeMoving = burger.ingredients.get(0);
        Ingredient secondIngredientBeforeMoving = burger.ingredients.get(1);
        burger.moveIngredient(0,1);
        Ingredient firstIngredientAfterMoving = burger.ingredients.get(0);
        Ingredient secondIngredientAfterMoving = burger.ingredients.get(1);

        assertEquals(firstIngredientBeforeMoving,secondIngredientAfterMoving);
        assertEquals(secondIngredientBeforeMoving,firstIngredientAfterMoving);
    }

    @Test
    @DisplayName("Проверка получения корректной цены бургера")
    public void getCorrectPriceTest() {
        float expectedPrice = 100500 * 2 + 100 + 500;
        float actualPrice = burger.getPrice();

        Assert.assertEquals("Значения цены должны совпадать", expectedPrice, actualPrice, 0);
    }

    @Test
    @DisplayName("Проверка получения корректного рецепта бургера")
    public void getCorrectReceiptTest() {
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Тестовая булка ====)" + "\r\n" +
                "= sauce Сычуаньский =" + "\r\n" +
                "= filling Какая-то начинка =" + "\r\n" +
                "(==== Тестовая булка ====)" + "\r\n" +
                "\r\n" + "Price: 201600,000000" + "\r\n";

        Assert.assertEquals("Рецепт должен совпадать", expectedReceipt, actualReceipt);
    }
}