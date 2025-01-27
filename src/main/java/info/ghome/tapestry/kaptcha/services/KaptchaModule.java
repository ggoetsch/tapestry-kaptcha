package info.ghome.tapestry.kaptcha.services;

import java.util.Properties;

import org.apache.tapestry5.commons.Configuration;
import org.apache.tapestry5.services.LibraryMapping;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.KaptchaConfig;

public class KaptchaModule {

	private KaptchaModule() {
		//
	}

	public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {
		configuration.add(new LibraryMapping("kaptcha", "info.ghome.tapestry.kaptcha"));
	}

	public static Producer buildProducer() {
		Properties p = new Properties();
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		defaultKaptcha.setKaptchaConfig(new KaptchaConfig(p));
		return defaultKaptcha;
	}
}
