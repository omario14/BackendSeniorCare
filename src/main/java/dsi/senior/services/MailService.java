package dsi.senior.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import request.MailRequest;
import request.MailResponse;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class MailService {

	
	 @Autowired
	    private JavaMailSender mailSender;

	 @Autowired
	    private Configuration configuration;
	 
	 public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
			MailResponse response = new MailResponse();
			MimeMessage message = mailSender.createMimeMessage();
			try {
				// set mediaType
				MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
						StandardCharsets.UTF_8.name());
				// add attachment
				helper.addAttachment("logow.png", new ClassPathResource("logow.png"));

				Template t = configuration.getTemplate("email-template.ftl");
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

				helper.setTo(request.getTo());
				helper.setText(html, true);
				helper.setSubject(request.getSubject());
				helper.setFrom(request.getFrom());
				mailSender.send(message);

				response.setMessage("mail send to : " + request.getTo());
				response.setStatus(Boolean.TRUE);

			} catch (MessagingException | IOException | TemplateException e) {
				response.setMessage("Mail Sending failure : "+e.getMessage());
				response.setStatus(Boolean.FALSE);
			}

			return response;
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  

	    
	}