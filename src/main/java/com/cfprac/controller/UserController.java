package com.cfprac.controller;

import com.cfprac.model.User;
import com.cfprac.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//@Hidden at the controller class level will hide all the endpoints of the controller class
//@Hidden
@Slf4j
@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@Hidden can be used to hide an endpoint in the api documentation
    @Hidden
    //By default, endpoints are grouped by controllers in the generated API doc. @Tag can be used at the method or class(Controller) level to group related APIs together.
    //APIs are categorized according to @Tag on the endpoints.
    @Tag(name="User Read API", description = "API to add, update, delete and find user")
    //@Operation can be used to define API summary and description
    @Operation(summary = "Find a user by id", description = "This API can be used to find a user by ID")
    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    // @ApiResponse defines the documentation of API response. For each response, there is content (@Content) which contains examples (@ExampleObject). This example documents
    // 2 example values for response code 200.
    @ApiResponse(responseCode = "200", description = "User Response",
            content = {
                @Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class),
                        examples = {
                            @ExampleObject(name = "User1 Example", value = "{\"id\": \"1\",\"name\":\"Alex\",\"dob\":\"19800101\"}"),
                                @ExampleObject(name = "User2 Example", value = "{\"id\": \"2\",\"name\":\"Claire\",\"dob\":\"19820401\"}")
                        }
                )
            }
    )
    @Operation(summary = "Find a user by dob", description = "This API can be used to find a user by their date of birth")
    @GetMapping("/findUserByDob/{dob}")
    //@Parameter allows you to explain the usage of input parameters
    @Parameters({@Parameter(name="dob", example = "YYYYMMDD")})
    public ResponseEntity<User> findUserByDob(@RequestParam("dob") LocalDate dob){
        User user = userService.findUserByDob(dob);
        return ResponseEntity.ok().body(user);
    }

    @Tag(name="User Update API", description = "API to add, update, delete and find user")
    @PostMapping("/saveNewUser")
    public ResponseEntity<User> saveNewUser(@RequestBody User user){
        log.info("Saving user {}", user);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok().body(savedUser);
    }


    @Tag(name="User Update API", description = "API to add, update, delete and find user")
    @PutMapping("/deleteUser/{id}")
    public ResponseEntity<Void> saveNewUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

}
