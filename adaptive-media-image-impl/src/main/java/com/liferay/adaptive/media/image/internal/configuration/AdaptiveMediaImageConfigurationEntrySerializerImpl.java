/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.adaptive.media.image.internal.configuration;

import com.liferay.adaptive.media.image.configuration.AdaptiveMediaImageConfigurationEntry;
import com.liferay.adaptive.media.image.configuration.AdaptiveMediaImageConfigurationEntrySerializer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	service = AdaptiveMediaImageConfigurationEntrySerializer.class
)
public class AdaptiveMediaImageConfigurationEntrySerializerImpl
	implements AdaptiveMediaImageConfigurationEntrySerializer {

	@Override
	public AdaptiveMediaImageConfigurationEntry deserialize(String s) {
		return _configurationEntryParser.parse(s);
	}

	@Override
	public String serialize(
		AdaptiveMediaImageConfigurationEntry configurationEntry) {

		return _configurationEntryParser.getConfigurationString(
			configurationEntry);
	}

	@Reference
	private AdaptiveMediaImageConfigurationEntryParser
		_configurationEntryParser;

}