package com.hackerrank.WheatherApi.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hackerrank.WheatherApi.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather,Long>{

	@Query("DELETE FROM Weather WHERE dater >= ?1 AND dater<=?2")
	public void deleteByDater(LocalDate fromDate,LocalDate toDate);
	
	@Query("SELECT w FROM Weather w WHERE w.dater >= ?1 AND w.dater<=?2")
	public List<Weather> findByDater(LocalDate fromDate,LocalDate toDate);
}
