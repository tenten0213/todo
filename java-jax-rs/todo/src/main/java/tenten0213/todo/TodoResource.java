package tenten0213.todo;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * TODOリソースの操作用API提供
 * 一覧取得
 * 作成
 * 1件取得
 * 更新
 * 削除
 */
@Path("/todos")
@RequestScoped
public class TodoResource {
}
