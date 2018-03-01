package com.pakotzy.various;

import com.pakotzy.various.feature.Feature;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Component
@Validated
@ConfigurationProperties
public class SettingsProvider {

	@Valid
    private List<Feature> features;

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> menus) {
		this.features = menus;
	}

	@Override
	public String toString() {
		return "SettingsProvider{\n" +
				features +
				"\n}";
	}
}
