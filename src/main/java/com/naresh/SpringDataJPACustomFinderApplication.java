package com.naresh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.naresh.service.VaccineService;
//import com.naresh.views.ResultView1;
import com.naresh.views.ResultView2;

@SpringBootApplication
public class SpringDataJPACustomFinderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cont = SpringApplication.run(SpringDataJPACustomFinderApplication.class, args);
		VaccineService vaccineService=cont.getBean(VaccineService.class);
		
		//vaccineService.fetchByCost(1500.2).forEach(v->System.out.println(v.getVaccineCompany()+"  "+v.getVaccineName()));
		vaccineService.fetchByCostGreaterThan(1500.3, ResultView2.class).forEach(v->System.out.println(v.getVaccineName()+" "+v.getCost()));
		
	}

}
