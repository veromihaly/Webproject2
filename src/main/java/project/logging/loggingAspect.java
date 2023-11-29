package project.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*@Aspect
@Configuration*/
public class loggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(loggingAspect.class);

    @Before("execution(* com.jsfspring.curddemo.*..*(..)) && args(..)")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("Invoked: " + joinPoint.getSignature().getName() + " ()");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.jsfspring.curddemo.*..*(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.info("Exit: " + joinPoint.getSignature().getName() + " ()");
    }

}
