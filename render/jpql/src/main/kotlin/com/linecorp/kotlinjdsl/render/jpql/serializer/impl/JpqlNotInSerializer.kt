package com.linecorp.kotlinjdsl.render.jpql.serializer.impl

import com.linecorp.kotlinjdsl.iterable.IterableUtils
import com.linecorp.kotlinjdsl.querymodel.jpql.predicate.impl.JpqlNotIn
import com.linecorp.kotlinjdsl.render.RenderContext
import com.linecorp.kotlinjdsl.render.jpql.serializer.JpqlRenderSerializer
import com.linecorp.kotlinjdsl.render.jpql.serializer.JpqlSerializer
import com.linecorp.kotlinjdsl.render.jpql.writer.JpqlWriter
import kotlin.reflect.KClass

class JpqlNotInSerializer : JpqlSerializer<JpqlNotIn<*>> {
    override fun handledType(): KClass<JpqlNotIn<*>> {
        return JpqlNotIn::class
    }

    override fun serialize(part: JpqlNotIn<*>, writer: JpqlWriter, context: RenderContext) {
        val delegate = context.getValue(JpqlRenderSerializer)

        if (IterableUtils.isEmpty(part.compareValues)) {
            return
        }

        writer.write("NOT IN")
        writer.write(" ")
        writer.write("(")
        writer.writeEach(part.compareValues, separator = ", ") {
            delegate.serialize(it, writer, context)
        }
        writer.write(")")
    }
}
