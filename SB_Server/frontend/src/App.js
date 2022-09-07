// import React, {useEffect, useState} from 'react';
// import axios from 'axios';

import React from 'react';
import logo from './logo.svg';
import './App.css';
import Clock from './Clock';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
            <Clock />
        </div>
    );
}
export default App;

// function App() {
//   const [hello, setHello] = useState('')
//
//   useEffect(() => {
//     axios.get('http://localhost:8080/posts')
//         .then(response => setHello(response.data))
//         .catch(error => console.log(error))
//   }, []);
//
//   return (
//       <div>
//         백엔드에서 가져온 데이터입니다 : {hello}
//       </div>
//   );
// }
//
