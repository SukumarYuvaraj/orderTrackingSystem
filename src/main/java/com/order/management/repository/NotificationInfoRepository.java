package com.order.management.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.order.management.entity.Notification;

@EnableJpaRepositories
public interface NotificationInfoRepository extends CrudRepository<Notification, Integer>{

}
