package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1); // 애초에 생성이 되지 않아 호출자체가 안됨
        }

        @Autowired
        public void setNoBean2(@Nullable Member NoBean2) {
            System.out.println("NoBean2 = " + NoBean2); // null반납
        }

        @Autowired
        public void setNoBean3(Optional<Member> NoBean3) {
            System.out.println("NoBean3 = " + NoBean3); // Optional.empty반납
        }
    }


}
