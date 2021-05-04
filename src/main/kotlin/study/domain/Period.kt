package study.domain

import java.time.LocalDateTime
import javax.persistence.Embeddable

@Embeddable
class Period (
    var startDate : LocalDateTime,
    var endDate : LocalDateTime
        )