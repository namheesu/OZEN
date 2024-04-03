package kr.or.ddit.spring.conf;

import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.encryption.pbe.config.StringPBEConfig;
import org.jasypt.spring31.xml.encryption.EncryptablePropertiesFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class JasyptEncryptConfig {
	
	@Bean
	public StringPBEConfig environmentVariablesConfiguration() {
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setPassword("java");
		return config;
	}
	
	@Bean
	public PBEStringEncryptor configurationEncryptor(StringPBEConfig config) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setConfig(config);
		return encryptor;
	}
	
	@Bean("dbInfo")
	public EncryptablePropertiesFactoryBean dbinfo(
		@Value("classpath:kr/or/ddit/db/dbInfo.properties") Resource location
		, PBEStringEncryptor configurationEncryptor
	) {
		EncryptablePropertiesFactoryBean dbinfo = new EncryptablePropertiesFactoryBean();
		dbinfo.setLocation(location);
		dbinfo.setEncryptor(configurationEncryptor);
		return dbinfo;
	}
}
