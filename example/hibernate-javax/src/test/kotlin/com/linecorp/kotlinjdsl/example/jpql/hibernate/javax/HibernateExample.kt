package com.linecorp.kotlinjdsl.example.jpql.hibernate.javax

import com.linecorp.kotlinjdsl.querymodel.jpql.delete.DeleteQuery
import com.linecorp.kotlinjdsl.querymodel.jpql.select.SelectQuery
import com.linecorp.kotlinjdsl.querymodel.jpql.update.UpdateQuery
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.support.hibernate.extension.createQuery
import javax.persistence.EntityManager
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

abstract class HibernateExample {
    protected val entityManager: EntityManager = Persistence.createEntityManagerFactory("example").createEntityManager()
    private val renderContext = JpqlRenderContext()

    protected fun <T : Any> EntityManager.createQuery(query: SelectQuery<T>) = entityManager.createQuery(
        query,
        renderContext,
    )
    protected fun <T : Any> EntityManager.createQuery(query: UpdateQuery<T>) = entityManager.createQuery(
        query,
        renderContext,
    )
    protected fun <T : Any> EntityManager.createQuery(query: DeleteQuery<T>) = entityManager.createQuery(
        query,
        renderContext,
    )

    protected fun withTransaction(block: () -> Any) {
        val transaction: EntityTransaction = entityManager.transaction
        transaction.begin()

        try {
            block()
        } finally {
            transaction.rollback()
        }
    }
}
