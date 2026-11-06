package com.naresh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Vaccine;
import com.naresh.view.ResultView;
import com.naresh.views.View;
@Repository
public interface IvaccineRepo extends JpaRepository<Vaccine, Integer> {
	List<ResultView> findByCostLessThan(Double cost);
	<T extends View> List<T> findByCostGreaterThan(Double cost,Class<T> s);
}
