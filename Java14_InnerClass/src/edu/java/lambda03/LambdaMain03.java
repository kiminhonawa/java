package edu.java.lambda03;

import java.util.Arrays;
import java.util.List;

public class LambdaMain03 {

	public static void main(String[] args) {
		//Employee를 원소로 갖는 리스트를 생성
		List<Employee> employees = Arrays.asList(
				new Employee(100, "김인호", "개발1팀", "대리", 400.0),
				new Employee(101, "1번", "개발2팀", "사원", 350.0),
				new Employee(102, "2번", "개발2팀", "과장", 380.0),
				new Employee(103, "3번", "개발1팀", "부장", 500.0),
				new Employee(104, "4번", "인사팀", "사원", 300.0),
				new Employee(105, "5번", "인사팀", "과장", 1000.0)
				);

		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		
//		for (Employee employee : employees) {
//			System.out.println(employee.toString());
//		}
		employees.forEach(x -> System.out.println(x));
		
		// 2. 개발1,2팀에서 일하는 직원들의 급여의 합계를 출력.
		// 3. 개발1,2팀에서 일하는 직원들의 급여의 평균을 출력.
		double test = employees.stream().filter(x -> x.getDept().startsWith("개발")).mapToDouble(x -> x.getSalary()).sum();
		System.out.println("개발팀 월급 총액:" + test);
		System.out.println("개발팀 월급 평균:" + test/4);
		
//		double totalSalary = 0.0;
//		double avgSalary = 0.0;
//		for (Employee e : employees) {
//			if (e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀")) {
//				totalSalary += e.getSalary();
//				avgSalary = totalSalary/4;
//			}
//		}
//		System.out.println("개발팀 월급 총액:" + totalSalary);
//		System.out.println("개발팀 월급 평균:" + avgSalary);
	
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력.
		// 5. 직급이 사원인 직원들의 급여의 평균를 출력.
		double sum = 0.0;
		double avg = 0.0;
		for (Employee e : employees) {
			if (e.getEmpTitle().equals("사원")) {
				sum += e.getSalary();
				avg = sum/2;
			}
		}
		System.out.println("사원 월급 총액:" + sum);
		System.out.println("사원 월급 평균:" + avg);
		
		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
		
//		for (Employee e : employees) {
//			if (e.getSalary() >= 400) {
//				System.out.println(e);
//			}
//		}
		
		employees.stream().filter(e -> e.getSalary() >= 400).forEach(e -> System.out.println(e));
		
		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력.
		
		double totalSalary1 = 0.0;
		int count = 0;
		for (Employee e : employees) {
			if (e.getDept().equals("개발1팀")) {
			double increaseSalary = e.getSalary() * 1.1;
			e.setSalary(increaseSalary);
			totalSalary1 += e.getSalary();
			count ++;
			}
		}
		double avgSalary2 = totalSalary1/2;
		System.out.println("인상된 개발1팀 월급 평균:" + avgSalary2);
		
		// 8. 직원 리스트에서 "사원"은 몇 명?
//		int count2 = 0;
//		for (Employee e : employees) {
//			if (e.getEmpTitle().equals("사원")) {
//				count2 ++;
//			}
//		}
//		System.out.println("사원의 수:" + count2);

		long cnt = employees.stream().filter(e -> e.getEmpTitle().equals("사원")).count();
		System.out.println("사원 직급 수 = " + cnt);
		
		
		
		
		
		
		
		
		
	}

}
