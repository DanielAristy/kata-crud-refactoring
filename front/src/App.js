import React from 'react';
import { StoreProvider } from './component/initialState';
import { FormCategory } from '../src/component/FormCategory'
import { FormCategoryList } from './component/FormCategoryList';
import { Form } from './component/Form';
import { List } from './component/List';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
      {/* <FormCategory/>
      <FormCategoryList /> */}
      <Form />
      <List />
  </StoreProvider>
}

export default App;
