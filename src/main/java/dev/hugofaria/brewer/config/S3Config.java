package dev.hugofaria.brewer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


//@Configuration
@PropertySource(value = { "file://${USERPROFILE}/.brewer-s3.properties" }, ignoreResourceNotFound = true)
public class S3Config {
//
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public AmazonS3 amazonS3() {
//		AWSCredentials credenciais = new BasicAWSCredentials("AKIAUUOZGUZIL3A2TH7G", "fuXKN41Uma1P1p0jOmxq4KehbXiDcZJZmh2Xi/JG");
//		AmazonS3 amazonS3 = new AmazonS3Client(credenciais, new ClientConfiguration());
//		Region regiao = Region.getRegion(Regions.SA_EAST_1);
//		amazonS3.setRegion(regiao);
//		return amazonS3;
//	}
}