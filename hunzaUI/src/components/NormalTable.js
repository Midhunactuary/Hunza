import axios from 'axios'
import {useStyles} from '../styles/Main';
import { useEffect, useState } from 'react'

import { Button, Grid, TextField, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@material-ui/core';

const response = {"id":"620f98c1bed1b3549612f4b0","name":"xxx","location":{"city":"chenn","postalCode":"m333","street":"rama"},"capacity":{"minimumGuests":2,"maximumGuests":5},"contactInfo":{"phoneNumber":"","mobileNumber":"","email":"aa@gm.c"}}

export default function NormalTable(props) {



  const classes = useStyles();
  const [getById, setGetById] = useState("");  
  const [getByName, setGetByName] = useState("");

  //620f98c1bed1b3549612f4b0

  useEffect(()=>{
    console.log("reeee ", props.response);

  });

  return (
    <>
    <TableContainer>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>{props.response.id}</TableCell>
            <TableCell align="right">Calories</TableCell>
            <TableCell align="right">Fat&nbsp;(g)</TableCell>
            <TableCell align="right">Carbs&nbsp;(g)</TableCell>
            <TableCell align="right">Protein&nbsp;(g)</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          <TableRow>
            <TableCell>Dessert (100g serving)</TableCell>
            <TableCell align="right">Calories</TableCell>
            <TableCell align="right">Fat&nbsp;(g)</TableCell>
            <TableCell align="right">Carbs&nbsp;(g)</TableCell>
            <TableCell align="right">Protein&nbsp;(g)</TableCell>
          </TableRow>
        </TableBody>
        </Table>
        </TableContainer>
    </>

  );
}

