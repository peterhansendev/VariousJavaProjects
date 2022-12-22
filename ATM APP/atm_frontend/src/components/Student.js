import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Button, Container, Paper } from "@mui/material";
import AtmFunctions from "./AtmFunctions";

export default function Student() {
  const paperStyle = { padding: "20px 20px", width: 600, margin: "20px auto" };
  const [firstName, setFirstName] = React.useState("");
  const [lastName, setLastName] = React.useState("");
  const [initialDeposit, setInitialDeposit] = React.useState("");
  const [customer, setCustomer] = React.useState("");
  console.log(customer);
  const [id, setId] = React.useState([]);
  //const classes = useStyles();

  const handleClick = (e) => {
    e.preventDefault();
    const customer = { firstName, lastName, initialDeposit };

    fetch("http://localhost:8080/customers/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(customer),
    }).then(() => {
      console.log("new customer added");
    });
  };
  /*
  useEffect(() => {
    fetch("http://localhost:8080/customers/getAll")
      .then((res) => res.json())
      .then((result) => {
        setCustomers(result);
      });
  }, [customers]); */

  const handleClickId = (e) => {
    e.preventDefault();
    fetch(`http://localhost:8080/customers/id/${id}`)
      .then((res) => res.json())
      .then((result) => {
        setCustomer(result);
      });
  };

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{ color: "blue" }}>
          <u>Sign Up</u>
        </h1>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 0, mb: 2 },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="outlined-basic"
            label="First Name"
            variant="outlined"
            fullWidth
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Last Name"
            variant="outlined"
            fullWidth
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Initial Deposit"
            variant="outlined"
            fullWidth
            value={initialDeposit}
            onChange={(e) => setInitialDeposit(e.target.value)}
          />
          <Button variant="contained" color="secondary" onClick={handleClick}>
            Submit
          </Button>
        </Box>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1 style={{ color: "blue" }}>
          <u>Exsisting Customer</u>
        </h1>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 0, mb: 2 },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="outlined-basic"
            label="ID"
            variant="outlined"
            fullWidth
            value={id}
            onChange={(e) => setId(e.target.value)}
          />

          <Button variant="contained" color="secondary" onClick={handleClickId}>
            Submit
          </Button>
        </Box>
      </Paper>

      <h1>User</h1>
      <Paper elevation={3} style={paperStyle}>
        <Paper
          elevation={6}
          style={{ margin: "10px", padding: "15px", textAlign: "left" }}
        >
          Id: {customer.id} <br />
          Name: {customer.firstName} <br />
          Balance: {customer.initialDeposit} <br />
        </Paper>
      </Paper>

      <AtmFunctions />
    </Container>
  );
}

/*
  <h1>Students</h1>
      <Paper elevation={3} style={paperStyle}>
        {customers.map((student) => (
          <Paper
            elevation={6}
            style={{ margin: "10px", padding: "15px", textAlign: "left" }}
            key={student.id}
          >
            Id: {student.id} <br />
            Name: {student.name} <br />
            Address: {student.address} <br />
          </Paper>
        ))}
      </Paper> */
