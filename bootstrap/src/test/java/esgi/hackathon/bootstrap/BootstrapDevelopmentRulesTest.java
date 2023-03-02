package esgi.hackathon.bootstrap;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.junit.CacheMode.FOREVER;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static esgi.hackathon.bootstrap.PackagesAndLayers.BOOTSTRAP_PACKAGE;

@AnalyzeClasses(
    packages = "esgi.hackathon.bootstrap",
    cacheMode = FOREVER,
    importOptions = {DoNotIncludeTests.class})
public class BootstrapDevelopmentRulesTest {

  @ArchTest
  public static final ArchRule BOOTSTRAP_DEVELOPMENT_RULE =
      classes()
          .that()
          .resideInAPackage(BOOTSTRAP_PACKAGE)
          .should()
          .onlyBeAccessed()
          .byClassesThat()
          .resideInAPackage(BOOTSTRAP_PACKAGE);
}
