package tenten0213.todo;

import tenten0213.entity.TodoEntity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class TodoService {

    @PersistenceContext
    private EntityManager em;

    public TodoEntity save(TodoEntity entity) {
        em.persist(entity);
        return entity;
    }

    public List<TodoEntity> findAll() {
        TypedQuery<TodoEntity> query = em.createNamedQuery("todo_findAll", TodoEntity.class);
        query.setMaxResults(10);
        return query.getResultList();
    }

    public void delete(Long todoId) {
        TodoEntity entity = em.find(TodoEntity.class, todoId);
        em.remove(entity);
    }
}
