import React, { useState } from 'react'
import { MdDelete } from "react-icons/md";
import { MdEdit } from "react-icons/md";
import TodoEdit from './TodoEdit';
import axios from 'axios';

const Todobox = ({todo, getTodos}) => {
   const [completed, setCompleted] = useState(false);
   const [edit, setEdit] = useState(false);

   const toggleComplete = () => {
      setCompleted(!completed);
   }

   const toggleEdit = () => {
      setEdit(!edit)
   }

   const handleDeleteClick = (e, id) => {
      e.preventDefault();
      axios.delete(`http://localhost:8080/api/v1/todo/${id}`)
         .then(res => { res.data.code === '200' && alert(res.data.msg); getTodos(); })
         .catch(err => console.log(err))
   }

   return (
      <div>
         {!edit ?
            <div className='bg-green-500 flex justify-between items-center my-3 ps-2'>
               <p className={`p-2 pointerDefault text-white ${completed ? 'taskDone' : ''}`} onClick={toggleComplete}>{todo.todo}</p>
               <div className='me-2 space-x-1'>
                  <button className='p-1 text-white text-xl' onClick={toggleEdit}><MdEdit /></button>
                  <button className='p-1 text-white text-xl' onClick={(e)=>handleDeleteClick(e, todo.id)}><MdDelete /></button>
               </div>
            </div>
            :
            <TodoEdit todo={todo} getTodos={getTodos} setEdit={setEdit}/>
         }

      </div>
   )
}

export default Todobox
