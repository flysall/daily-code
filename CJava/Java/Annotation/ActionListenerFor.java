package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface ActionListenerFor {
	Class<? extends ActionListener> listener();
}
