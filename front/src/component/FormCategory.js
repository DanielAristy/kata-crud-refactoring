import React, { useContext, useRef, useState } from 'react';
import { HOST_API } from "../util/HOST_API";
import { Store } from "./initialState";

export const FormCategory = () => {
    const formRef = useRef(null);
    const { dispatch, state: { category } } = useContext(Store);
    const item = category.item;
    const [state, setState] = useState(category);
  
    const onAdd = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: null
      };
  
      fetch(HOST_API + "/category", {
        method: "POST",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((category) => {
          dispatch({ type: "add-item", item: category });
          setState({ name: "" });
          formRef.current.reset();
        });
    };
  
    const onEdit = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: item.id
      };
  
  
      fetch(HOST_API + "/category", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((category) => {
          dispatch({ type: "update-item", item: category });
          setState({ name: "" });
          formRef.current.reset();
        });
    };
  
    return <form ref={formRef}>
      <input
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value });
        }}></input>
      {item.id && <button onClick={onEdit}>Actualizar</button>}
      {!item.id && <button onClick={onAdd}>Crear</button>}
    </form>;
  };