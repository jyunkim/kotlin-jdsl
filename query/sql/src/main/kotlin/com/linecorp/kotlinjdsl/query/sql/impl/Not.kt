package com.linecorp.kotlinjdsl.query.sql.impl

import com.linecorp.kotlinjdsl.Internal
import com.linecorp.kotlinjdsl.query.sql.Predicate

@Internal
data class Not(
    val predicate: Predicate,
) : Predicate
