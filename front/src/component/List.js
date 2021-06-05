import React, { useContext, useEffect } from 'react';
import { HOST_API } from "../util/HOST_API";
import { Store } from "./initialState";

export const List = () => {
  const { dispatch, state: { todo } } = useContext(Store);
  const currentList = todo.list;

  useEffect(() => {
    fetch(HOST_API + "/todos")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todo", {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo });
  };

  const onChange = (event, todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      completed: event.target.checked
    };
    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
      });
  };

  const decorationDone = {
    textDecoration: 'line-through'
  };
  return <div>
    <table className="table table-striped table-hover">
      <thead className="table-dark">
        <tr>
          <td >ID</td>
          <td>Tarea</td>  
          <td>¿Completado?</td>
          <td>Acciones</td>
        </tr>
      </thead>
      <tbody>
        {currentList.map((todo) => {
          return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
            <td>{todo.id}</td>
            <td>{todo.name}</td>
            <td ><input class="form-check-input text-align: center" type="checkbox" value="" id="flexCheckDefault" type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
            <div class="d-grid gap-2 d-md-flex justify-content-md-start">
              <button type="button" class="btn btn-danger" onClick={() => onDelete(todo.id)}>Eliminar</button>
              <button type="button" class="btn btn-primary" onClick={() => onEdit(todo)}>Editar</button>
            </div>
          </tr>;
        })}
      </tbody>
    </table>
  </div>;
};
