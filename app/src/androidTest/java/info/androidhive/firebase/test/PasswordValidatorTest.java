package info.androidhive.firebase.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Tania on 30/05/2017.
 */

public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeClass
    public void initData(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    public Object[][] ValidPasswordProvider() {
        return new Object[][]{
                {new String[] {
                        "mkyong1A@", "mkYOn12$",
                }}
        };
    }

    @Test
    public Object[][] InvalidPasswordProvider() {
        return new Object[][]{
                {new String[] {
                        "mY1A@","mkyong12@","mkyoNg12*",
                        "mkyonG$$","MKYONG12$"
                }}
        };
    }

    @Test //(dataProvider = "ValidPasswordProvider")
    public void ValidPasswordTest(String[] password) {

        for(String temp : password){
            boolean valid = passwordValidator.validate(temp);
            System.out.println("Password is valid : " + temp + " , " + valid);
            Assert.assertEquals(true, valid);
        }

    }

    @Test //(dataProvider = "InvalidPasswordProvider",
            //dependsOnMethods="ValidPasswordTest")
    public void InValidPasswordTest(String[] password) {

        for(String temp : password){
            boolean valid = passwordValidator.validate(temp);
            System.out.println("Password is valid : " + temp + " , " + valid);
            Assert.assertEquals(false, valid);
        }
    }
}
