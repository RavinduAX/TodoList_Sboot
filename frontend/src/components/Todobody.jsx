import React from 'react'

const Todobody = () => {
   return (
      <div>
         <div className='border-2 border-indigo-600 flex justify-between'>
            <input type="text" placeholder='Add your task' className='w-full focus:outline-none p-2'/>
            <button className='py-1 px-6 bg-indigo-600 text-white'>Add</button>
         </div>
      </div>
   )
}

export default Todobody
