package hello.core.anootation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// Qualifier Annotation 복사함
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
