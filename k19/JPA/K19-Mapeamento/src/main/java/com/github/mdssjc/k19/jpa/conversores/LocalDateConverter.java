package com.github.mdssjc.k19.jpa.conversores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

  @Override
  public Date convertToDatabaseColumn(final LocalDate attribute) {
    return Date.from(attribute.atStartOfDay()
                              .atZone(ZoneId.systemDefault())
                              .toInstant());
  }

  @Override
  public LocalDate convertToEntityAttribute(final Date dbData) {
    return LocalDateTime.ofInstant(dbData.toInstant(),
        ZoneId.systemDefault())
                        .toLocalDate();
  }
}
