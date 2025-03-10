package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.controller.StudentController;
import com.yaksha.assignment.utils.JavaParserUtils;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetStudent() throws Exception {
		// Perform GET request to /student endpoint and capture the response
		String response = mockMvc.perform(get("/student").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		// Assert using YakshaAssert that the response contains expected values
		boolean result = response.contains("\"name\":\"John Doe\"") && response.contains("\"age\":20")
				&& response.contains("\"course\":\"Computer Science\"");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testRestControllerAnnotation() throws Exception {
		// Specify the file path to the StudentController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/StudentController.java"; // Update path to
																									// your
		// controller

		// Check if the class is annotated with @RestController
		boolean result = JavaParserUtils.checkClassAnnotation(filePath, "RestController");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetMappingOnGetStudent() throws Exception {
		// Specify the file path to the StudentController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/StudentController.java"; // Update path to
																									// your
		// controller

		// Check if the getStudent method has @GetMapping("/student") annotation
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getStudent", // Method name
				"GetMapping"); // Method annotation

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testReturnTypeOfGetStudent() throws Exception {
		// Specify the file path to the StudentController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/StudentController.java"; // Update path to
																									// your
		// controller

		// Check if the getStudent method has the correct return type (Student)
		boolean result = JavaParserUtils.checkMethodReturnType(filePath, "getStudent", // Method name
				"Student"); // Expected return type

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}
}
