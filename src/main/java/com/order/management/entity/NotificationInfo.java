package com.order.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NOTIFICATION_INFO")
public class NotificationInfo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@Column(name="MESSAGE")
	@Size(min = 8, message = "Food must be minimum 10 Character String")
	private String message ;
	
	 //Default-Constructor
    protected NotificationInfo()
    {
    	
    }
	
	public NotificationInfo(@Size(min = 10, message = "Notification must be minimum 10 Character String") String message) {
		super();
		this.message = message;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotificationInfo [id=" + id + ", message=" + message + "]";
	}

}
