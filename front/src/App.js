import React from 'react';
import { Form } from './component/Form';
import { FormCategory } from './component/FormCategory';
import { StoreProvider } from './component/initialState';
import { List } from './component/List';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <FormCategory/>
    <Form />
    <List />
  </StoreProvider>
}

export default App;
