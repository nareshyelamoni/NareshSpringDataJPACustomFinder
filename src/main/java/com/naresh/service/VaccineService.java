package com.naresh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.model.Vaccine;
import com.naresh.repo.IvaccineRepo;
import com.naresh.view.ResultView;
import com.naresh.views.View;
@Service
public class VaccineService implements IVaccineService {
	
	private IvaccineRepo repo;
	
	@Autowired
	public void setRepo(IvaccineRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<ResultView> fetchByCost(Double cost) {
		return repo.findByCostLessThan(cost);
	}

	@Override
	public <T extends View> List<T> fetchByCostGreaterThan(Double cost, Class<T> s) {
		return repo.findByCostGreaterThan(cost, s);
	}

	

	

}
