package htht.system.ocean.service.impl;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CachePut {

    /**
     * Alias for {@link #cacheNames}.
     */
    @AliasFor("cacheNames")
    String[] value() default {};


}