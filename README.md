
1) Default Security Setup
   ----------------------
by default, the Authentication gets enabled for the Application. Also, content negotiation is used to determine if basic or formLogin should be used.

There are some predefined properties, such as:

	spring.security.user.name
	spring.security.user.password

If we don't configure the password using the predefined property spring.security.user.password and start the application, we'll notice that a default password is randomly generated and printed in the console log:

	Using default security password: c8be15de-4488-4490-9dc6-fab3f91435c6
	
2) Disabling the Auto-Configuration
   --------------------------------
   To discard the security auto-configuration and add our own configuration, we need to exclude the SecurityAutoConfiguration class.

This can be done via a simple exclusion:

	@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
	public class SpringBootSecurityApplication {
	 
	    public static void main(String[] args) {
	        SpringApplication.run(SpringBootSecurityApplication.class, args);
	    }
	}

Or by adding some configuration into the application.properties file:

	spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
	There are also some particular cases in which this setup isn't quite enough.

For example, almost each Spring Boot application is started with Actuator in the classpath. This causes problems because another auto-configuration class needs the one we've just excluded, so the application will fail to start.

In order to fix this issue, we need to exclude that class; and, specific to the Actuator situation, we need to exclude ManagementWebSecurityAutoConfiguration.
																													   --------------------------------------

application.properties file refernces
-------------------------------------
https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
