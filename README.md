# tapestry-kaptcha

Tapestry 5 Module with a Kaptcha Component based on [kaptcha](https://github.com/heanbian/kaptcha).

## Usage

### AppModule

```java
@ImportModule(KaptchaModule.class)
public class AppModule {
```

### Component

```java
	@Component(parameters = { "value=kaptchaText" })
	private TextField kaptchaField;

	@Component
	private Kaptcha kaptcha;

	@Environmental
	private ValidationTracker validationTracker;

	void onValidateFromKaptchaField(String kaptchaText) {
		if (!kaptcha.valid(kaptchaText)) {
			validationTracker.recordError(kaptchaField, "Ungültige Eingabe");
		}
	}
```

### Template

```xml
	<div class="row g-3 mb-3">
		<div class="col">
			<div t:id="kaptcha"></div>
		</div>
	</div>
	<div class="row g-3 mb-3">
		<div class="col">
			<input t:id="kaptchaField" class="form-control"
				placeholder="Kaptcha Text" aria-label="Kaptcha Text" />
		</div>
	</div>
```

