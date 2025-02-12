package com.linecorp.kotlinjdsl.render.jpql.introspector

import com.linecorp.kotlinjdsl.SinceJdsl
import kotlin.reflect.KClass

/**
 * Interface to get the entity information by introspecting KClass.
 */
@SinceJdsl("3.0.0")
interface JpqlIntrospector {
    /**
     * Introspects the KClass to get the entity information.
     * If it cannot introspect this KClass, it returns null.
     */
    @SinceJdsl("3.0.0")
    fun introspect(type: KClass<*>): JpqlEntityDescription?
}
