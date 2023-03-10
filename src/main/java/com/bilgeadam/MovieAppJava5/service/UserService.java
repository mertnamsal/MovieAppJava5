package com.bilgeadam.MovieAppJava5.service;

import com.bilgeadam.MovieAppJava5.dto.request.UserRegisterRequestDto;
import com.bilgeadam.MovieAppJava5.dto.response.UserRegisterResponseDto;
import com.bilgeadam.MovieAppJava5.repository.IMovieRepository;
import com.bilgeadam.MovieAppJava5.repository.IUserRepository;
import com.bilgeadam.MovieAppJava5.repository.entity.User;
import com.bilgeadam.MovieAppJava5.repository.entity.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(String name, String surname, String email, String phone, String password, String userType) {
        UserType userType1=null;
        User user;
       try {
           userType1=UserType.valueOf(userType);
           user= User.builder()
                   .name(name)
                   .surName(surname)
                   .email(email)
                   .phone(phone)
                   .userType(userType1)
                   .password(password)
                   .build();
       }catch (Exception e){
           System.out.println("Boyle bir Kullanıcı turu bulunmamaktadır");
           user= User.builder()
                   .name(name)
                   .surName(surname)
                   .email(email)
                   .phone(phone)
                   .password(password)
                   .build();
       }


       return  userRepository.save(user);

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveAll(List<User> users) {

        userRepository.saveAll(users);


    }

    public  List<User> findAllByOrderByName(){

        return userRepository.findAllByOrderByName();
    }

    public List<User> findAllByNameLike(String name){

        return userRepository.findAllByNameLike(name);
    }

   public List<User> findAllByEmailContainingIgnoreCase(String value){
        return  userRepository.findAllByEmailContainingIgnoreCase(value);
    }

   public List<User> findAllByEmailEndingWith(String value){

        return userRepository.findAllByEmailEndingWith(value);
    }

    public Boolean existsByEmailAndPassword(String email,String password){

        return userRepository.existsByEmailAndPassword(email,password);
    }

    public User findOptionalByEmailAndPassword(String email, String password) throws Exception {

        Optional<User> user=userRepository.findOptionalByEmailAndPassword(email,password);

        if (user.isPresent()){
            return user.get();
        }else{
            throw new Exception("Kullan�c� Bulunamad�");
        }

    }

    public   List<User> passwordLongerThan(int length){

        return userRepository.passwordLongerThan(length);
    }

    public     List<User> passwordControl( int length){

        return  userRepository.passwordControl(length);
    }

    public Optional<User> findById(Long id) {

        return  userRepository.findById(id);
    }
    public UserRegisterResponseDto createUser(UserRegisterRequestDto dto){
        User user = User.builder()
                .name(dto.getName())
                .surName(dto.getSurName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        User reUser = userRepository.save(user);
        return UserRegisterResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surName(user.getSurName())
                .userType(user.getUserType())
                .email(user.getEmail())
                .build();
    }
}
