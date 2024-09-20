package hellospring.loginpage.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class UserRepository {
    private static long sequence = 0L;
    private static Map<Long, User> storage = new ConcurrentHashMap<>();

    public User saveUser(User user) {
        user.setId(++sequence);
        log.info("save: member={}", user);
        storage.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return storage.get(id);
    }

    public Optional<User> findByLoginId(String loginId) {
        List<User> users = findAll();  // 모든 유저 목록 가져오기
        for (User user : users) {
            if (user.getLoginId().equals(loginId)) {  // loginId가 일치하는지 확인
                return Optional.of(user);  // 일치하는 유저가 있으면 반환
            }
        }
        return Optional.empty();  // 없으면 빈 Optional 반환
    }

    public List<User> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void clearStore() {
        storage.clear();
    }
}
