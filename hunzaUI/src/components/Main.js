import NormalTable from './NormalTable';
import axios from 'axios'
import {useStyles} from '../styles/Main';
import { useEffect, useState } from 'react'

import { Button, Grid, Modal, TextField, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@material-ui/core';

let data = [];

export default function Main() {

  const classes = useStyles();
  const [getDataBy, setGetDataBy] = useState("");  
  const [getByValue, setGetByValue] = useState("");

  const [response, setResponse] = useState({})
  const [header, setHeader] = useState([]);
  const [rowData, setRowData] = useState([]);
  const [modalOpen, setModalOpen] = useState(false)
   
  //620f98c1bed1b3549612f4b0

  const keyify = (obj, prefix = '') => 
  Object.keys(obj).reduce((res, el) => {
    if( Array.isArray(obj[el]) ) {
      return res;
    } else if( typeof obj[el] === 'object' && obj[el] !== null ) {
      return [...res, ...keyify(obj[el], prefix + el + '.')];
    }
    //return [...res, prefix + el];
    return [...res, el];
  }, []);

  const getTableValue = (obj) => {
      
    for (var key in obj) {
        if (typeof obj[key] === "object") {
            getTableValue(obj[key]);   
        } else {
            data.push(obj[key]); 
            console.log('val :: ', obj[key])   
        }
    }
    
}

const style = {
    position: 'absolute',
    padding: "20px",
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    maxHeight: 500,
    overflow: 'auto',
    background: "#fff"
  };

  function sendData() {
    data = [];
    
    let url = "http://localhost:8080/api/caterers";

    //chenn?page=0&size=2

    var obj = {};
    
    if(getDataBy === "city") {
        url += "/" + getByValue;
        obj["page"] = 0;
        obj["size"] = 2;
        
    } else {
        obj[getDataBy] = getByValue;

    }
    
    let reqParams = {
        "params": obj
      }
      axios.get(url, reqParams).then(res => {
        console.log(res)
        setResponse(res.data)

        const headers = keyify(res.data);
        console.log("headers :: ", headers)

        getTableValue(res.data);
        
        setHeader(headers)
        setRowData(data)
      })
  
  }

  const addData = () => {
    setModalOpen(true)
  }

  return (
    <>
    <Grid container spacing={2}>
      <Grid item xs={12} sm={6}>
      <TextField
                variant="outlined"
                margin="dense"
                fullWidth
            select
            SelectProps={{
              native: true
            }}
            label="Get data by"
            name="getDataBy"
            onChange={(event)=>{ setGetDataBy(event.target.value)}}
           /* value={gender.value}
            onChange={handleChange}
            error={!!gender.error}
            helperText={gender.error}*/
            //required={gender.required}
            /*error={getDataBy != "" ? false : true}
            helperText={getDataBy != "" ? "" : "Please Select the Get data by" }
            required={true} */
          >
            <option value=""> </option>
            <option value="id">ID</option>
            <option value="name">Name</option>
            <option value="city">City</option>
          </TextField>

      </Grid>
    
        <Grid item xs={12} sm={6}>
        <TextField
          variant="outlined"
          margin="dense"
          fullWidth
          label="Enter the value"
          name="getByValue"
          placeholder=""
          onChange={(event)=>{ setGetByValue(event.target.value)}}
         /* value={firstName.value}
          onChange={handleChange}
          error={!!firstName.error}
          helperText={firstName.error} */
         /* error={getByValue != "" ? false : true}
          helperText={getByValue != "" ? "" : "Please Enter the value" }
          required={true} */
        />
      </Grid>
    <div >
      <Button onClick={() => {sendData()}}>
          Get Data
      </Button>

      <Button onClick={() => {addData()}}>
          Add Data
      </Button>

      </div>
      </Grid>
    
      <TableContainer>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead style={{textTransform: "capitalize"}}>
          <TableRow>
             {
                 header.map(val => <TableCell>{val}</TableCell>)
             }
            
          </TableRow>
        </TableHead>
        <TableBody>
          <TableRow>
          {
                 rowData.map(val => <TableCell>{val}</TableCell>)
             }
            
            </TableRow>
        </TableBody>
        </Table>
        </TableContainer>   
        <Modal
        aria-labelledby="transition-modal-title"
        aria-describedby="transition-modal-description"
        open={modalOpen}
        onClose={() => setModalOpen(false)}
       // closeAfterTransition
       // BackdropComponent={Backdrop}
        
      >
          <div style={style}>
              {
                  header.map((value) =>  <Grid item xs={12} sm={6}>
                  <TextField
                    variant="outlined"
                    margin="dense"
                    fullWidth
                    label={value}
                    placeholder=""
                   // onChange={(event)=>{ setGetByValue(event.target.value)}}
                 
                  />
                </Grid>)
              }
          
          <Button onClick={() => {sendData()}}>
          save Data
      </Button>

          </div>



          </Modal>


      </>


  );
}

