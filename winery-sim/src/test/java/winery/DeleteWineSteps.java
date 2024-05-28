package winery;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Wine;
import services.WineService;

import static org.junit.Assert.assertEquals;

public class DeleteWineSteps {
    private Integer id;
    private String name;
    private String message;

    @When("Потребителят натиска бутона изтрий")
    public void deleteWine() {
        final WineService wineService = new WineService();
        if(name == null && id!=null){
            message = wineService.deleteWineById(id);
        }
        if(id == null && name!=null){
            message = wineService.deleteWineByName(name);
        }
        if(id == null && name == null)
        {
            message = "Моля въведете име или идентификатор на виното!";
        }
    }

    @Given("Потребителят не въвежда име и id на вино")
    public void noInputs() {

    }

    @Given("Потребителят търси по id на вино: {int}")
    public void searchById(int id) {
        this.id = id;
    }

    @Given("Потребителят търси по име на вино: {string}")
    public void searchByName(String name) {
        this.name = name;
    }

    @Then("Вижда съобщение: {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage,message);
    }
}
