package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.OrderDetails;

@Repository
public interface OrderDao extends CrudRepository<OrderDetails, Integer>{

	List<OrderDetails> findByUser_UserId(int userId);
}
