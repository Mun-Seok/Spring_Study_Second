package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrototypeTest {

    // bean1과 2 다름, destroy 호출 안됨
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println("find prototypeBean1");
        ProtoTypeBean prototypeBean1 = ac.getBean(ProtoTypeBean.class);
        System.out.println("find prototypeBean2");
        ProtoTypeBean prototypeBean2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        // 필요하면 직접 호출해야함
        prototypeBean1.destroy();
        prototypeBean2.destroy();

        ac.close();
    }

    @Scope("prototype")
    static class ProtoTypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("PrototypeBean.init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PrototypeBean.destroy");
    }
}
