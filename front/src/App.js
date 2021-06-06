import React from 'react';
import { StoreProvider } from './component/Store';
import { Form } from './component/Form';
import { List } from './component/List';
// import { FormCategory }  from './component/FormCategory';
// import { FormCategoryList } from './component/FormCategoryList';

function App() {
  return <StoreProvider >

    <div className="container">
      <h3 >To-Do List</h3> 
        {/* <FormCategory/>
        <FormCategoryList /> */}
        <Form />
        <List />
    </div>
    
  </StoreProvider>
}

export default App;
