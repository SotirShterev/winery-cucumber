package winery;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Wine;
import services.WineService;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class AddWineSteps {
    private int wineId;
    private String wineName;
    private Integer wineYear;
    private String wineSort;
    private String message;
    @Given("Потребителят въвежда id на вино: {int}")
    public void inputIdOfWine(int id) {
        wineId = id;
    }

    @Given("Потребителят въвежда година на производство на вино: {int}")
    public void inputYearOfWine(int year) {
        wineYear = year;
    }

    @Given("Потребителят въвежда име на вино: {string}")
    public void inputNameOfWine(String name) {
        wineName = name;
    }

    @Given("Потребителят въвежда сорт на вино: {string}")
    public void inputSortOfWine(String sort) {
        wineSort = sort;
    }

    @When("Натиска бутона добави")
    public void createWine() {
        final WineService wineService = new WineService();
        Wine wine = new Wine(wineId,wineName,wineYear,wineSort);
        message = wineService.addWine(wine);
    }

    @Then("Вижда съобщение : {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage,message);
    }
}
