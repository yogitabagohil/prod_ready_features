package com.week4.prod_ready_features.prod_ready_features;

import com.week4.prod_ready_features.prod_ready_features.client.EmployeeClient;
import com.week4.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllEmployees(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println((employeeDTOList));
	}

	@Test
	@Order(2)
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "yogi", "yogi@gmail.com", 31, "USER", 5000.0, LocalDate.of(2020,12,1),true);
		EmployeeDTO saveEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
	}

}
