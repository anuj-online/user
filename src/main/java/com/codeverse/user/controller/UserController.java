package com.codeverse.user.controller;

import com.codeverse.user.repository.entity.UserEntity;
import com.codeverse.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private PasswordEncoder encoder;


    @PostMapping
    public void register(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping
    public List<User> userEntities(){
        return userService.userEntities();
    }

   @RequestMapping(value="/post", method = RequestMethod.POST, consumes = "multipart/form-data")
    public void sharePost(@RequestParam UserContent userContent){
       userService.savePost(userContent.getFile(), userContent.getId(), userContent.getContent());
   }

   @GetMapping("/posts")
    public ResponseEntity<Resource> getPostsForUser(@PathVariable("id") Long id){
        Pair<String, byte[]> postsForUser = userService.getPostsForUser(id);
        return ResponseEntity.ok()
               .contentLength(postsForUser.getSecond().length)
              .contentType(MediaType.parseMediaType("application/octet-stream"))
               .body(new ByteArrayResource(postsForUser.getSecond()));
   }
    @GetMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@PathVariable("emailId") String emailId){
        String postsForUser = userService.forgotPassword(emailId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/json"))
                .body(postsForUser);
    }
    /**
     * Any user can access this API - No Authentication required
     * @param student
     * @return
     */

    @PostMapping("/register")
    public UserEntity registerStudent(@RequestBody UserEntity student) {
        UserEntity student1 = new UserEntity();

        student1.setPassword(encoder.encode(student.getPassword()));
        student1.setSrole(student.getSrole());
        return userService.register(student1);
    }
    /**
     * User who has logged in successfully can access this API
     * @param username
     * @return
     */
    @GetMapping("/studentInfo")
    public UserEntity getStudentInfo(@RequestParam("sname") String username) {
        return userService.getDetails(username);
    }

    /**
     * User who has the role ROLE_WRITE can only access this API
     * @param username
     * @return
     */
    @GetMapping("/getStudentRoles")
    public String getStudentRoles(@RequestParam("sname") String username) {
        return userService.getStudentRoles(username);
    }

}
