import React, { useContext, useRef, useEffect } from 'react';
import { Form } from './Form';
import { HOST_API } from "../util/HOST_API";
import { Store } from "./initialState";
import { List } from './List';

export const FormCategoryList = () => {
    const { dispatch, state: { categoryList } } = useContext(Store);
    const lista = categoryList.list;

    useEffect(() => {
        fetch(HOST_API + "/categories")
          .then(response => response.json())
          .then((list) => {
            dispatch({ type: "add-category", list: list });
          });
    }, [dispatch]);
  
    return (
        <>
        {
            lista.map((categoryList) => {
                return (
                    <div key={categoryList.id_category}>
                        <h2>{categoryList.name}</h2>{/*Nombre de la categoria*/}
                        <button>Eliminar</button>
                        <Form id={categoryList.id_category} />
                        <List id={categoryList.id_category} listCategory={categoryList.todos}/>
                    </div>
                )
            })
        }
        </>
    )
};
