package org.carlspring.strongbox.testing.repository;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.carlspring.strongbox.artifact.coordinates.NullArtifactCoordinates;
import org.carlspring.strongbox.storage.repository.RepositoryPolicyEnum;
import org.carlspring.strongbox.testing.storage.repository.RepositorySetup;
import org.carlspring.strongbox.testing.storage.repository.TestRepository;
import org.springframework.core.annotation.AliasFor;

/**
 * @author sbespalov
 */
@Documented
@Retention(RUNTIME)
@Target({PARAMETER, ANNOTATION_TYPE})
@TestRepository(layout = NullArtifactCoordinates.LAYOUT_NAME)
public @interface NullRepository
{

    @AliasFor(annotation = TestRepository.class)
    String storage() default "storage0";

    @AliasFor(annotation = TestRepository.class)
    String repository() default "releases";

    @AliasFor(annotation = TestRepository.class)
    RepositoryPolicyEnum policy() default RepositoryPolicyEnum.RELEASE;

    @AliasFor(annotation = TestRepository.class)
    Class<? extends RepositorySetup>[] setup() default {};

    @AliasFor(annotation = TestRepository.class)
    boolean cleanup() default true;

}
