package com.swagger.swagger.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
    
    @GetMapping
    public List<User> getUSers() {
        return Arrays.asList(
            new User("Peter", 2000L),
            new User("Sam", 1000L)
        );
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("UserName") final String userName) {
        return new User(userName, 1000L);
    }

    private class User {
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }

        private Long salary;

        public User(String userName, Long salary) {
            this.userName = userName;
            this.salary = salary;
        }
    }
}
