package com.linecorp.kotlinjdsl.query.sql

import com.linecorp.kotlinjdsl.SinceJdsl

@SinceJdsl("3.0.0")
interface InsertQuery<T : Any> : SqlQuery<InsertQuery<T>>
