package com.codeverse.user.service;

import com.codeverse.user.controller.User;
import com.codeverse.user.repository.entity.PostEntity;
import com.codeverse.user.repository.entity.PostRepo;
import com.codeverse.user.repository.entity.UserEntity;
import com.codeverse.user.repository.entity.UserRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class UserService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private static final ObjectMapper OBJECT_MAPPER = ObjectMapperFactory.getInstancce();

    public void saveUser(User user){
            var userEntity = OBJECT_MAPPER.convertValue(user, UserEntity.class);
            userRepo.save(userEntity);
    }

    public List<User> userEntities(){
        return OBJECT_MAPPER.convertValue(userRepo.findAll(), new TypeReference<List<User>>() {
        });
    }

    @SneakyThrows
    public void savePost(MultipartFile multipartFile, Long id, String content) {

        var postEntity = new PostEntity()
                .setPostContent(content)
                .setUserEntity(new UserEntity().setId(id))
                .setFileName(multipartFile.getOriginalFilename())
                .setFileContent(multipartFile.getBytes());
        postRepo.save(postEntity);
    }

    public Pair<String, byte[]> getPostsForUser(Long id) {
        var postEntities = postRepo.findById(id);
        if(postEntities.isPresent()){
            var postEntity = postEntities.get();
            return Pair.of(postEntity.getPostContent(), postEntity.getFileContent());
        }
        log.info("no content found, sending empty data");
        return Pair.of("", new byte[]{});
    }

    public String forgotPassword(String emailId){
       List<UserEntity> userEntity =  userRepo.findByEmail(emailId);

       if(userEntity.size()>0){
           String token = RandomString.make(30);
           return token;
       }
        return null;
    }
}
