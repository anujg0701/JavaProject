package code.dailycodebuffer.departmentservice.Service;

import code.dailycodebuffer.departmentservice.Entity.departmentEntity;
import code.dailycodebuffer.departmentservice.Repository.departmentRepository;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import org.apache.catalina.authenticator.BasicAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class departmentService {

    @Autowired
    private departmentRepository departmentRepository;

    public departmentEntity GetDepartment(Long id) {
        return departmentRepository.findByDepartmentID(id);
    }

    public departmentEntity SaveDepartment(departmentEntity dept) {
        SendEmail();
        return departmentRepository.save(dept);
    }

    public boolean SendEmail() {
        try {
            String accessKey = "AKIAUDM4VX2QPVIMK4YM";
            String secretKey = "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";

            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(Regions.US_EAST_2).build();

            final String bodyText = "<h2>SES Test Email</h2>";
            final String Subject = "TEST";

            Body body = new Body();
            body.withHtml(new Content().withCharset("UTF-8").withData(bodyText));

            Message msg = new Message();
            msg.withBody(body)
               .withSubject(new Content().withCharset("UTF-8").withData(Subject));

            SendEmailRequest request = new SendEmailRequest()
               .withDestination(new Destination().withToAddresses("anujg0701@gmail.com"))
               .withMessage(msg)
               .withSource("anuj.gupta@iongroup.com");

            client.sendEmail(request);
            return true;
        }
        catch (Exception ex){
            System.out.println("The email was not sent." + ex.getMessage());
            return false;
        }
    }
}
