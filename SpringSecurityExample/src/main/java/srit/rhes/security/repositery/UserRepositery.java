package srit.rhes.security.repositery;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import srit.rhes.security.model.User;
import srit.rhes.security.model.UserSession;

@Repository
public interface UserRepositery extends JpaRepository<User,Integer>{
	
    User findByUserName(String userName);
    @Query(value = "insert into user_session(jsessionCode) values(session)",nativeQuery = true)
	int save(UserSession session);
  
}
