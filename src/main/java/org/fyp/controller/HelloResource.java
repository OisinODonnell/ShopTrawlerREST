package org.fyp.controller;

 import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    // @EnableGlobalMethodSecurity is need in SSConfig in order for this to work
    @PreAuthorize("hasAnyRole('Administrator')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }
}
