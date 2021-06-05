import React, { useContext, useRef, useState } from 'react';
import { HOST_API } from '../util/HOST_API';
import { Store } from "./initialState";

export const Form = () => {
  const formRef = useRef(null);
  const { dispatch, state: { todo, id, listCategory } } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      completed: false,
      category: null
    };


    fetch(HOST_API + "/todo", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
      category: item.category
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
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return <form className="container" ref={formRef}>
    <input 
      class="form-control"
      type="text"
      name="name"
      placeholder="¿Qué piensas hacer hoy?"
      defaultValue={item.name}
      onChange={(event) => {
        setState({ ...state, name: event.target.value });
      }}></input>
      <div className="d-grid gap-2 col-6 mx-auto">
        {item.id && <button type="button" class="btn btn-info btn-lg center-block" onClick={onEdit}>Actualizar</button>}
        {!item.id && <button type="button" class="btn btn-success btn-lg" onClick={onAdd}>Crear</button>}
      </div>
    
    

  </form>;
};
