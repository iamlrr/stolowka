import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stolowka.Stolowka;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StolowkaTest {
    @Test
    public void howManyMealsTodayTest() {
        int customers = 80;
        Stolowka stolowka = new Stolowka(customers);
        assertEquals(customers, stolowka.getMealsForToday());
    }

    @Test
    public void howManyMealsThisMonthTest() {
        int customers = 80;
        Stolowka stolowka = new Stolowka(customers);
        assertEquals(customers * Stolowka.DAYS, stolowka.getMealsForThisMonth());
    }


    @Test
    public void howManyMealsAfterCancellationsTest() {
        int customers = 80;
        int cancellations = 7;
        Stolowka stolowka = new Stolowka(customers);
        stolowka.cancelMeals(cancellations);
        assertEquals(customers, stolowka.getMealsForToday());
        assertEquals(customers - cancellations, stolowka.getMealsTomorrow());
    }

    @Test
    public void currentMonthIncomeTest() {
        int customers = 80;
        Stolowka stolowka = new Stolowka(customers);
        assertEquals(customers*Stolowka.DAYS*stolowka.getMealPrice(), stolowka.getPaymentThisMonth());
    }
    @Test
    public void nextMonthIncomeTest() {
        int customers = 80;
        int cancellations = 20;
        Stolowka stolowka = new Stolowka(customers);
        stolowka.cancelMeals(cancellations);
        assertEquals((customers * Stolowka.DAYS - cancellations) * stolowka.getMealPrice(),
                stolowka.getPaymentNextMonth());
    }
}
