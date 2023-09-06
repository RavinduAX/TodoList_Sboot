import React, { useState } from 'react'
import axios from 'axios';

const TodoEdit = ({ todo, getTodos, setEdit }) => {

   const[text, setText] = useState('')
   
   const handleEditClick = (e, id) => {
      e.preventDefault();
      const editTodo = {id:id, todo:text}
      axios.put(`http://localhost:8080/api/v1/todo/${id}`, editTodo)
         .then(res => { res.data.code === '200' && alert(res.data.msg); getTodos(); setEdit(false) })
         .catch(err => console.log(err))
   }

  return (
     <div className='border-2 border-green-600 flex justify-between mb-3'>
        <input type="text" onChange={(e)=>{setText(e.target.value)}}  placeholder={todo.todo} className='w-full focus:outline-none p-2' value={text} />
        <button onClick={(e) => { handleEditClick(e, todo.id) }} className='py-1 px-6 bg-green-500 text-white'>Edit</button>
     </div>
  )
}

export default TodoEdit
