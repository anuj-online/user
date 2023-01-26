package com.codeverse.user.controller;

import com.codeverse.user.repository.entity.UserEntity;
import com.codeverse.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @PostMapping
    public void register(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping
    public List<User> userEntities(){
        return userService.userEntities();
    }

//    @RequestMapping(value="/post", method = RequestMethod.POST, consumes = "multipart/form-data")
//    public void sharePost(@RequestParam UserContent userContent){
//        userService.savePost(userContent.getFile(), userContent.getId(), userContent.getContent());
//    }

//    @GetMapping("/posts")
//    public ResponseEntity<Resource> getPostsForUser(@PathVariable("id") Long id){
////        return userService.getPostsForUser(id);
//        Pair<String, byte[]> postsForUser = userService.getPostsForUser(id);
//        return ResponseEntity.ok()
//                .contentLength(postsForUser.getSecond().length)
//                .contentType(MediaType.parseMediaType("application/octet-stream"))
//                .body(new ByteArrayResource(postsForUser.getSecond()));
//    }

}
