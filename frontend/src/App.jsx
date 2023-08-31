import './App.css';
import Todobody from './components/Todobody';

function App() {
  return (
    <div className='w-screen h-screen flex justify-center '>
      <div className=' bg-white p-8 rounded-lg w-2/5 h-max relative top-32'>
        <h1 className='font-semibold text-2xl mb-6 text-gray-600'>Things Todo 📝</h1>
        <Todobody/>
      </div>
    </div>
  );
}

export default App;
