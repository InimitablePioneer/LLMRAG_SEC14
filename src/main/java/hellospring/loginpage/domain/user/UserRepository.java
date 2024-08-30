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
    public User save(User user) {
        user.setId(++sequence);
        log.info("save: member={}", user);
        storage.put(user.getId(), user);
        return user;
    }
    public User findById(Long id) {
        return storage.get(id);
    }
    public Optional<User> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }
    public List<User> findAll() {
        return new ArrayList<>(storage.values());
    }
    public void clearStore() {
        storage.clear();
    }
}
