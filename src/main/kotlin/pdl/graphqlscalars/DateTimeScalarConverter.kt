package pdl.graphqlscalars

import com.expediagroup.graphql.client.converter.ScalarConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateTimeScalarConverter : ScalarConverter<LocalDateTime> {
    override fun toJson(value: LocalDateTime): String = value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    override fun toScalar(rawValue: String): LocalDateTime = LocalDateTime.parse(rawValue, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
}