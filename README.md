# Cucumber assert issue POC

The goal of this project is to reproduce a bug in cucumber java.

## Issue description

When the target type of a cucumber data table is parameterized, a java assertion fails in [DataTableTypeRegistryTableConverter](https://github.com/cucumber/cucumber-jvm/blob/main/datatable/src/main/java/io/cucumber/datatable/DataTableTypeRegistryTableConverter.java#L109) (at line 109) :
```java
assert listElementType instanceof OtherType || listElementType instanceof OptionalType;
```

## Reproduce the issue

Launch the cucumber test (in [test.feature](src/test/resources/features/test.feature)) with java assertions activated. For example, execute ``mvn test``.

NB: if you launch the test using a cucumber launcher in Intellij Idea, the java assertions are enabled, so you can't reproduce the issue this way.

## Workaround

Disable the java assertions in maven-plugin-surefire. See [pom.xml](pom.xml) (line 75)