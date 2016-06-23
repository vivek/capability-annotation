package io.jenkins.blueocean.rest.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * {@link Capability} annotation should be used by plugins to declare it's capability
 *
 * For example:
 * <pre>
 * pacakge io.jenkins.example.test;
 * {@code @Capability("io.jenkins.example.test.ExampleTestReporter")}
 * public class MyTestReporterAction extends AbstractTestResultAction {
 *  ...
 * }
 * </pre>
 * <pre>
 * BlueOcean API would report this capability when queried using it's classes API as:
 *
 * GET /rest/classes/io.jenkins.example.test.MyTestReporter
 *
 * {
 *     "classes":["io.jenkins.example.test.MyTestReporter", "io.jenkins.example.test.ExampleTestReporter", "hudson.tasks.test.AbstractTestResultAction"]
 * }
 *
 * </pre>
 * @author Vivek Pandey
 */
@Retention(RUNTIME)
@Target({TYPE})
@Inherited
public @interface Capability {

    /**
     * Capability value must be a namespace qualified value. Typically you would use the package name of the class where
     * this annotation is declared as namespace qualifier.
     *
     * @return value of this annotation
     */
    String value();
}
