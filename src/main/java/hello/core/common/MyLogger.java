package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

        private String uuid;
        private String reqeustURL;

        public void setReqeustURL(String reqeustURL) {
            this.reqeustURL = reqeustURL;
        }

        public void log(String message) {
            System.out.println("[" + uuid + "]" + "[" + reqeustURL + "]" + message);
        }

        @PostConstruct
        public void init() {
            uuid = UUID.randomUUID().toString();
            System.out.println("[" + uuid + "] request scope beand create : " + this );
        }

        @PreDestroy
        public void close() {
            System.out.println("[" + uuid + "] request scope beand close : " + this );
        }

}
