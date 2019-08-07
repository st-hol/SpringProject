package ua.training.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ua.training.entities.User;
import ua.training.repositories.UserRepository;
import ua.training.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private final List<User> users = new ArrayList<>();

    @Before
    public void initUsers() {
        User user = new User();
        user.setId(1L);
        user.setUsername("admin@g.c");
        users.add(user);
    }

    @Test
    public void Given_User_When_TryingToRegister_Then_ShouldAddUserToList() {
        User user = new User();
        user.setPassword("11");
        user.setUsername("sometest@mail.ru");

        Mockito.doAnswer(invocation -> {
            User u = invocation.getArgument(0);
            users.add(u);
            return u;
        }).when(userRepository).save(ArgumentMatchers.any(User.class));

        userService.registerUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);

        Assert.assertTrue(users.contains(user));
    }

}