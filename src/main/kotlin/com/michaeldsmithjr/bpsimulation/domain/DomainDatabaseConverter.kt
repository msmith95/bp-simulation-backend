package com.michaeldsmithjr.bpsimulation.domain

import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class DomainDatabaseConverter: AttributeConverter<Domain?, String> {
    override fun convertToDatabaseColumn(domain: Domain?): String {
        return domain?.id ?: ""
    }

    override fun convertToEntityAttribute(dbData: String?): Domain? {
        return Domain.fromJson(dbData ?: "")
    }
}
