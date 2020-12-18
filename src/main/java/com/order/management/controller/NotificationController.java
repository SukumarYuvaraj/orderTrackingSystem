package com.order.management.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entity.Notification;
import com.order.management.mapper.MapperUtils;
import com.order.management.reports.NotificationPDFExporter;
import com.order.management.service.NotificationService;
import com.order.management.utils.ApplicationConstants;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;


@RestController
@RequestMapping(path= ApplicationConstants.BASE_CONTEXT)
public class NotificationController {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	@Qualifier(value="notificationService")
	private NotificationService service;
	
	@GetMapping(path="/fetchNotifications")
	public List<Notification> retrieveNotifications(){
		logger.info("To fetch all notifications in the system");
		return service.findAllNotifications();
	}
	
	@GetMapping(path="/fetchNotifications/{id}")
	public Optional<Notification> retrieveNotificationById(@PathVariable Integer id){
		logger.info("To fetch specific notification in the system for the given Id: "+id);
		return service.findNotificationById(id);
	}
	
	
	@PostMapping(path="/saveNotification")
	public void saveNotifications(@RequestBody String message)
	{
		logger.info("To save new notification in to the system");
		try
		{
		service.saveNotifications(MapperUtils.convertNotification(message));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@PostMapping(path="/removeNotification")
	public void removeNotification(@RequestBody String message){
		logger.info("To remove the notification in the system");
		try
		{
		service.removeNotification((MapperUtils.convertNotification(message).getId()));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@GetMapping(path="/notifications/export/csv")
	public void exportToCSV(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat(ApplicationConstants.YYYY_MM_DD);
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Notifications_" + currentDateTime + ApplicationConstants.FILE_NAME_CSV;
        response.setHeader(headerKey, headerValue);
        
        List<Notification> notificationList = service.findAllNotifications();
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"ID", "Message"};
        String[] nameMapping = {"id", "message"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Notification notification : notificationList) {
            csvWriter.write(notification, nameMapping);
        }
         
        csvWriter.close();
		
	}
	
	@GetMapping(path="/notifications/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws IOException
	{
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat(ApplicationConstants.YYYY_MM_DD);
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Notifications_" + currentDateTime + ApplicationConstants.FILE_NAME_PDF;
        response.setHeader(headerKey, headerValue);
        
        List<Notification> notificationList = service.findAllNotifications();
        
       NotificationPDFExporter exporter = new NotificationPDFExporter(notificationList);
       exporter.export(response);
		
	}
	
}
