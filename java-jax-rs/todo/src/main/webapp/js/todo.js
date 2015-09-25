var todo = {};

todo.Todo = function(data) {
    this.description = m.prop(data.description);
    this.done = m.prop(false);
};

todo.TodoList = Array;

// ビュー・モデル
todo.vm = (function () {
    var vm = {}
    vm.init = function () {
        // アクティブなToDoのリスト
        vm.list = new todo.TodoList();

        // 新しいToDo作成用
        vm.description = m.prop("");

        // ToDoをリストに登録する
        vm.add = function () {
            if (vm.description()) {
                vm.list.push(new todo.Todo({description: vm.description()}));
                vm.description("");
            }
        };
    }
    return vm
}())

// コントローラ
// モデルのどの部分が現在のページと関連するのかを定義する
// この場合は1つのビュー・モデルですべてを取り仕切っている
todo.controller = function () {
    todo.vm.init()
}

// ビュー
todo.view  = function () {
    return m("html", [
        m("body", [
            m("input", {onchange: m.withAttr("value", todo.vm.description), value: todo.vm.description()}),
            m("button", {onclick: todo.vm.add}, "追加"),
            m("table", [
                todo.vm.list.map(function (task, index) {
                    return m("tr", [
                        m("td", [
                            m("input[type=checkbox]", {onclick: m.withAttr("checked", task.done), checked: task.done()})
                        ]),
                        m("td", {style: {textDecoration: task.done() ?"line-through" : "none"}}, task.description()),
                    ])
                })
            ])
        ])
    ]);
};

// アプリケーションの初期化
m.mount(document, {controller: todo.controller, view: todo.view});