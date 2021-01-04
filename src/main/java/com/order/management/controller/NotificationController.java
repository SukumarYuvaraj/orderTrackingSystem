package com.order.management.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	
	public static List<Notification> retrieveNotificationforReport(){

		logger.info("To fetch all notifications in the system");
		List<Notification> collectionValues =  new ArrayList<Notification>();
		collectionValues.add(new Notification(1, "Yuvaraj developing OrderTracking System"));
		collectionValues.add(new Notification(2, "Purushoth developing OrderTracking System"));
		collectionValues.add(new Notification(3, "Madhavan developing OrderTracking System"));
		collectionValues.add(new Notification(4, "RaviPolina developing OrderTracking System"));
		collectionValues.add(new Notification(5, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(6, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(7, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(8, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(9, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(10, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(1, "Yuvaraj developing OrderTracking System"));
		collectionValues.add(new Notification(2, "Purushoth developing OrderTracking System"));
		collectionValues.add(new Notification(3, "Madhavan developing OrderTracking System"));
		collectionValues.add(new Notification(4, "RaviPolina developing OrderTracking System"));
		collectionValues.add(new Notification(5, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(6, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(7, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(8, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(9, "Lavanya testing OrderTracking System"));
		collectionValues.add(new Notification(10, "Lavanya testing OrderTracking System"));
		return collectionValues;
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
	
	
	@GetMapping(path="/notifications/export/jasper/pdf")
	public void exportToJasperPDF(HttpServletResponse response) throws JRException, IOException
	{
	//	response.setContentType("application/json");
	//	response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat(ApplicationConstants.YYYY_MM_DD);
        String currentDateTime = dateFormatter.format(new Date());
        
        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream(ApplicationConstants.NOTIFICATIONS+ApplicationConstants.FILE_NAME_JRXML);
        
     // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Notifications_" + currentDateTime + ApplicationConstants.FILE_NAME_PDF;
   //    response.setHeader(headerKey, headerValue);
        
        final List<Notification> notificationList = service.findAllNotifications();
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(notificationList);
        System.out.println("Source Object is: "+source);
        System.out.println("Overall Records Count is :"+source.getRecordCount());
        
        final JasperPrint print = JasperFillManager.fillReport(report, null, source);
        System.out.println("Print Object is: "+print);
        
        final String filePath = "D:\\Yuvaraj\\OrderManagement_InHouse\\";
        // Export the report to a PDF file.
        JasperExportManager.exportReportToPdfFile(print, filePath+"Notifications_" + currentDateTime + ApplicationConstants.FILE_NAME_PDF);
        byte[] outputArray = JasperExportManager.exportReportToPdf(print);
        
        FileOutputStream fos = new FileOutputStream("D:\\Yuvaraj\\OrderManagement_InHouse\\NotificationReport.pdf");
        fos.write(outputArray);
        fos.flush();
        fos.close();
        
        System.out.println("OutputArray :"+outputArray);
        System.out.println("Pdf generation Completed");
		
	}
	
}
