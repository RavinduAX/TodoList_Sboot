import React from 'react'
import Todobox from './Todobox'
import TodoInput from './TodoEdit'

const Todobody = () => {
   return (
      <div>
         <div className='border-2 border-gray-600 flex justify-between mb-12'>
            <input type="text" placeholder='Add your task' className='w-full focus:outline-none p-2' />
            <button className='py-1 px-6 bg-gray-600 text-white'>Add</button>
         </div>
         <Todobox/>
         <Todobox/>
      </div>
   )
}

export default Todobody
