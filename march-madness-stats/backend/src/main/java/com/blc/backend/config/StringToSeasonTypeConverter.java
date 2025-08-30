package com.blc.backend.config;

import org.springframework.core.convert.converter.Converter;

import com.blc.backend.model.SeasonType;

public class StringToSeasonTypeConverter implements Converter<String, SeasonType> {
    @Override
    public SeasonType convert(String source) {
        return SeasonType.fromValue(source);
    }
}