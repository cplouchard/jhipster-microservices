package org.jhipster.store;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.jhipster.store");

        noClasses()
            .that()
                .resideInAnyPackage("org.jhipster.store.service..")
            .or()
                .resideInAnyPackage("org.jhipster.store.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..org.jhipster.store.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
