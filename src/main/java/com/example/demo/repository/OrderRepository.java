package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "select * from tbl_order where ship_address like %:shipAddress%", nativeQuery = true)
    List<Order> get1(@Param("shipAddress") String shipAddress);
	
	@Query(value = "select * from tbl_order where local_date = :localDate", nativeQuery = true)
	List<Order> get2(@Param("localDate") LocalDate localDate);
}
