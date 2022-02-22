import axios from 'axios'
import {useStyles} from './styles/App';
import { useEffect, useState } from 'react'

import { Typography } from '@material-ui/core';
import Main from './components/Main';


function App() {

  const classes = useStyles();

  useEffect(() => {
    let reqParams = {
      "params": {
        "name": "ccc"
      }
    }
    axios.get("http://localhost:8080/api/caterers?id=620f98c1bed1b3549612f4b0", {}).then(res => {
      console.log(res)
    })

  }, [])
  return (
    <div className="App">
      <Typography variant="h3" component="h2" className={classes.header}>
        Hunza
      </Typography>
      <Main/>
      
      
    </div>
  );
}

export default App;
