import React, { useState } from 'react'
import { MdDelete } from "react-icons/md";
import { MdEdit } from "react-icons/md";

const Todobox = () => {
   const [completed, setCompleted] = useState(false);

   const toggleComplete = () => {
      setCompleted(!completed);
   }

   return (
      <div>
         <div className='border-2 border-indigo-600 flex justify-between items-center my-3'>
            <p className={`p-2 pointerDefault ${completed ? 'taskDone' : ''}`} onClick={toggleComplete}>Go to Home</p>
            <div className='me-2 space-x-1'>
               <button className='p-1 text-indigo-600 text-xl'><MdEdit /></button>
               <button className='p-1 text-indigo-600 text-xl'><MdDelete /></button>
            </div>
         </div>
      </div>
   )
}

export default Todobox
