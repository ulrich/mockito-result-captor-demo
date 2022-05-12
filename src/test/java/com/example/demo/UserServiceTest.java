package com.example.demo;

import com.example.demo.utils.ResultCaptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;

@SpringBootTest
class UserServiceTest {

    @SpyBean
    private UserRepository userRepositorySpy;

    @Autowired
    private UserService userService;

    private final ResultCaptor<User> userResultCaptor = new ResultCaptor<>();

    @Test
    void should_test_result_captor() {
        // Given
        doAnswer(userResultCaptor).when(userRepositorySpy).getUserById("1");

        // When
        userService.updateUser("1");

        // Then
        var userResultCaptorResult = userResultCaptor.getResult();

        assertThat(userResultCaptorResult).isNotNull();
        assertThat(userResultCaptorResult.id()).isEqualTo("1");
        assertThat(userResultCaptorResult.name()).isEqualTo("Ulrich");
    }
}