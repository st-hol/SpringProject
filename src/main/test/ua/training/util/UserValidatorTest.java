package ua.training.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import ua.training.entities.User;
import ua.training.repositories.UserRepository;
import ua.training.services.UserService;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserValidatorTest {

    @Autowired
    private UserValidator userValidator;

    @MockBean
    private UserService userService;


    @Test
    public void testValidationWithValidAddress() {

        UserValidator userValidator = new UserValidator();
        userValidator.setUserService(userService);//why it is not autowired.


        User validUser = new User();

        //everything to make it valid
        validUser.setPassword("123");
        validUser.setPasswordConfirm("123");
        validUser.setUsername("testusername");


//        Mockito.doReturn(null)
//                .when(userService)
//                .findByUsername("testusername");

        Mockito.when(userService.findByUsername("testusername"))
                .thenReturn(null);


        Errors errors = new BeanPropertyBindingResult(validUser, "validUser");
        userValidator.validate(validUser, errors);

        assertFalse(errors.hasErrors());
    }

//
//    @Test
//    public void testValidationWithEmptyFirstNameAddress() {
//        AdressValidator addressValidator = new AddressValidator();
//        CustomValidator validatorUnderTest = new CustomValidator(adressValidator);
//
//        Address validAddress = new Address();
//        invalidAddress.setFirstName("")
//        invalidAddress.set...everything to make it valid exept the first name
//
//        Errors errors = new BeanPropertyBindingResult(invalidAddress, "invalidAddress");
//        validatorUnderTest.validate(invalidAddress, errors);
//
//        assertTrue(errors.hasErrors());
//        assertNotNull(errors.getFieldError("firstName"));
//    }


//    @Test
//    public void addUserFailTest() {
//        User user = new User();
//
//        user.setUsername("John");
//
//        Mockito.doReturn(new User())
//                .when(userRepository)
//                .findByUsername("John");
//
//
//
//        Assert.assertFalse(isUserCreated);
//
//        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
//        Mockito.verify(mailSender, Mockito.times(0))
//                .send(
//                        ArgumentMatchers.anyString(),
//                        ArgumentMatchers.anyString(),
//                        ArgumentMatchers.anyString()
//                );
//    }
}