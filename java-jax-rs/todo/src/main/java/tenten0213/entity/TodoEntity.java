package tenten0213.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "todo")
@NamedQuery(
        name = "todo_findAll",
        query = "select t from TodoEntity t order by t.updatedTime desc"
)
public class TodoEntity {

    @Id @GeneratedValue @Column(name = "id")
    private Long todoId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 200)
    private String descrption;

    @Column(nullable = false)
    private Timestamp updatedTime;

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    @PrePersist
    @PreUpdate
    public void pre() {
        this.updatedTime = new Timestamp(System.currentTimeMillis());
    }

}
