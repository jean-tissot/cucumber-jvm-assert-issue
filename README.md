# Cucumber assert issue POC

The goal of this project is to reproduce a bug in cucumber java.

## Issue description

When the target type of a cucumber data table is parameterized, with java assertions enabled we get an assertion error
in [DataTableTypeRegistryTableConverter](https://github.com/cucumber/cucumber-jvm/blob/main/datatable/src/main/java/io/cucumber/datatable/DataTableTypeRegistryTableConverter.java#L94) (
at line 94) :

```java
assert javaType instanceof ListType;
```

With java assertion disabled, a `ClassCastException` occurs
in [DataTableTypeRegistryTableConverter](https://github.com/cucumber/cucumber-jvm/blob/main/datatable/src/main/java/io/cucumber/datatable/DataTableTypeRegistryTableConverter.java#L96) (
at line 96) :

```java
ListType listType = (ListType) javaType;
```

## Reproduce the issue

Launch the cucumber test (in [test.feature](src/test/resources/features/test.feature)) without java assertions (disabled
in [pom.xml](pom.xml) at line 75). For example, execute ``mvn test``.