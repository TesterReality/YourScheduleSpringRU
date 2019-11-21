package ru.notes.rutodolist.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.notes.rutodolist.persist.entity.User;
import ru.notes.rutodolist.persist.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by user on 14.11.2019.
 */
@Service
@Transactional
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      Optional<User> optUser= userRepository.getUserByUserName(userName);
      if(!optUser.isPresent())//если не существует
      {
          throw new UsernameNotFoundException("Пользователь с таким логином не зарегистрирован");
      }
        return new org.springframework.security.core.userdetails.User(optUser.get().getUserName(),optUser.get().getPswd(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
