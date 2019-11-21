package ru.notes.rutodolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.notes.rutodolist.persist.entity.User;
import ru.notes.rutodolist.persist.repo.UserRepository;
import ru.notes.rutodolist.repr.UserRepr;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by user on 14.11.2019.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;//совпадает с название в мейн
    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRepr userRepr)
    {
        User user = new User();
        user.setUserName(userRepr.getUserName());
        user.setPswd(passwordEncoder.encode( userRepr.getPswd()));
        userRepository.save(user);
    }

    public Optional<Long> getCurrentUserId() {
       Optional<String> currentUser = getCurrentUser();
       if(currentUser.isPresent())
       {
           return userRepository.getUserByUserName(currentUser.get()).map(User::getId);
       }
       return Optional.empty();
    }

    public static Optional<String> getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken))
        {
            return Optional.of(authentication.getName());
        }
        return Optional.empty();
    }
}
