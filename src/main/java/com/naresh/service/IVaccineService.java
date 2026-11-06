package com.naresh.service;

import java.util.List;

import com.naresh.model.Vaccine;
import com.naresh.view.ResultView;
import com.naresh.views.View;

public interface IVaccineService {
	public List<ResultView> fetchByCost(Double cost);
	public <T extends View> List<T> fetchByCostGreaterThan(Double cost,Class<T> s);
}
