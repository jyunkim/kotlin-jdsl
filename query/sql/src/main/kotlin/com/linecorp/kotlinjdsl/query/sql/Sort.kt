package com.linecorp.kotlinjdsl.query.sql

import com.linecorp.kotlinjdsl.SinceJdsl
import com.linecorp.kotlinjdsl.query.QueryPart

@SinceJdsl("3.0.0")
interface Sort : QueryPart {
    enum class Order {
        ASC,
        DESC,
    }
}
