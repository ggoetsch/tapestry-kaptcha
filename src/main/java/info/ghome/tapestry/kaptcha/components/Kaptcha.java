package info.ghome.tapestry.kaptcha.components;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import com.google.code.kaptcha.Producer;

public class Kaptcha {

	@Inject
	private Producer producer;

	@Persist(PersistenceConstants.FLASH)
	private String text;

	@Inject
	private ComponentResources componentResources;

	@Inject
	private AjaxResponseRenderer renderer;

	@Component
	private Zone kaptchaZone;

	void setupRender() {
		text = producer.createText();
	}

	void onRefresh() {
		text = producer.createText();
		renderer.addRender(kaptchaZone);
	}

	public String getKaptchaImage() throws IOException {
		BufferedImage image = producer.createImage(text);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			ImageIO.write(image, "png", out);
			return Base64.getEncoder().encodeToString(out.toByteArray());
		}
	}

	public boolean valid(String kaptchaText) {
		return kaptchaText != null && Objects.equals(kaptchaText, text);
	}
}
