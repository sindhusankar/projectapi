package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@SpringBootTest

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue="com.example.project.stepDefinitions",tags="@UserCatalog")
     public class ProjectApplicationTest {

	@Test
	void contextLoads() {
	}

}
