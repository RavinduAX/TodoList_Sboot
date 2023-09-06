import React, { useEffect, useState } from 'react'
import Todobox from './Todobox'
import axios from 'axios'
import { v4 as uuidv4 } from 'uuid';

const Todobody = () => {
   const [todos, setTodos] = useState([]);
   const [text, setText] = useState('')

   useEffect(() => {
      getTodos();
   }, []);

   // get all todos
   const getTodos = () => {
      axios.get('http://localhost:8080/api/v1/todo/')
         .then(res => res.data.code === '200' && setTodos(res.data.payload))
         .catch(err => console.log(err))
   }

   const handleAddClick = (e) => {
      e.preventDefault();
      let id = uuidv4();
      //add todo
      const newTodo = { id:id, todo:text }
      axios.post('http://localhost:8080/api/v1/todo/', newTodo)
         .then(res => { res.data.code === '200' && alert(res.data.msg); getTodos(); setText('') })
         .catch(err => console.log(err))
      
   }

   return (
      <div>
         <div className='border-2 border-green-600 flex justify-between mb-12'>
            <input onChange={(e) => { setText(e.target.value) }} value={text} type="text" placeholder='Add your task' className='w-full focus:outline-none p-2' />
            <button onClick={handleAddClick} className='py-1 px-6 bg-green-500 text-white'>Add</button>
         </div>
         <div className='overflow-y-scroll max-h-[20rem]'>
            {todos.map((todo) => (
               <Todobox key={todo.id} todo={todo} getTodos={getTodos} />
            ))}
         </div>

      </div>
   )
}

export default Todobody
