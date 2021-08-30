package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.ExistingUserAccount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ExistingUsersProvider {

    @DataProvider(name = "getExistingUsersDataFromJson")
    private Object[][] getExistingUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/testData/existingUsers.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<ExistingUserAccount> testData = new Gson().fromJson(dataSet, new TypeToken<List<ExistingUserAccount>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
